package platform.ios.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSFindBy;

public class SukuTanggunganPage extends Abstract{
    public SukuTanggunganPage(AppiumDriver appiumDriver){super(appiumDriver);}

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"6\"]")
    protected MobileElement form6Header;
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Apa suku kamu?\"]")
    protected MobileElement descTextHeader;

    @iOSFindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeButton")
    protected MobileElement sukuDropdown;
    @iOSFindBy(xpath = "//XCUIElementTypePicker/XCUIElementTypePickerWheel")
    public MobileElement suku;
    @iOSFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[3]")
    protected MobileElement jumlahTanggunganField;



    public void checkScreenStatus() {
        isElementPresent(form6Header);
        isElementPresent(descTextHeader);
    }
    public void inputSuku() {
        isElementPresentVerifyClick(sukuDropdown, "Unable to tap suku dropdown");
        enterText(suku, "Bugis");
        clickDone();
    }
    public void inputJumlahTanggungan() {
        isElementPresent(jumlahTanggunganField, 2);
        enterText(jumlahTanggunganField, "1");
        clickDone();
        clickSelanjutnyaBtn();
    }


    public void step6SukuTanggunganPage() {
        checkScreenStatus();
        steps("input suku");
        inputSuku();
        steps("input jumlah tanggungan");
        inputJumlahTanggungan();
    }

}
