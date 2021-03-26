package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

    public static void waitMiliseconds(int miliseconds) {
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitUntilElementPresent(WebDriver driver, int timeout, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static void waitUntilElementDisplayed(WebDriver driver, int timeout, By element) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
    }

    public static void waitUntilElementClickable(WebDriver driver, int timeout, By element){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Waits until URL of the current page is a specified URL
     *
     * @param driver Webdriver
     * @param timeout timeout in seconds
     * @param url specific URL
     */
    public static void waitUntilSpecificURL(WebDriver driver, int timeout, String url) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.urlToBe(url));
    }

}
