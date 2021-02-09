package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

import java.sql.SQLOutput;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    //----------Locators-----------------
    By userLoginType = new By.ByXPath("/html/body/div/header/div/nav/ul/li[1]");


    public String getUserType()
    {
        WaitUtils.waitUntilElementDisplayed(driver, 5, userLoginType);
        String text = driver.findElement(userLoginType).getText();
        String userinfo[] = text.split(" \\| ");

        return userinfo[1];
    }



}
