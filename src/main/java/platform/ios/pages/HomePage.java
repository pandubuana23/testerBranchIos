package platform.ios.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.junit.Assert;


public class HomePage extends Abstract {
    public HomePage (AppiumDriver appiumDriver){super(appiumDriver);}

    /**
     ** Elements on Home Page
     **/
//=================================================================================================================================================
    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"Allow\"]")
    public MobileElement allowBtn;

    @iOSFindBy(id = "Selanjutnya")
    public MobileElement selanjutnyaBtn;

    @iOSFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Lewati\"])[2]")
    public MobileElement lewatiBtn;

    @iOSFindBy(id = "Klik Ajukan Pinjaman, Tekan tombol AJUKAN PINJAMAN yang terdapat di halaman HOME untuk memulai pinjaman")
    public MobileElement ajukanPinjaman;

    @iOSFindBy(id = "Isi Form Aplikasi, Isi form aplikasi pinjaman. Isi dengan data diri kamu. Tidak lupa juga untuk menyiapkan KTP dan foto diri mu")
    public MobileElement formAplikasi;

    @iOSFindBy(id = "Uang Dicairkan, UangTeman akan melakukan verifikasi data diri kamu. Pinjaman mu akan dicairkan dalam waktu kurang dari 48 jam")
    public MobileElement uangDicairkanPage;

    @iOSFindBy(id = "Masuk ke Home")
    public MobileElement masukHomeBtn;

    @iOSFindBy(xpath = "//XCUIElementTypeAlert[@name=\"UangTeman\"]")
    public MobileElement updatePopup;

    @iOSFindBy(id = "Versi terbaru telah tersedia di AppStore. Update aplikasi kamu agar tetap dapat menggunakan dan mengajukan pinjaman!")
    public MobileElement informationTextPopup;

    @iOSFindBy(id = "Lain Kali")
    public MobileElement lainKaliBtn;

    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"Update\"]")
    public MobileElement updateBtn;

    @iOSFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"UangTeman\"]")
    public MobileElement header;

    @iOSFindBy(id = "icon menu")
    public MobileElement hamburgerMenu;

    @iOSFindBy(xpath = "//XCUIElementTypeOther[@name=\"UangTeman\"]" )
    public MobileElement uangTemanLogo;

    @iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"UangTeman\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeScrollView/XCUIElementTypeImage[1]")
    public MobileElement bannerImage;

    @iOSFindBy(id = "Pinjaman Online")
    public MobileElement pinjamanOnline;

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Isi data diri hanya 5 menit. Pinjaman hingga 3 juta rupiah.\"]")
    public MobileElement isiDataDiri;

    @iOSFindBy(id = "Pinjam Sekarang - Langsung Cair")
    public MobileElement ajukanPinjamanBtn;

    @iOSFindBy(id = "Status Pinjaman")
    public MobileElement statusPinjamanText;

    @iOSFindBy(id = "Cek status pinjaman kamu di bawah ini")
    public MobileElement checkStatusText;

    /**
     ** Methods for each elements on Home page
     **/
//=================================================================================================================================================

    public void clickAllowButton(){
        Assert.assertTrue("FAILED : lain kali button is not displayed", allowBtn.isDisplayed());
        allowBtn.click();
        waitFor(1);
    }

    public void checkSelanjutnya(){
        Assert.assertTrue("FAILED : Selanjutnya button is not displayed", selanjutnyaBtn.isDisplayed());
    }

    public void clickSelanjutnya(){
        checkSelanjutnya();
        selanjutnyaBtn.click();
        waitFor(1);
    }

    public void checkLewatiBtn(){
        Assert.assertTrue("FAILED : Lewati button is not displayed", lewatiBtn.isDisplayed());
    }

    public void clickLewatiBtn(){
        checkLewatiBtn();
        lewatiBtn.click();
        waitFor(1);
    }

    public void checkAjukanPinjaman(){
        Assert.assertTrue("Failed : Ajukan Pinjaman Page is not displayed", ajukanPinjaman.isDisplayed());
    }

    public void checkFormAplikasi(){
        Assert.assertTrue("Failed : Application Form is not displayed", formAplikasi.isDisplayed());
    }

    public void checkUangDicairkanPage(){
        Assert.assertTrue("Failed : Uang dicairkan page is not displayed", uangDicairkanPage.isDisplayed());

    }

    public void checkMasukHome(){
        Assert.assertTrue("Failed : Masuk ke home button is not displayed", masukHomeBtn.isDisplayed());
    }

    public void clickMasukHome(){
        checkMasukHome();
        masukHomeBtn.click();
        waitFor(1);
    }

    public void checkAlertPopup(){
        waitFor(2);
        Assert.assertTrue("Failed : Allert Popup is not displayed", updatePopup.isDisplayed());
    }

    public String getInformationPopupText(){
        return informationTextPopup.getText();
    }

    public void CheckInformationPopup(String allert_popup){
        isElementPresentVerify(informationTextPopup, "Failed : Information text popup is not displayed");
        textValidation("Failed : Information text popup is not displayed", allert_popup, getInformationPopupText());
        waitFor(1);
    }

    public void checkUpdateBtn(){
        isElementPresentVerify(updateBtn, "Failed : Update button is not displayed");
    }

    public void checkLainKaliBtn(){
        isElementPresentVerify(lainKaliBtn, "Failed: Lain kali button is not displayed");
    }

    public void clickLainKaliBtn(){
        if (ajukanPinjamanBtn.isDisplayed()){
//            lainKaliBtn.click();
            waitFor(1);
        }
        else {
            lainKaliBtn.click();
//            waitFor(5);
//            System.out.println("upadate popup is not displayed");
        }

    }

    public void checkHeader(){
        isElementPresentVerify(header,"Failed: Header is not displayed");
        isElementPresentVerify(uangTemanLogo,"Failed: Logo UangTeman is not displayed");
        isElementPresentVerify(hamburgerMenu,"Failed: Hamburger menu is not displayed");
    }

    public void checkImageBanner(){
        Assert.assertTrue("Failed: Home Banner is not displayed", bannerImage.isDisplayed());
    }

    public String getPinjamanOnline(){
        Assert.assertTrue("Failed: Pinjaman Online text is not displayed", pinjamanOnline.isDisplayed());
        return pinjamanOnline.getText();
    }

    public void CheckPinjamanOnline(String pinjaman_online){
        Assert.assertEquals("Failed: Pinjaman text is invalid", pinjaman_online, getPinjamanOnline());
        waitFor(1);
    }

    public String getDataDiriText(){
        Assert.assertTrue("Failed: Data diri text is not displayed", isiDataDiri.isDisplayed());
        return isiDataDiri.getText();
    }

    public void checkIsiDataDiri(String isi_data_diri){
        Assert.assertEquals("Failed: isi data diri information text is invalid", isi_data_diri, getDataDiriText());
        waitFor(1);
    }

    public void checkAjukanPinjamanBtn(){
        Assert.assertTrue("Failed: ajukan pinjaman button is not displayed", ajukanPinjamanBtn.isDisplayed());
    }

    public void clickAjukanPinjaman(){
        checkAjukanPinjamanBtn();
        ajukanPinjamanBtn.click();
        waitFor(2);
    }

    public String getStatusPinjamanText(){
        Assert.assertTrue("Failed: Status Pinjaman text is not displayed", statusPinjamanText.isDisplayed());
        return statusPinjamanText.getText();
    }

    public void checkStatusPinjamanText(String status_pinjaman_text){
        Assert.assertEquals("Failed: status pinjaman text is invalid", status_pinjaman_text, getStatusPinjamanText());
    }

    public String getStatusText(){
        Assert.assertTrue("Faield Cek status pinjaman kamu di bawah ini text is not displayed", checkStatusText.isDisplayed());
        return checkStatusText.getText();
    }

    public void VerifyCheckStatus(String check_status){
        Assert.assertEquals("failed : Cek status pinjaman kamu di bawah ini text is invalid", check_status, getStatusText());
    }



}
