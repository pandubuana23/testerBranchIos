package platform.ios.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.junit.Assert;

public class CalculatorPage extends Abstract {
    public CalculatorPage (AppiumDriver appiumDriver){super(appiumDriver);}

    /**
     ** Elements on Calculator Page
     **/
//=================================================================================================================================================

    @iOSFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeSlider")
    public MobileElement jumlahPinjaman;

    @iOSFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Cicilan\"])[2]")
    public MobileElement cicilanBtn;

    @iOSFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Sekali Bayar\"])[2]")
    public MobileElement sekaliBayarBtn;

    @iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"UangTeman\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeSlider")
    public MobileElement durasiPinjam;

    @iOSFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeSwitch")
    public MobileElement codePromoSwitch;

    @iOSFindBy(id = "Rp 193.163")
    public MobileElement biayaLayanan;

    @iOSFindBy(id = "PINJAM SEKARANG")
    public MobileElement pinjamSekarangBtn;

    @iOSFindBy(xpath = "//XCUIElementTypeOther[@name=\"Syarat dan Ketentuan\"]")
    public MobileElement syaratDanKetentuanPage;

    @iOSFindBy(id = "Baca Selengkapnya")
    public MobileElement bacaSelengkapnyaLink;

    @iOSFindBy(id = "icon back")
    public MobileElement backBtn;

    @iOSFindBy(id = "SAYA SETUJU")
    public MobileElement sayaSetujuBtn;




    /**
     ** Methods for each elements on Home page
     **/
//=================================================================================================================================================
    public void setJumlahPinjaman(){
        Assert.assertTrue("failed:Jumlah Pinjaman bar", jumlahPinjaman.isDisplayed());
        scrollScreen(jumlahPinjaman, 58,125);
        waitFor(2);
    }

    public void clickCicilanBtn(){
        Assert.assertTrue("Failed: Cicilan button is not displayed", cicilanBtn.isDisplayed());
        cicilanBtn.click();
    }

    public void clickSekaliBayarBtn(){
        Assert.assertTrue("Failed: Sekali button is not displayed", sekaliBayarBtn.isDisplayed());
        sekaliBayarBtn.click();
    }
    public void setDurasiPinjam(){
        Assert.assertTrue("Failed: Durasi pinjam seek bar is not displayed", durasiPinjam.isDisplayed());
        scrollScreen(durasiPinjam, 108, 348);
        waitFor(2);
    }
    public void setCodePromoOn(){
        Assert.assertTrue("Failed: Code Promo switch is not displayed", codePromoSwitch.isDisplayed());
        codePromoSwitch.click();
        waitFor(2);
    }

    public String getBiayaLayanan (String biaya_layanan){
        Assert.assertEquals("Failed: biaya layanan is invalid", biaya_layanan, biayaLayanan);
        return biayaLayanan.getText();
    }

    public void clickPinjamSekarangBtn(){
        waitFor(3);
        Assert.assertTrue("Failed: pinjam sekarang button is not displayed", pinjamSekarangBtn.isDisplayed());
        pinjamSekarangBtn.click();
    }

    public void checkSyaratKetentuanPage(){
        Assert.assertTrue("Failed: Syarat dan Ketentuan Page is not displayed", syaratDanKetentuanPage.isDisplayed());
    }

    public void clickBacaSelengkapnya(){
        Assert.assertTrue("Failed: Baca Selengkapnya link is not displayed", bacaSelengkapnyaLink.isDisplayed());
        bacaSelengkapnyaLink.click();
    }

    public void clickBackBtn(){
        Assert.assertTrue("Failed: Back button is not displayed", backBtn.isDisplayed());
        backBtn.click();
    }

    public void clickSayaSetujuBtn(){
        Assert.assertTrue("Failed: Saya Setuju button is not displayed", sayaSetujuBtn.isDisplayed());
        sayaSetujuBtn.click();
    }



}
