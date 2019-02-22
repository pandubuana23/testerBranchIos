package platform.ios.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSFindBy;

public class NoTeleponPage extends Abstract{
    public NoTeleponPage(AppiumDriver appiumDriver){super(appiumDriver);}

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"7\"]")
    protected MobileElement form7Header;
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Berapa nomor telpon domisili kamu?\"]")
    protected MobileElement descTextHeader;

    @iOSFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/" +
            "XCUIElementTypeOther[1]/XCUIElementTypeTextField")
    protected MobileElement kodeNoTelpField;
    @iOSFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/" +
            "XCUIElementTypeOther[2]/XCUIElementTypeTextField")
    protected MobileElement noTelpField;


    public void checkScreenStatus() {
        isElementPresent(form7Header);
        isElementPresent(descTextHeader);
    }
    public void inputNoTelp() {
        clearEnterText(kodeNoTelpField, "0214");
        clickDone();
        clearEnterText(noTelpField, generateRandomNumber(8));
        clickDone();
        clickSelanjutnyaBtn();
    }


    public void steps7Notelp() {
        steps("check no telpon page");
        checkScreenStatus();
        steps("input no telpon");
        inputNoTelp();
    }


}
