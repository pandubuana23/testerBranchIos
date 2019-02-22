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
        stepTests("New install step on homescreen");
        homePage.stepsFornewInstall();
        stepTests("Click lain kali button");
        homePage.stepsCheckHomescreenPageAndClickAjukanpinjaman();
        stepTests("steps on calculator page");
        calculatorPage.stepsCalculatorPage();
        stepTests("check syarat dan ketentuan Page");
        calculatorPage.stepsSyaratDanKetentuanPage();
        stepTests("input kontak dasar");
        contactDasarPage.inputKontakDasar();
        stepTests("input alasan peminjaman");
        alasanPeminjamanPage.chooseOneOptionInAlasanPeminjaman();
        stepTests("Input sumber info page");
        sumberInfoPage.chooseOneOptionFromSumberInfoPage();
        stepTests("input data pribadi page");
        dataPribadiPage.stepsDetailDataKamuPage();
        stepTests("choose one option in pendidikan page");
        pendidikanPage.step5PendidikanForm();
        stepTests("input suku dan jumlah tanggungan");
        sukuTanggunganPage.step6SukuTanggunganPage();
        stepTests("input No. Telepon");
        noTeleponPage.steps7Notelp();
        stepTests("input alamat tempat tinggal customer");
        alamatTinggalPage.inputAlamatTinggal();
    }

}
