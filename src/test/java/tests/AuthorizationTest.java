package tests;

import org.testng.annotations.Test;
import pages.CommonPage;
import pages.LoginPage;
import utils.WaitUtils;

import java.util.ArrayList;
import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class AuthorizationTest extends BaseTest {

    @Test
    public void regularUserAdminURL() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.loginAsRegularUser();

        driver.get("https://festodeskmanagementqa.azurewebsites.net/Admin");
        WaitUtils.waitUntilSpecificURL(driver, 5, "https://festodeskmanagementqa.azurewebsites.net/");
    }

    @Test
    public void regularUserReportsURL() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.loginAsRegularUser();

        driver.get("https://festodeskmanagementqa.azurewebsites.net/Reports");
        WaitUtils.waitUntilSpecificURL(driver, 5, "https://festodeskmanagementqa.azurewebsites.net/");
    }

    @Test
    public void regularUserMenuLinks() {
        CommonPage commonPage = new CommonPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.loginAsRegularUser();

        WaitUtils.waitUntilElementPresent(driver, 5, commonPage.getHeader());
        ArrayList<String> visibleHeaderMenuLinks = commonPage.getVisibleHeaderMenuLinks();
        ArrayList<String> regularUserHeaderMenuLinks = new ArrayList<String>(Arrays.asList("Home", "Rooms"));
        assertEquals(visibleHeaderMenuLinks, regularUserHeaderMenuLinks);
    }

    @Test
    public void regularUserMenuLinksNumber() {
        CommonPage commonPage = new CommonPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.loginAsRegularUser();

        WaitUtils.waitUntilElementPresent(driver, 5, commonPage.getHeader());
        ArrayList<String> visibleHeaderMenuLinks = commonPage.getVisibleHeaderMenuLinks();
        assertEquals(visibleHeaderMenuLinks.size(), 2);
    }

    @Test
    public void teamLeadAdminURL() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.loginAsTeamLead();

        driver.get("https://festodeskmanagementqa.azurewebsites.net/Admin");
        WaitUtils.waitUntilSpecificURL(driver, 5, "https://festodeskmanagementqa.azurewebsites.net/");
    }

    @Test
    public void teamLeadMenuLinks() {
        CommonPage commonPage = new CommonPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.loginAsTeamLead();

        WaitUtils.waitUntilElementPresent(driver, 5, commonPage.getHeader());
        ArrayList<String> visibleHeaderMenuLinks = commonPage.getVisibleHeaderMenuLinks();
        ArrayList<String> teamLeadHeaderMenuLinks = new ArrayList<String>(Arrays.asList("Home", "Rooms", "Reports"));
        assertEquals(visibleHeaderMenuLinks, teamLeadHeaderMenuLinks);
    }

    @Test
    public void teamLeadMenuLinksNumber() {
        CommonPage commonPage = new CommonPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.loginAsTeamLead();

        WaitUtils.waitUntilElementPresent(driver, 5, commonPage.getHeader());
        ArrayList<String> visibleHeaderMenuLinks = commonPage.getVisibleHeaderMenuLinks();
        assertEquals(visibleHeaderMenuLinks.size(), 3);
    }

    @Test
    public void adminMenuLinks() {
        CommonPage commonPage = new CommonPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.loginAsAdmin();

        WaitUtils.waitUntilElementPresent(driver, 5, commonPage.getHeader());
        ArrayList<String> visibleHeaderMenuLinks = commonPage.getVisibleHeaderMenuLinks();
        ArrayList<String> adminHeaderMenuLinks = new ArrayList<String>(Arrays.asList("Home", "Rooms", "Admin Panel", "Reports"));
        assertEquals(visibleHeaderMenuLinks, adminHeaderMenuLinks);
    }

    @Test
    public void adminMenuLinksNumber() {
        CommonPage commonPage = new CommonPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.loginAsAdmin();

        WaitUtils.waitUntilElementPresent(driver, 5, commonPage.getHeader());
        ArrayList<String> visibleHeaderMenuLinks = commonPage.getVisibleHeaderMenuLinks();
        assertEquals(visibleHeaderMenuLinks.size(), 4);
    }

}


