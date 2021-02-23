package tests.LoginTests;

import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import tests.BaseTest;

import static org.testng.Assert.assertEquals;

public class AdminLoginTest extends BaseTest {

    @Test
    public void loginWithAdmin(){
        LoginPage loginPage = new LoginPage(driver);
        BasePage BasePage = new BasePage(driver);

        //WaitUtils.waitMiliseconds(2000);

        String email = "admin.test@kitm.lt";
        String password = "Akademija20";
        String userType = "Admin";

        loginPage.loginWithCredentials(email,password);

        String actualUserType = BasePage.getUserType();
        assertEquals(actualUserType, userType);
    }
}
