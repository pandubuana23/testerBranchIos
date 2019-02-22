package platform.ios.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.junit.Assert;

public class SumberInfoPage extends Abstract {
    public SumberInfoPage(AppiumDriver appiumDriver){super(appiumDriver);}

    /**
     ** Elements on Home Page
     **/
//======================================================================================================================
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"3\"]")
    protected MobileElement form3Header;
    @iOSFindBy(id = "Google")
    public MobileElement googleItemList;

    @iOSFindBy(id = "Dari mana kamu mengetahui UangTeman?")
    public MobileElement sumberInfoPage;


    /**
     ** Methods for each elements on Home page
     **/
//======================================================================================================================
    public String getSumberInfoText(){
        Assert.assertTrue("Failed: Sumber info page is not displayed", sumberInfoPage.isDisplayed());
        return sumberInfoPage.getText();
    }

    public void checkSumberInfoPage(String sumber_info){
        Assert.assertEquals("Failed: sumber info text is invalid",sumber_info, getSumberInfoText());
        isElementPresent(form3Header);
    }

    public String getGoogleText(){
        Assert.assertTrue("Failed: Google radio button is not displayed", googleItemList.isDisplayed());
        return googleItemList.getText();
    }

    public void clickGoogleItemList(String google_text){
        Assert.assertEquals("Failed: google text is invalid", google_text, getGoogleText());
        waitFor(2);
        googleItemList.click();
        clickSelanjutnyaBtn();
    }

//======================================================================================================================

    public void chooseOneOptionFromSumberInfoPage() {
         steps("check sumber info page");
         checkSumberInfoPage("Dari mana kamu mengetahui UangTeman?");
         steps("choose one from list");
         clickGoogleItemList("Google");
    }

}
