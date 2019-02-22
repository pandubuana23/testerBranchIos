package platform.ios.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.junit.Assert;

public class AlasanPeminjamanPage extends Abstract {
    public AlasanPeminjamanPage(AppiumDriver appiumDriver){super(appiumDriver);}

    /**
     ** Elements on Calculator Page
     **/
//=====================================================================================================================
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"2\"]")
    protected MobileElement form2header;
    @iOSFindBy(id = "Apa alasan kamu meminjam uang di UangTeman?")
    public MobileElement alasanPinjamPage;

    @iOSFindBy(id = "Liburan")
    public MobileElement liburanBtn;


    /**
     ** Methods for each elements on Home page
     **/
//=====================================================================================================================

    public String getAlasanPinjamText(){
        Assert.assertTrue("Failed: Alasan Pinjam text is invalid", alasanPinjamPage.isDisplayed());
        return alasanPinjamPage.getText();
    }

   public void checkAlasanPinjamPage(String alasan_pinjam){
        Assert.assertEquals("Failed: Alasan Pinjam is invalid", alasan_pinjam, getAlasanPinjamText());
        waitFor(1);
        isElementPresent(form2header);
   }

   public String getLiburanText(){
        return liburanBtn.getText();
   }

   public void clickLiburanBtn(String liburan_text){
        isElementPresentVerify(liburanBtn,"Failed: Liburan is not displayed");
        textValidation("Failed: Liburan text is invalid",liburan_text,getLiburanText());
        liburanBtn.click();
        selanjutnyaBtn.click();
   }

//   ==================================================================================================================

    public void chooseOneOptionInAlasanPeminjaman() {
        steps("check alasan pinjam page");
        checkAlasanPinjamPage("Apa alasan kamu meminjam uang di UangTeman?");
        steps("click one option E.G Liburan");
        clickLiburanBtn("Liburan");
    }

}
