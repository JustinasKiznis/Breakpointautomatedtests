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

public class RegularUserAuthorizationTest extends BaseTest {

    @BeforeClass
    public void login() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAsRegularUser();
    }

    @Test
    public void regularUserAdminURL() {
        ComponentUtils.openPage(driver, "https://festodeskmanagementqa.azurewebsites.net/Admin");
        WaitUtils.waitUntilSpecificURL(driver, 5, "https://festodeskmanagementqa.azurewebsites.net/");
    }

    @Test
    public void regularUserReportsURL() {
        ComponentUtils.openPage(driver, "https://festodeskmanagementqa.azurewebsites.net/Reports");
        WaitUtils.waitUntilSpecificURL(driver, 5, "https://festodeskmanagementqa.azurewebsites.net/");
    }

    @Test
    public void regularUserMenuLinks() {
        CommonPage commonPage = new CommonPage(driver);

        WaitUtils.waitUntilElementPresent(driver, 5, commonPage.getHeader());
        ArrayList<String> visibleHeaderMenuLinks = commonPage.getVisibleHeaderMenuLinks();
        ArrayList<String> regularUserHeaderMenuLinks = new ArrayList<String>(Arrays.asList("Home", "Rooms"));
        assertEquals(visibleHeaderMenuLinks.size(), 2);
        assertEquals(visibleHeaderMenuLinks, regularUserHeaderMenuLinks);
    }

}


