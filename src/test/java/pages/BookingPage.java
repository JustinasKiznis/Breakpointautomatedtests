package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BookingPage extends BasePage {

    public BookingPage(WebDriver driver) {
        super(driver);
    }

    //----------------------Locators----------------------
    By calendar = By.cssSelector(".Calendar_calendar__B0x8a");
    By calendarLabel = By.cssSelector(".react-calendar__navigation__label__labelText");
    By calendarPrevButton = By.cssSelector(".react-calendar__navigation__prev-button");
    By calendarNextButton = By.cssSelector(".react-calendar__navigation__next-button");
    By currentCalendarDay = By.cssSelector(".react-calendar__tile--now>abbr");
    By calendarDay = By.cssSelector(".react-calendar__tile>abbr");
    By calendarDayButton = By.cssSelector(".react-calendar__tile");
    By weekendDate = By.cssSelector(".react-calendar__month-view__days__day--weekend");

    //----------------------WebElements----------------------
    public WebElement getCalendarPrevButton() {
        return driver.findElement(calendarPrevButton);
    }

    public WebElement getWeekendDate() {
        return driver.findElement(weekendDate);
    }

    public List<WebElement> getVisibleDates() {
        return driver.findElements(calendarDayButton);
    }

    //----------------------Methods----------------------

    //-----------Calendar------------
    public By getCalendar() {
        return calendar;
    }

    public void clickOnCalendarNextButton() {
        driver.findElement(calendarNextButton).click();
    }

    public String getCalendarLabel() {
        return driver.findElement(calendarLabel).getText();
    }

    public int getCurrentCalendarDay() {
        String calendarDay = driver.findElement(currentCalendarDay).getText();
        return Integer.parseInt(calendarDay);
    }

    public String getCurrentCalendarDate() {
        return driver.findElement(currentCalendarDay).getAttribute("aria-label");
    }

    /**
     * Gets number of calendar days excluding past dates
     *
     * @return int
     */
    public int getNumberOfAvailableCalendarDays() {
        int indexOfCurrentDay = 0;
        List<WebElement> dates = getVisibleDates();
        for (WebElement date : dates) {
            String dateStr = date.findElement(calendarDay).getAttribute("aria-label");
            if (dateStr.equals(getCurrentCalendarDate())) {
                indexOfCurrentDay = dates.indexOf(date);
            }
        }
        return getVisibleDates().size() - indexOfCurrentDay;
    }

    /**
     * Checks if day is enabled in the calendar
     *
     * @param daysToAdd days to add to the current day (can be negative)
     * @return true/false
     */
    public boolean dayIsEnabled(int daysToAdd) {
        if (getNumberOfAvailableCalendarDays() <= daysToAdd)
            clickOnCalendarNextButton();

        boolean dayIsEnabled = false;
        String changedDate = getChangedDate(daysToAdd);
        List<WebElement> dates = getVisibleDates();
        for (WebElement date : dates) {
            String dateStr = date.findElement(calendarDay).getAttribute("aria-label");
            if (dateStr.equals(changedDate)) {
                dayIsEnabled = date.isEnabled();
                break;
            }
        }
        return dayIsEnabled;
    }

    //-----------LocalDate------------
    public String getCurrentMonthYear() {
        LocalDate now = LocalDate.now();
        return now.format(DateTimeFormatter.ofPattern("MMMM yyyy"));
    }

    public int getCurrentDayOfMonth() {
        LocalDate now = LocalDate.now();
        return now.getDayOfMonth();
    }

    public String getCurrentDate() {
        LocalDate now = LocalDate.now();
        return now.format(DateTimeFormatter.ofPattern("MMMM d, yyyy"));
    }

    public String getChangedDate(int numberOfDays) {
        LocalDate today = LocalDate.now();
        LocalDate changedDate = today.plusDays(numberOfDays);
        return changedDate.format(DateTimeFormatter.ofPattern("MMMM d, yyyy"));
    }

}
