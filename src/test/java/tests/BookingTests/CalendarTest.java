package tests.BookingTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BookingPage;
import pages.CommonPage;
import pages.LoginPage;
import tests.BaseTest;
import utils.WaitUtils;

import static org.testng.Assert.*;

public class CalendarTest extends BaseTest {

    @BeforeClass
    public void testSetup() {
        LoginPage loginPage = new LoginPage(driver);
        CommonPage commonPage = new CommonPage(driver);
        BookingPage bookingPage = new BookingPage(driver);

        loginPage.loginAsRegularUser();
        commonPage.navigateToBookingPage();
        WaitUtils.waitUntilElementPresent(driver, 5, bookingPage.getCalendar());
    }

    @Test(priority = 0)
    public void currentDay() {
        BookingPage bookingPage = new BookingPage(driver);

        assertEquals(bookingPage.getCalendarLabel(), bookingPage.getCurrentMonthYear());
        assertEquals(bookingPage.getCurrentCalendarDay(), bookingPage.getCurrentDayOfMonth());
        assertEquals(bookingPage.getCurrentCalendarDate(), bookingPage.getCurrentDate());
    }

    @Test(priority = 1)
    public void bookOnWeekend() {
        BookingPage bookingPage = new BookingPage(driver);

        boolean weekendIsEnabled = bookingPage.getWeekendDate().isEnabled();
        assertFalse(weekendIsEnabled, "Weekend date is enabled");
    }

    @Test(priority = 2)
    public void bookInPast() {
        BookingPage bookingPage = new BookingPage(driver);

        boolean calendarPrevButtonIsEnabled = bookingPage.getCalendarPrevButton().isEnabled();
        assertFalse(calendarPrevButtonIsEnabled, "Calendar previous button is enabled");

        boolean yesterdayIsEnabled = bookingPage.dayIsEnabled(-1);
        assertFalse(yesterdayIsEnabled, "Yesterday is enabled");
    }

    @Test(priority = 3)
    public void bookMonthLater() {
        BookingPage bookingPage = new BookingPage(driver);

        boolean monthLaterIsEnabled = bookingPage.dayIsEnabled(31);
        assertFalse(monthLaterIsEnabled, "Date 31 days ahead is enabled");
    }
}

