package tests.LoginTests;

import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import tests.BaseTest;

import static org.testng.Assert.assertEquals;

public class RegularUserLoginTest extends BaseTest {

    @Test
    public void loginWithRegular(){
        LoginPage loginPage = new LoginPage(driver);
        BasePage BasePage = new BasePage(driver);

        //WaitUtils.waitMiliseconds(2000);

        String email = "regularuser.test@kitm.lt";
        String password = "Akademija20";
        String userType = "Regular";

        loginPage.loginWithCredentials(email,password);

        String actualUserType = BasePage.getUserType();
        assertEquals(actualUserType, userType);
    }
}
