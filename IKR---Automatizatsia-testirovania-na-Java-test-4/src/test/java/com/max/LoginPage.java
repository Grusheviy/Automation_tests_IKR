package com.max;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterCredentials(String username, String password) {
        driver.findElement(By.cssSelector("#user_email")).sendKeys(username);
        driver.findElement(By.cssSelector("#user_password")).sendKeys(password);
    }

    public void enterEmail(String email) {
        driver.findElement(By.cssSelector("#user_email")).sendKeys(email);
    }

    public void clickLoginButton() {
        driver.findElement(By.cssSelector("input[value='Войти'][type='submit']")).click();
    }

    public boolean isEmailErrorDisplayed() {
        return !driver.findElements(By.cssSelector("#parsley-id-5 > li")).isEmpty();
    }

    public WebElement getEmailErrorElement() {
        return driver.findElement(By.cssSelector("#parsley-id-5 > li"));
    }
    public boolean isEmailErrorContainsMessage(String expectedErrorMessage) {
        String actualEmailErrorMessage = getEmailErrorElement().getText();
        return actualEmailErrorMessage.contains(expectedErrorMessage);
    }

    public boolean isPasswordErrorDisplayed() {
        return !driver.findElements(By.cssSelector("#parsley-id-7 > li")).isEmpty();
    }
    public WebElement getPasswordErrorElement() {
        return driver.findElement(By.cssSelector("#parsley-id-7 > li"));
    }
    public boolean isPasswordErrorContainsMessage(String expectedErrorMessage) {
        String actualPassErrorMessage = getPasswordErrorElement().getText();
        return actualPassErrorMessage.contains(expectedErrorMessage);
    }
}
