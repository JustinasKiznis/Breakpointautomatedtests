package tests.AdminTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.LoginPage;
import tests.BaseTest;
import pages.AdminPage;
import utils.WaitUtils;
import utils.ExcelUtils;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AdminPageTest extends BaseTest{

    private static final String testRoomImg01 = "testRoom01.png";
    private static final String testRoomImgRez01 = "testRoomRez01.png";
    private static final String testRoomName01 = "testRoom01";
    private static final String testRoomMarks = "testRoom01";



    @BeforeClass
    public void login() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAsAdmin();
    }

    @Test
    public void CreateRoom() throws IOException {
        AdminPage adminPage = new AdminPage(driver);
        adminPage.clickAdminPanel();
        adminPage.clickCreateRoom();
        adminPage.clickNewRoomButtton();
        adminPage.typeRoomName(testRoomName01);
        adminPage.uploadRoomLayout(testRoomImg01);
        float x = adminPage.checkUploadedImgFile(testRoomImg01, testRoomImgRez01);
        adminPage.clickCreateRoomButton();
        assertEquals(x, 100);
    }

    @Test
    public void CreateWorkPlaces() throws IOException, AWTException {
        boolean done = true;
        try {
            AdminPage adminPage = new AdminPage(driver);
            adminPage.clickAdminPanel();
            adminPage.clickCreateWorkplaces();
            adminPage.clickRoomLayout();
            adminPage.chooseRoomLayout(testRoomName01);
            WaitUtils.waitMiliseconds(2000);
            adminPage.placeMarks(ExcelUtils.getTableArray(testRoomMarks, testRoomName01));
            WaitUtils.waitMiliseconds(5000);
        } catch (org.openqa.selenium.TimeoutException e)
        {
            done = false;
        }
        assertTrue(done);
    }
}
