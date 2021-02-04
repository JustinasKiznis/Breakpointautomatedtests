package tests;

import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import utils.WaitUtils;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void loginWrongCredentials(){
        LoginPage loginPage = new LoginPage(driver);

        WaitUtils.waitMiliseconds(2000);

        String email = "testas@gmail.com";
        String password = "testas";

        loginPage.loginWithCredentials(email,password);
        Boolean errorAreDisplayed = loginPage.getMessage();
        assertTrue(errorAreDisplayed, "User failed to login");
    }

    @Test
    public void loginWithAdmin(){
        LoginPage loginPage = new LoginPage(driver);
        BasePage BasePage = new BasePage(driver);

        WaitUtils.waitMiliseconds(2000);

        String email = "admin.test@kitm.lt";
        String password = "Akademija20";
        String userType = "Admin";

        loginPage.loginWithCredentials(email,password);

        String actualUserType = BasePage.getUserType();
        assertEquals(actualUserType, userType);
    }

    @Test
    public void loginWithRegular(){
        LoginPage loginPage = new LoginPage(driver);
        BasePage BasePage = new BasePage(driver);

        WaitUtils.waitMiliseconds(2000);

        String email = "regularuser.test@kitm.lt";
        String password = "Akademija20";
        String userType = "Regular";

        loginPage.loginWithCredentials(email,password);

        String actualUserType = BasePage.getUserType();
        assertEquals(actualUserType, userType);
    }

    @Test
    public void loginWithTeamLead(){
        LoginPage loginPage = new LoginPage(driver);
        BasePage BasePage = new BasePage(driver);

        WaitUtils.waitMiliseconds(2000);

        String email = "teamlead.test@kitm.lt";
        String password = "Akademija20";
        String userType = "Teamlead";

        loginPage.loginWithCredentials(email,password);

        String actualUserType = BasePage.getUserType();
        assertEquals(actualUserType, userType);
    }


}
