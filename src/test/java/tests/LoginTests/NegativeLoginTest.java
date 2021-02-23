package tests.LoginTests;

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

        //WaitUtils.waitMiliseconds(2000);

        String email = "testas@gmail.com";
        String password = "testas";

        loginPage.loginWithCredentials(email,password);
        Boolean errorAreDisplayed = loginPage.getMessage();
        assertFalse(errorAreDisplayed, "User failed to login");
    }
}
