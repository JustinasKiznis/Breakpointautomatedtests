package tests.AuthorizationTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.LoginPage;
import tests.BaseTest;
import utils.WaitUtils;

import java.util.ArrayList;
import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class AdminAuthorizationTest extends BaseTest {

    @BeforeClass
    public void login() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAsAdmin();
    }

    @Test
    public void adminMenuLinks() {
        CommonPage commonPage = new CommonPage(driver);

        WaitUtils.waitUntilElementPresent(driver, 5, commonPage.getHeader());
        ArrayList<String> visibleHeaderMenuLinks = commonPage.getVisibleHeaderMenuLinks();
        ArrayList<String> adminHeaderMenuLinks = new ArrayList<String>(Arrays.asList("Home", "Rooms", "Settings", "Reports"));
        assertEquals(visibleHeaderMenuLinks.size(), 4);
        assertEquals(visibleHeaderMenuLinks, adminHeaderMenuLinks);
    }

}
