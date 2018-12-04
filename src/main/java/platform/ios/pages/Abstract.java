package platform.ios.pages;

import common.AppiumDriverBuilder;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class Abstract extends AppiumDriverBuilder {

    public AppiumDriver driver;

    public Abstract(AppiumDriver appiumDriver){
        driver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(AppiumDriverBuilder.class);

    /**
    Scroll Screen Method
    */
    TouchAction touchAction = new TouchAction(driver);

//    public void scrollScreen(WebElement xElement, WebElement yElement) {
//        touchAction.longPress(xElement, 2).moveTo(yElement).release().perform();
//    }

    public void scrollScreen(MobileElement xElement, MobileElement yElement){
//        touchAction.longPress(xElement, 3).moveTo(yElement).release().perform();
        new TouchAction(driver).longPress(xElement, 3).moveTo(yElement).release().perform();
    }

    public void scrollScreen11(int startX, int startY, int endX, int endY){
       new TouchAction(driver).press(startX, startY).moveTo(endX, endY).release().perform();
    }

    public void scrollScreen(MobileElement xElement, int endX, int endY){
        new TouchAction(driver).longPress(xElement, 50).waitAction(2).moveTo(endX, endY).release().perform();
    }

    public void scroll(MobileElement element1, MobileElement element2){
        int startx = driver.findElement(By.xpath(String.valueOf(element1))).getLocation().getX();
        int starty = driver.findElement(By.xpath(String.valueOf(element1))).getLocation().getY();
        int endx = driver.findElement(By.xpath(String.valueOf(element2))).getLocation().getX();
        int endy = driver.findElement(By.xpath(String.valueOf(element2))).getLocation().getY();

        new TouchAction(driver).longPress(startx, starty).moveTo(endx,endy).release().perform();

//        touchAction.longPress(startx, starty).moveTo(endx, endy).release().perform();
    }

    public void swipeToElement(MobileElement elementX, MobileElement elementY){
        new TouchAction(driver).longPress(elementX, 3000).moveTo(elementY).release().perform();
    }
    /**
     * Returns the assertion status that would be assigned to this
     * class if it were to be initialized at the time this method is invoked.
     * @return status
     */
    public boolean isNoElementAvailable() {
        return NoSuchElementException.class.desiredAssertionStatus();
    }

    public boolean isElementPresent(MobileElement element) {
        boolean condition = false;
        for (int i = 0; i < 3; i++) {
            try {
                if (isNoElementAvailable() || !element.isDisplayed()) {
                    System.out.println("Element not displayed");
                    log.info("xpath element is not displayed.");
                    waitFor(2);
                } else if (!isNoElementAvailable() || element.isDisplayed()){
                    System.out.println("Element displayed");
                    log.info("xpath element is displayed.");
                    condition = true;
                    break;
                }
            } catch (Exception e) {
                //
            }
        }
        return condition;
    }

    public boolean isElementPresent(MobileElement element, int timeout) {
        boolean condition = false;
        for (int i = 0; i < timeout; i++) {
            try {
                if (!element.isDisplayed()) {
                    System.out.println("Element not displayed");
                    waitFor(2);
                } else if (element.isDisplayed()){
                    System.out.println("Element displayed");
                    condition = true;
                    break;
                }
            } catch (Exception e) {
                //
            }
        }
        return condition;
    }

    public void textValidation(String message, String expected, String actual){
        Assert.assertEquals("Failed : "+ message, expected, actual);
    }

    public void enterText(MobileElement element, String text){
        element.setValue(text);
    }

    public void clearEnterText(MobileElement element, String text){
        if (!element.getText().isEmpty()){
            element.clear();
        }
        element.sendKeys(text);
    }

    public void isElementPresentVerify(MobileElement element, String message){
        Assert.assertTrue("Failed : "+ message, isElementPresent(element));
    }

    public void isElementPresentVerify(MobileElement element, int time, String message){
        Assert.assertTrue("Failed : "+ message, isElementPresent(element, time));
    }

    public void isElementNotPresentVerify(MobileElement element, String message){
        Assert.assertTrue("Failed : "+ message, !isElementPresent(element));
    }

    public void isElementPresentVerifyClick(MobileElement element, String message){
        Assert.assertTrue("Failed : "+ message, isElementPresent(element));
        element.click();
        waitFor(1);
    }


    /**
     * wait for
     */

    public void waitFor(long timeout) {
        long timeOutToSecond = timeout * 1000;
        try {
            Thread.sleep(timeOutToSecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Click Done Button
     */
    @iOSFindBy(xpath = "//XCUIElementTypeButton[contains(@name, 'Done')]")
    public MobileElement doneBtn;

    public void clickDone(){

        doneBtn.click();
        waitFor(2);
    }

    /**
     * Click Selanjutnya Button
     */

    @iOSFindBy(id = "SELANJUTNYA")
    public MobileElement selanjutnyaBtn;
    public void clickSelanjutnyaBtn(){
        org.junit.Assert.assertTrue("Failed: Selanjutnya button is not displayed", selanjutnyaBtn.isDisplayed());
        selanjutnyaBtn.click();
    }

    /**
     * Date Picker
     */

    @iOSFindBy(xpath = "//XCUIElementTypeOther[2]/XCUIElementTypeDatePicker/XCUIElementTypeOther/XCUIElementTypePickerWheel[1]")
    public MobileElement firstPicker;

    @iOSFindBy(xpath = "//XCUIElementTypeOther[2]/XCUIElementTypeDatePicker/XCUIElementTypeOther/XCUIElementTypePickerWheel[2]")
    public MobileElement secondPicker;

    @iOSFindBy(xpath = "//XCUIElementTypeOther[2]/XCUIElementTypeDatePicker/XCUIElementTypeOther/XCUIElementTypePickerWheel[3]")
    public MobileElement thirdPicker;

    protected Date parseDateFormat(SimpleDateFormat currentFormatDate, String date) {
        Date dt = new Date();
        try {
            dt = currentFormatDate.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dt;
    }

    public void inputFirstPicker(String value){
        enterText(firstPicker,value);
    }

    public void inputSecondPicker(String value){
        enterText(secondPicker,value);
    }

    public void inputThirdPicker(String value){
        enterText(thirdPicker,value);
    }

    public void swipeTheScreen(){
        Dimension dimension = getDriver().manage().window().getSize();
        int height = dimension.getHeight();
        int endHeight = height /2;
        int width = dimension.getWidth();
        int endWidth = width /2;
        getDriver().swipe(endWidth,height,endWidth,endHeight,2000);
    }


    public void pageContentScroll(String direction){
        waitFor(2);
        if(direction.equalsIgnoreCase("up")){
            scrollscreen1(207, 582, 8, -360);
        }else if(direction.equalsIgnoreCase("down")){
            scrollscreen1(207, 582, 0, 350);
        }
    }

    public void scrollscreen1(int startX, int startY, int endX, int endY) {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(startX,startY).moveTo(endX, endY).release();
        touchAction.perform();
        waitFor(3);
    }

    public void scrollPage(MobileElement xElement){
        TouchActions touchActions = new TouchActions(driver);
        touchActions.scroll(xElement,56,358).release();
        touchActions.perform();
    }

    public void swiptToBottom() {
        Dimension dim = driver.manage().window().getSize();
        int height = dim.getHeight();
        int width = dim.getWidth();
        int x = width/2;
        int top_y = (int)(height*0.30);
        int bottom_y = (int)(height*0.20);
        System.out.println("coordinates :" + x + "  "+ top_y + " "+ bottom_y);
        TouchAction ts = new TouchAction(driver);
        ts.longPress(x, top_y).waitAction(4).moveTo(x, bottom_y).release().perform();
    }

    public void swiptswipt() {
        Dimension size = driver.manage().window().getSize();
        int endPoint = (int) (size.width * 0.20);
        int startPoint = (int) (size.width * 0.80);
        int anchor = size.height / 2;
        new TouchAction(driver).press(anchor, startPoint).waitAction(3).moveTo(anchor, endPoint).release().perform();
    }

    public boolean swipeToDirection(MobileElement el, String direction) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            HashMap<String, String> swipeObject = new HashMap<String, String>();
            if (direction.equals("d")) {
                swipeObject.put("direction", "down");
            } else if (direction.equals("u")) {
                swipeObject.put("direction", "up");
            } else if (direction.equals("l")) {
                swipeObject.put("direction", "left");
            } else if (direction.equals("r")) {
                swipeObject.put("direction", "right");
            }
            swipeObject.put("element", el.getId());
            js.executeScript("mobile:swipe", swipeObject);
            return true;
        } catch (Exception e) {
            return false;
        }
    }





}

