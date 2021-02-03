package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.sql.SQLOutput;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    //----------Locators-----------------
    By userLoginType = new By.ByXPath("//*[@id=\"root\"]/div/div[1]/nav/ul/li[1]");


    public String getUserType()
    {
        String text = driver.findElement(userLoginType).getText();
        String type[] = text.split(" ");

        return type[type.length -1];
    }


}
