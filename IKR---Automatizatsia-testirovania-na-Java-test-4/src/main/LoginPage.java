import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterCredentials(String username, String password) {
        driver.findElement(By.xpath("/html/body/div[2]/div[7]/div/form/div[1]/input")).sendKeys(username);
        driver.findElement(By.xpath("/html/body/div[2]/div[7]/div/form/div[2]/input")).sendKeys(password);
    }

    public void enterEmail(String email) {
        driver.findElement(By.xpath("/html/body/div[2]/div[7]/div/form/div[1]/input")).sendKeys(email);
    }

    public void clickLoginButton() {
        driver.findElement(By.xpath("/html/body/div[2]/div[7]/div/form/div[4]/input")).click();
    }

    public boolean isEmailErrorDisplayed() {
        return !driver.findElements(By.xpath("/html/body/div[2]/div[7]/div/form/div[1]/ul")).isEmpty();
    }

    public boolean isPasswordErrorDisplayed() {
        return !driver.findElements(By.xpath("/html/body/div[2]/div[7]/div/form/div[2]/ul")).isEmpty();
    }
}
