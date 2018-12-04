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
    public void inputEmailAddress(String emailAddress) {
        enterText(emailTextField, emailAddress);
        waitFor(1);
        returnBtn.click();
    }

    public void inputPhoneNumber(String phoneNumber){
        enterText(phoneField, phoneNumber);
        waitFor(1);
        clickDone();
    }

    public void inputKtp(String ktpNumber){
        enterText(ktpField, ktpNumber);
        waitFor(1);
        clickDone();
    }

    public void inputNpwp(String npwpNumber){
        enterText(npwpField, npwpNumber);
        clickDone();
    }

    public void clickSelanjutnyaBtn(){
        org.junit.Assert.assertTrue("Failed: Selanjutnya button is not displayed", selanjutnyaBtn.isDisplayed());
        selanjutnyaBtn.click();
    }


    public void InputKontakDasar(String emailAddress, String phoneNumber, String ktpNumber, String npwpNumber){
        swiptswipt();
        waitFor(4);
        inputEmailAddress(emailAddress);
        inputPhoneNumber(phoneNumber);
        inputKtp(ktpNumber);
        inputNpwp(npwpNumber);
        clickSelanjutnyaBtn();
        waitFor(1);
    }




}
