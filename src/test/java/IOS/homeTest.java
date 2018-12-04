package IOS;

import common.BaseIOSTest;
import org.junit.Test;
import utils.annotations.Categories;
import utils.annotations.Descriptions;

public class homeTest extends BaseIOSTest {

    @Categories("HOME")
    @Descriptions("Home_01 : To verify user should be able to see home page")
    @Test
    public void checkHomePage(){
        steps("verify and click allow button");
        homePage.clickAllowButton();
        steps("verify and click Selanjutnya Button");
        homePage.clickSelanjutnya();
        steps("verify lewati button");
        homePage.checkLewatiBtn();
        steps("Verify ajukan pinjaman");
        homePage.checkAjukanPinjaman();
        steps("click selanjutnya button");
        homePage.clickSelanjutnya();
        steps("Verify Form Aplikasi");
        homePage.checkFormAplikasi();
        steps("click selanjutnya button");
        homePage.clickSelanjutnya();
        steps("Verify uang dicairkan page");
        homePage.checkUangDicairkanPage();
        steps("click masuk home button");
        homePage.clickMasukHome();
        steps("Check allert popup");
        homePage.checkAlertPopup();
        steps("check information popup");
        homePage.CheckInformationPopup("Versi terbaru telah tersedia di AppStore. Update aplikasi kamu agar tetap dapat menggunakan dan mengajukan pinjaman!");
        steps("Check Update Button");
        homePage.checkUpdateBtn();
        steps("Click lain kali button");
        homePage.clickLainKaliBtn();
        steps("Check Header");
        homePage.checkHeader();
//        steps("Check Home Banner");
//        homePage.checkImageBanner();
        steps("Verify Pinjaman Online text");
        homePage.CheckPinjamanOnline("Pinjaman Online");
//        steps("Verify Isi Data Diri information text");
//        homePage.checkIsiDataDiri("Isi data diri hanya 5 menit. Pinjaman hingga 3 juta rupiah.");
        steps("Verify ajukan pinjaman button");
        homePage.checkAjukanPinjamanBtn();
        steps("Verify status pinjaman text");
        homePage.checkStatusPinjamanText("Status Pinjaman");
        steps("Verify Cek status pinjaman kamu di bawah ini");
        homePage.VerifyCheckStatus("Cek status pinjaman kamu di bawah ini");
        steps("Click Ajukan Pinjaman");
        homePage.clickAjukanPinjaman();
    }

}
