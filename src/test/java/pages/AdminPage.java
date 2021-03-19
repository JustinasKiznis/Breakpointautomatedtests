package pages;

import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.openqa.selenium.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;


import org.openqa.selenium.support.ui.Select;
import utils.ComponentUtils;
import utils.WaitUtils;

import javax.imageio.ImageIO;
import javax.xml.xpath.XPath;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.awt.Robot;

import java.io.File;
import java.io.IOException;
//import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AdminPage {
    WebDriver driver;

    public AdminPage(WebDriver driver) {
        this.driver = driver;
    }


    //--------Locators-----------------------------------------------------------
    //--------Navigation---------
    By adminPanel = new By.ByXPath("//a[contains(text(),'Settings')]");
    By createRoomMenuButton = new By.ByXPath("//a[contains(text(),'Create room')]");
    By createWorkplacesMenuButton = new By.ByXPath("//a[contains(text(),'Create workplaces')]");

    //-------Create-room--------
    By newRoomButton = new By.ByXPath("//button[contains(text(),'New')]");
    By nameInputField = new By.ByXPath("//input[@id='roomName']");
    By fileInputField = By.id("fileName");
    By roomCreateButton = new By.ByXPath("//button[@type='submit']");
    By roomLayoutImage = new By.ByXPath("/html/body/div/div[1]/div/div/div/div/img");

    //------Create-workplaces---
    By roomMenu = new By.ByXPath("//a[contains(text(),'Choose room layout')]");
    By roomMenuDropDown = new By.ByCssSelector("#root > div.Layout_TopMargin__VhZYj.container > div > div > div > div.Header_roomsTop__3ZCMt.dropdown.show > div");
    By removeLastButton = By.xpath ("//*[contains(text(),'Remove last')]");
    By clearAllButton = By.xpath ("//*[contains(text(),'Clear All')]");
    By saveButton = By.xpath("//button[contains(.,'Save')]");
    By bookingFreeMark = By.cssSelector(".row > img:nth-child(1)");
    By bookingUnavailableMark = By.cssSelector(".row > img:nth-child(2)");

    By getRoomLayoutCanvas = new By.ByClassName("konvajs-content");

    By markScaleSlider = By.cssSelector(".range-slider");
    //--------------------------------------NAVIGATION------------------------------------

    public void clickAdminPanel(){
        //WaitUtils.waitMiliseconds(5000);
        WaitUtils.waitUntilElementClickable(driver, 5, adminPanel);
        driver.findElement(adminPanel).click();
    }

    public void clickCreateRoom(){
        WaitUtils.waitUntilElementClickable(driver, 5, createRoomMenuButton);
        driver.findElement(createRoomMenuButton).click();
    }

    public void clickWorkplacesRoom(){
        WaitUtils.waitUntilElementClickable(driver, 5, createWorkplacesMenuButton);
        driver.findElement(createWorkplacesMenuButton).click();
    }

    //-----------------------------------------CREATE-ROOM--------------------------------

    public void clickNewRoomButtton(){
        driver.findElement(newRoomButton).click();
    }

    public void typeRoomName(String name) {
        driver.findElement(nameInputField).sendKeys(name);
    }

    public void uploadRoomLayout(String fileName) throws IOException {
        WebElement fileUploadElement = driver.findElement(fileInputField);
        String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\" + fileName;
        fileUploadElement.sendKeys(filePath);
    }

    public float checkUploadedImgFile(String fileName, String fileRezultName) throws IOException {
        String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\" + fileName;
        String fileRezultPath = System.getProperty("user.dir") + "\\src\\test\\resources\\" + fileRezultName;
        BufferedImage imgA = ImageIO.read(new File(filePath));
        //scroll to the bottom of the page
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");


        float percentage = 0;
        int imgPixelCount = imgA.getWidth() * imgA.getHeight();
        int imageCorrectPixels = imgA.getWidth() * imgA.getHeight();

        //BufferedImage imgB = new BufferedImage(imgA.getWidth(), imgA.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
        //int[] rgb = imgA.getRGB(0, 0, imgA.getWidth(), imgA.getHeight(), null, 0, imgA.getWidth());

        //imgB.setRGB(0, 0, imgA.getWidth(), imgA.getHeight(), rgb, 0, imgA.getWidth());
        BufferedImage imgB = ImageIO.read(driver.findElement(roomLayoutImage).getScreenshotAs(OutputType.FILE));

        //imgB.setRGB(0, 0, imgA.getWidth(), imgA.getHeight(), rgb, 0, imgA.getWidth());
        ImageIO.write(imgB, "png", new File(fileRezultPath));
        if (imgA.getWidth() == imgB.getWidth() && imgA.getHeight() == imgB.getHeight()) {
            for (int x = 0; x < imgA.getWidth(); x++) {
                for (int y = 0; y < imgA.getHeight(); y++) {
                    if (imgA.getRGB(x, y) != imgB.getRGB(x, y)){
                        int a = imgA.getType();
                        int b = imgB.getType();

                        imageCorrectPixels--;
                    }
                }
            }
        } else {
            return 0;
        }
        ////scroll to the top of the page
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0)");

        percentage = imageCorrectPixels / imgPixelCount;
        return percentage;
    }

    public void clickCreateRoomButton(){
        driver.findElement(roomCreateButton).click();
    }



    //---------------------------------CREATE-WORKPLACES------------------------------

    public void clickCreateWorkplaces(){
        driver.findElement(createWorkplacesMenuButton).click();
    }

    public void clickRoomLayout(){
        //Actions act = new Actions(driver);
        //act.moveToElement(driver.findElement(roomMenu)).click().build().perform();

        driver.findElement(roomMenu).click();
    }


    public void chooseRoomLayout(String roomName){
        By roomLayoutButton = By.xpath("//*[contains(text(),'"+roomName+"')]");
        //WaitUtils.waitUntilElementPresent(driver, 5, new By.ByXPath("//button[contains(text(),'"+roomName+"')]"));

        List<WebElement> element = driver.findElements(roomLayoutButton);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element.get(1));

    }

    //scale from 0.5 to 2
    public void changeMarkScale(int scale){
        //driver.findElement(markScaleSlider).sendKeys();
    }


    //type mark 1 - bookable, 2 - not bookable
    public void placeMark(int x, int y, int type) throws AWTException {
        //Actions act = new Actions(driver);
        //act.dragAndDropBy(driver.findElement(bookingFreeMark), x, y-50).build().perform();
        //WaitUtils.waitMiliseconds(1000);
        WebElement element = driver.findElement(bookingFreeMark);
        WaitUtils.waitUntilElementDisplayed(driver, 5, bookingFreeMark);

        Point locationFreeMark = element.getLocation();
        //int locationFreeMarkX = locationFreeMark.getX();
        //int locationFreeMarkY = locationFreeMark.getY();

        int locationFreeMarkX = 590;
        int locationFreeMarkY = 610;


        Robot robot = new Robot();
        robot.mouseMove(locationFreeMarkX, locationFreeMarkY);
        // Press left click of mouse
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(2000);
        robot.mouseMove(locationFreeMarkX+x, locationFreeMarkY+y+75);

        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);

        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        /*
        act.moveToElement(driver.findElements(bookingFreeMark).get(0))
                //.moveByOffset(32, -32)
                .clickAndHold(driver.findElement(bookingFreeMark))
                .moveByOffset(x, y-50)
                .release().build();
        act.perform();
        */

    }


    public void placeMarks(Double[][] markInfo) throws AWTException {
        int markCount = markInfo[0][0].intValue();
        for(int i = 1; i < markCount; i++){
            int x = markInfo[i][0].intValue();
            int y = markInfo[i][1].intValue();
            int markType = markInfo[i][2].intValue();
            placeMark(x, y, markType);
        }
    }

    public void clickSaveButton(){
        driver.findElement(saveButton).click();
    }
}
