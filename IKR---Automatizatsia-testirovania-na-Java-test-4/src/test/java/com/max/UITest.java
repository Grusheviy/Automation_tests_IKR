package com.max;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class UITest extends AbstractTest{

    @Test
    void testGBNotEmailLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterCredentials("login", "password");
        loginPage.clickLoginButton();

        String expectedEmailErrorMessage = "Введите адрес электронной почты.";
        Assertions.assertTrue(loginPage.isEmailErrorDisplayed());
        Assertions.assertTrue(loginPage.isEmailErrorContainsMessage(expectedEmailErrorMessage));
    }

    @Test
    void testGBWithoutPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("login@login.ru");
        loginPage.clickLoginButton();

        String expectedPassErrorMessage = "Обязательное поле.";
        Assertions.assertTrue(loginPage.isPasswordErrorDisplayed());
        Assertions.assertTrue(loginPage.isPasswordErrorContainsMessage(expectedPassErrorMessage));
    }
}
/*
Оригинальный код из задания
 */
//    @Test
//    void testGBNotEmailLogin() {
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--incognito");
//        //options.addArguments("--headless");
//        options.addArguments("start-maximized");
//        options.addArguments("--remote-allow-origins=*");
//        WebDriver driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//        driver.get("https://gb.ru/login");
//
//        driver.findElement(By.xpath("//*[@id=\"user_email\"]")).sendKeys("login");
//        driver.findElement(By.xpath("//*[@id=\"user_password\"]")).sendKeys("password");
//        driver.findElement(By.xpath("//*[@id=\"new_user\"]/div[4]/input")).click();
//
//        Assertions.assertFalse(driver.findElements(By.xpath("/html/body/div[2]/div[7]/div/form/div[1]/ul")).isEmpty());
//    }
//
//    @Test
//    void testGBWithoutPassword() {
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--incognito");
//        //options.addArguments("--headless");
//        options.addArguments("start-maximized");
//        options.addArguments("--remote-allow-origins=*");
//        WebDriver driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//        driver.get("https://gb.ru/login");
//        driver.findElement(By.xpath("/html/body/div[2]/div[7]/div/form/div[1]/input")).sendKeys("login@login.ru");
//        driver.findElement(By.xpath("/html/body/div[2]/div[7]/div/form/div[4]/input")).click();
//
//        Assertions.assertFalse(driver.findElements(By.xpath("/html/body/div[2]/div[7]/div/form/div[2]/ul")).isEmpty());
//
//    }
