package platform.ios.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSFindBy;

public class AlamatTinggalPage extends Abstract {
    public AlamatTinggalPage(AppiumDriver appiumDriver){super(appiumDriver);}

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"8\"]")
    protected MobileElement form8Header;
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Dimana kamu tinggal saat ini?\"]")
    protected MobileElement descTextHeader;

    @iOSFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/" +
            "XCUIElementTypeOther[2]/XCUIElementTypeOther")
    protected MobileElement alamatTempatTinggalField;

    @iOSFindBy(xpath = "//XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeButton")
    protected MobileElement provinceDropDown;
    @iOSFindBy(xpath = "//XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeButton")
    protected MobileElement cityDropDown;
    @iOSFindBy(xpath = "//XCUIElementTypeOther[5]/XCUIElementTypeOther/XCUIElementTypeButton")
    protected MobileElement districtDropDown;
    @iOSFindBy(xpath = "//XCUIElementTypeOther[6]/XCUIElementTypeOther/XCUIElementTypeButton")
    protected MobileElement subDistrictDropDown;


    public void checkScreenStatus() {
        isElementPresent(form8Header);
        isElementPresent(descTextHeader);
    }
    public void inputAlamatTempatTinggal() {
        steps("enter home address");
        enterText(alamatTempatTinggalField, "Jl. Kenari automate Blok C No." + generateRandomNumber(5));
        steps("enter province from dropdown");
        isElementPresentVerifyClick(provinceDropDown, "Unable to click" + provinceDropDown);
        enterText(listPickerWheel, "DKI Jakarta");
        clickDone();
        swiptswipt();
        steps("enter city from dropdown");
        isElementPresentVerifyClick(cityDropDown, "Unable to click" + cityDropDown);
        enterText(listPickerWheel, "Kota Jakarta Pusat");
        clickDone();
        swiptswipt();
        steps("enter district from dropdown");
        isElementPresentVerifyClick(districtDropDown, "Unable to click" + districtDropDown);
        enterText(listPickerWheel, "Cempaka Putih");
        clickDone();
        steps("enter sub district from dropdown");
        isElementPresentVerifyClick(subDistrictDropDown, "Unable to click" + subDistrictDropDown);
        enterText(listPickerWheel, "Rawasari");
        clickDone();
        steps("click selanjutnya button");
        clickSelanjutnyaBtn();
    }

    public void inputAlamatTinggal() {
        steps("check page alamat tinggal");
        checkScreenStatus();
        inputAlamatTempatTinggal();
    }

}
