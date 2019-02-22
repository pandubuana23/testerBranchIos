package platform.ios.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSFindBy;

public class PendidikanPage extends Abstract {
    public PendidikanPage(AppiumDriver appiumDriver){super(appiumDriver);}

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"5\"]")
    protected MobileElement form5Header;
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Apa pendidikan terakhir kamu?\"]")
    protected MobileElement descTextHeader;
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"S1\"]")
    protected MobileElement bachelorDegreeOption;


    public void checkScreenStatus() {
        isElementPresent(form5Header);
        isElementPresent(descTextHeader);
    }
    public void selectS1Option() {
        isElementPresentVerifyClick(bachelorDegreeOption, "Unable to click option");
        clickSelanjutnyaBtn();
    }


    public void step5PendidikanForm() {
        steps("check page pendidikan");
        checkScreenStatus();
        steps("select one option from list");
        selectS1Option();
    }

}
