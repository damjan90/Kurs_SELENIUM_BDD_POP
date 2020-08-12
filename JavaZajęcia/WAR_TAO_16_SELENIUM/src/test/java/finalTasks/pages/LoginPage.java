package finalTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private static WebDriver driver;
    private static String email = "xxxx@wp.pl";
    private static String password = "123456";


    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }

    //kliknij na przycisk sign in
    public void clickOnSignInButton() {
        WebElement signInButton = driver.findElement(By.id("_desktop_user_info"));
        signInButton.click();
    }

    public void loginAs() {
        // podaj maila
        WebElement loginInput = driver.findElement(By.name("email"));
        loginInput.clear();
        loginInput.sendKeys(email);

        //podaj hasło
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.clear();
        passwordInput.sendKeys(password);
        //kliknij na przycisk Sign In
        WebElement signInButton = driver.findElement(By.id("submit-login"));
        signInButton.click();
    }

}
