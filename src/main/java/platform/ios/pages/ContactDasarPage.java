package platform.ios.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSFindBy;

public class ContactDasarPage extends Abstract {
    public ContactDasarPage(AppiumDriver appiumDriver){super(appiumDriver);}

    /**
     ** Elements on Contact Dasar Page
     **/
//=================================================================================================================================================
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"1\"]")
    protected MobileElement form1Number;
    @iOSFindBy(xpath = "//XCUIElementTypeOther[@name=\"Kontak Dasar\"]")
    protected MobileElement kontakDasarHeader;
    @iOSFindBy(xpath = "//XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTextField")
    public MobileElement emailTextField;
    @iOSFindBy(xpath = "//XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeTextField")
    public MobileElement phoneField;
    @iOSFindBy(id = "Return")
    public MobileElement returnBtn;
    @iOSFindBy(xpath = "//XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeTextField")
    public MobileElement ktpField;
    @iOSFindBy(xpath = "//XCUIElementTypeOther[5]/XCUIElementTypeOther/XCUIElementTypeTextField")
    public MobileElement npwpField;



    /**
     ** Methods for each elements on Contact Dasar Page
     **/
//=================================================================================================================================================
    public void checkKontakDasarHeader() {
        isElementPresent(form1Number);
        isElementPresent(kontakDasarHeader);
    }
    public void inputEmailAddress(String emailAddress) {
        clearEnterText(emailTextField, emailAddress);
        waitFor(1);
        returnBtn.click();
    }

    public void inputPhoneNumber(String phoneNumber){
        clearEnterText(phoneField, phoneNumber);
        waitFor(1);
        clickDone();
    }

    public void inputKtp(String ktpNumber){
        clearEnterText(ktpField, ktpNumber);
        waitFor(1);
        clickDone();
    }

    public void inputNpwp(String npwpNumber){
        clearEnterText(npwpField, npwpNumber);
        clickDone();
    }

    public void clickSelanjutnyaBtn(){
        org.junit.Assert.assertTrue("Failed: Selanjutnya button is not displayed", selanjutnyaBtn.isDisplayed());
        selanjutnyaBtn.click();
    }

    public void inputKontakDasar(){
        steps("check kontak dasar header");
        checkKontakDasarHeader();
//        swiptswipt();
        pageContentScroll("Up");
        waitFor(4);
        steps("input email address");
        inputEmailAddress(setEmailAddress(3));
        steps("input phone number");
        inputPhoneNumber("0812" + generateRandomNumber(9));
        steps("input ktp ID number");
        inputKtp("9" + generateRandomNumber(15));
        steps("input NPWP number");
        inputNpwp(generateRandomNumber(15));
        steps("click selanjutnya button");
        clickSelanjutnyaBtn();
        waitFor(5);
    }




}
