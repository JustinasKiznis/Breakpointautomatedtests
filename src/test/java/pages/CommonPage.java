package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ComponentUtils;

import java.util.ArrayList;
import java.util.List;

public class CommonPage extends BasePage {
    public CommonPage(WebDriver driver) {
        super(driver);
    }

    //----------------------Locators----------------------
    By header = By.cssSelector(".Header_topDiv__2re1N");
    By headerLeftMenu = By.cssSelector(".Header_navUl__3mtCC");
    By headerLeftMenuLinks = By.cssSelector("a[class*='Header']");
    By headerToggleButton = By.cssSelector(".navbar-toggler");

    //----------------------WebElements----------------------
    public WebElement headerLeftMenu() {
        return driver.findElement(headerLeftMenu);
    }

    //----------------------Methods----------------------
    public By getHeader() {
        return header;
    }

    /**
     * Gets names of links that are visible in the menu on the left side of the header
     *
     * @return ArrayList of link names
     */
    public ArrayList<String> getVisibleHeaderMenuLinks() {
        if (ComponentUtils.getScreenWidth(driver) < 1200) clickMenuToggleButton();
        List<WebElement> links = headerLeftMenu().findElements(headerLeftMenuLinks);
        ArrayList<String> visibleLeftMenuLinks = new ArrayList<String>();
        for (WebElement link : links) {
            String linkName = link.getText();
            visibleLeftMenuLinks.add(linkName);
        }
        return visibleLeftMenuLinks;
    }

    /**
     * Clicks on collapsed menu icon(hamburger) to open the header menu
     */
    public void clickMenuToggleButton(){
        driver.findElement(headerToggleButton).click();
    }

}
