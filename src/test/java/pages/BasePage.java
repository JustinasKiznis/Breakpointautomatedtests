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
    By userLoginType = new By.ByXPath("//*[@id=\"root\"]/div/header/div/nav/ul/li[1]");


    public String getUserType()
    {
        String text = driver.findElement(userLoginType).getText();
        String userinfo[] = text.split("|");

        String userType = "";
        for(int i = 0; i < userinfo.length; i++)
        {
            if (userinfo[i].equals("|") && userType.equals("")){
                userType = userinfo[i+1];
            }
        }
        return userType;
    }



}
