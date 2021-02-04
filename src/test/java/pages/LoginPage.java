package pages;

import utils.WaitUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //--------Locators----------

    By emailInputField = By.id("i0116");
    By emailSubmitButton = By.id("idSIButton9");

    By passwordInputField = By.id("i0118");
    By loginButton = By.id("idSIButton9");

    By continueLoginButton = By.id("idBtn_Back");

    By messageBlock = By.id("passwordError");

    public void loginWithCredentials(String email, String password) {
        enterEmailAddress(email);
        clickEmailSubmitButton();
        WaitUtils.waitMiliseconds(1500);
        enterPassword(password);
        clickLoginButton();
        WaitUtils.waitMiliseconds(1500);
        clickContinueLoginButton();
        WaitUtils.waitMiliseconds(1500);
    }

    public void clickEmailSubmitButton(){
        driver.findElement(emailSubmitButton).click();
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void clickContinueLoginButton() {
        driver.findElement(continueLoginButton).click();
    }

    public void enterEmailAddress(String email) {
        driver.findElement(emailInputField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInputField).sendKeys(password);
    }

    public Boolean getMessage() {
        return driver.findElement(messageBlock).isDisplayed();
    }

}
