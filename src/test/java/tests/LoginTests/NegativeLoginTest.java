package tests.LoginTests;


import org.testng.Assert;

import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import tests.BaseTest;
import utils.WaitUtils;

import static org.testng.Assert.*;

public class NegativeLoginTest extends BaseTest {

    @Test
    public void loginWrongCredentials(){
        LoginPage loginPage = new LoginPage(driver);

        boolean logged = true;
        //WaitUtils.waitMiliseconds(2000);
        try {
            String email = "testas@gmail.com";
            String password = "testas";

            loginPage.loginWithCredentials(email,password);
            Boolean errorAreDisplayed = loginPage.getMessage();
            assertFalse(errorAreDisplayed, "User failed to login");
        } catch(org.openqa.selenium.TimeoutException e){
            logged = false;
        }
        assertFalse(logged);
    }
}
