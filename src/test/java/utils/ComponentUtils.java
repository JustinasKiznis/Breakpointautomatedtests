package utils;

import org.openqa.selenium.*;

public class ComponentUtils {

    /**
     * Gets the width of the current window
     *
     * @param driver Webdriver
     * @return int
     */
    public static int getScreenWidth(WebDriver driver) {
        Dimension dimension = driver.manage().window().getSize();
        return dimension.width;
    }

    /**
     * Opens the specified URL in the browser
     *
     * @param driver Webdriver
     * @param url specific URL
     */
    public static void openPage(WebDriver driver, String url) {
        driver.get(url);
    }

}
