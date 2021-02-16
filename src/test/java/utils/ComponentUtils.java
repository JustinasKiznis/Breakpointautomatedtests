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

}
