package tests.LoginTests;

import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import tests.BaseTest;

import static org.testng.Assert.assertEquals;

public class TeamLeadLoginTest extends BaseTest {

    @Test
    public void loginWithTeamLead(){
        LoginPage loginPage = new LoginPage(driver);
        BasePage BasePage = new BasePage(driver);

        //WaitUtils.waitMiliseconds(2000);

        String email = "teamlead.test@kitm.lt";
        String password = "Akademija20";

        String userType = "Teamlead";


        loginPage.loginWithCredentials(email,password);

        String actualUserType = BasePage.getUserType();
        assertEquals(actualUserType, userType);
    }
}
