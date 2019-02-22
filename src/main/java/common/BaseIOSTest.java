package common;

import org.junit.After;
import org.junit.Before;
import platform.ios.pages.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseIOSTest extends AppiumDriverBuilder {

    protected HomePage homePage;
    protected CalculatorPage calculatorPage;
    protected ContactDasarPage contactDasarPage;
    protected AlasanPeminjamanPage alasanPeminjamanPage;
    protected SumberInfoPage sumberInfoPage;
    protected DataPribadiPage dataPribadiPage;
    protected PendidikanPage pendidikanPage;
    protected SukuTanggunganPage sukuTanggunganPage;
    protected NoTeleponPage noTeleponPage;
    protected AlamatTinggalPage alamatTinggalPage;

    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();

    @Before
    public void setUp() throws Exception {
        super.setDriver();

        /**
         * List of page
         */
        homePage = new HomePage(getDriver());
        calculatorPage = new CalculatorPage(getDriver());
        contactDasarPage = new ContactDasarPage(getDriver());
        alasanPeminjamanPage = new AlasanPeminjamanPage(getDriver());
        sumberInfoPage = new SumberInfoPage(getDriver());
        dataPribadiPage = new DataPribadiPage(getDriver());
        pendidikanPage = new PendidikanPage(getDriver());
        sukuTanggunganPage = new SukuTanggunganPage(getDriver());
        noTeleponPage = new NoTeleponPage(getDriver());
        alamatTinggalPage = new AlamatTinggalPage(getDriver());


        System.out.println("============================================");
        System.out.println("Project      : UangTeman App IOS Automation");
        System.out.println("Date         : "+ dateFormat.format(date));
        System.out.println("Platform     : "+ Constants.DEFAULT_IOS_PLATFORM_VERSION);
        System.out.println("Device name	 : "+ Constants.DEFAULT_IOS_DEVICE_NAME);
        System.out.println("============================================");

    }

    @After
    public void tearDown() throws Exception{
        System.out.println("-----------------");
        driver.quit();
    }


}