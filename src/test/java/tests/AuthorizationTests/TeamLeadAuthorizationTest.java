package tests.AuthorizationTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.LoginPage;
import tests.BaseTest;
import utils.ComponentUtils;
import utils.WaitUtils;

import java.util.ArrayList;
import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class TeamLeadAuthorizationTest extends BaseTest {

    @BeforeClass
    public void login() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAsTeamLead();
    }

    @Test
    public void teamLeadAdminURL() {
        ComponentUtils.openPage(driver, "https://festodeskmanagementqa.azurewebsites.net/Admin");
        WaitUtils.waitUntilSpecificURL(driver, 5, "https://festodeskmanagementqa.azurewebsites.net/");
    }

    @Test
    public void teamLeadMenuLinks() {
        CommonPage commonPage = new CommonPage(driver);

        WaitUtils.waitUntilElementPresent(driver, 5, commonPage.getHeader());
        ArrayList<String> visibleHeaderMenuLinks = commonPage.getVisibleHeaderMenuLinks();
        ArrayList<String> teamLeadHeaderMenuLinks = new ArrayList<String>(Arrays.asList("Home", "Rooms", "Reports"));
        assertEquals(visibleHeaderMenuLinks.size(), 3);
        assertEquals(visibleHeaderMenuLinks, teamLeadHeaderMenuLinks);
    }

}
