package platform.ios.pages;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.junit.Assert;

import java.text.SimpleDateFormat;

public class DataPribadiPage extends Abstract {
    public DataPribadiPage (AppiumDriver appiumDriver){super(appiumDriver);}

    /**
     ** Elements on Contact Dasar Page
     **/
//======================================================================================================================
    @iOSFindBy (id = "Detail data kamu")
    public MobileElement dataPribadiPage;
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"4\"]")
    protected MobileElement form4Number;
    @iOSFindBy(xpath = "//XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTextField")
    public MobileElement nameField;

    @iOSFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[3]/" +
            "XCUIElementTypeOther")
    public MobileElement jenisKelaminDropDown;

    @iOSFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeTextField")
    public MobileElement tempatLahir;

    @iOSFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[5]/" +
            "XCUIElementTypeOther[1]/XCUIElementTypeOther")
    public MobileElement dateOfBirthDropdown;

    @iOSFindBy(xpath = "//XCUIElementTypePicker/XCUIElementTypePickerWheel")
    public MobileElement agama;

    @iOSFindBy(xpath = "//XCUIElementTypeOther[6]/XCUIElementTypeOther/XCUIElementTypeButton")
    public MobileElement agamaDropDown;

    @iOSFindBy(xpath = "//XCUIElementTypeOther[7]/XCUIElementTypeOther/XCUIElementTypeButton")
    public MobileElement pernikahanDropDown;

    @iOSFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypePicker/XCUIElementTypePickerWheel")
    public MobileElement pernikahanStatus;

    @iOSFindBy(id = "Tempat Lahir")
    public MobileElement temaptLahirText;

    @iOSFindBy(id ="Tanggal lahir")
    public MobileElement tanggalLahirText;

    /**
     ** Methods for each elements on Home page
     **/
//======================================================================================================================
    public String getDataPribadiText(){
        org.junit.Assert.assertTrue("Failed: data pribadi page is not displayed", dataPribadiPage.isDisplayed());
        return dataPribadiPage.getText();
    }

    public void checkDataPribadiPage(String data_pribadi){
        org.junit.Assert.assertEquals("Failed: Data Pribadi text is invalid", data_pribadi, getDataPribadiText());
        waitFor(1);
        isElementPresent(form4Number);
    }
    public void inputFullName(String full_name){
        clearEnterText(nameField, full_name);
        clickDone();
        waitFor(1);
    }
    public void clickJenisKelamin(){
        Assert.assertTrue("Failed: Jenis Kelamin Dropdown is not displayed", jenisKelaminDropDown.isDisplayed());
        jenisKelaminDropDown.click();
        clickDone();
        waitFor(1);
    }
    public void inputTempatLahir(String tempat_lahir){
        clearEnterText(tempatLahir, tempat_lahir);
        clickDone();
        waitFor(1);
    }
    public void clickDateOfBirthDropdown(){
        Assert.assertTrue("Failed: Date of birth button is not displayed", dateOfBirthDropdown.isDisplayed());
        dateOfBirthDropdown.click();
    }

    private String[] getDateOfBirth(String dateOfBirth) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
        SimpleDateFormat newDateFormat = new SimpleDateFormat("MMMMM dd yyyy");

//        Date newDate = newDateFormat.parse(dateOfBirth,newDateFormat) ;
        return newDateFormat.format(parseDateFormat(dateFormat, dateOfBirth)).split(" ");
    }
    public void setDateOfBirth(String dateOfBirth) {
        String[] parts = getDateOfBirth(dateOfBirth);
        clickDateOfBirthDropdown();
        inputFirstPicker(parts[0]);
        inputSecondPicker(parts[1]);
        inputThirdPicker(parts[2]);
        clickDone();
    }
    public void setAgama(String input_agama){
        agamaDropDown.click();
        enterText(agama, input_agama);
        clickDone();
        waitFor(2);
    }

//    public void clickSelengkapnyaButton(){
//        TouchAction touchAction = new TouchAction(driver);
//        String selengkapnyaDeskripsi = "//XCUIElementTypeButton[@label ='Selengkapnya']";
//        if (!isElementPresent(driver,selengkapnyaDeskripsi)){
//            touchAction.press(PointOption.point(145, 560)).moveTo(PointOption.point(43, -119)).release().perform();
//            waitFor(1);
//        }
//        touchAction.press(PointOption.point(145, 560)).moveTo(PointOption.point(43, -119)).release().perform();
//        clickElement(driver,selengkapnyaDeskripsi);
//        waitInSeconds(3);
//    }

    public void scrollScreen11(int startX, int startY, int endX, int endY){
        new TouchAction(driver).press(startX, startY).moveTo(endX, endY).release().perform();
    }

    public void setStatusPernikahan(String status_pernikahan){
//        swipeTheScreen();
//        pageContentScroll("up");
//        pageContentScroll("down");
//        scrollScreen(tanggalLahirText,temaptLahirText);
//        swiptToBottom();
//        swipeToDirection(agamaDropDown, "down");
        swiptswipt();
        waitFor(2);
        pernikahanDropDown.click();
        enterText(pernikahanStatus, status_pernikahan);
        clickDone();
    }

    public void inputDataPribadi(String full_name,String tempat_lahir,String dateOfBirth,
                                 String input_agama,String status_pernikahan)
    {
        inputFullName(full_name);
        clickJenisKelamin();
        inputTempatLahir(tempat_lahir);
        setDateOfBirth(dateOfBirth);
        setAgama(input_agama);
        setStatusPernikahan(status_pernikahan);
        clickSelanjutnyaBtn();
    }


//=====================================================================================================================

    public void stepsDetailDataKamuPage() {
        steps("check page detail data kamu");
        checkDataPribadiPage("Detail data kamu");
        steps("input full name");
        inputFullName("Wembo Automate");
        steps("input gender");
        clickJenisKelamin();
        steps("input tempat lahir");
        inputTempatLahir("California");
        steps("input tanggal lahir");
        setDateOfBirth("4/19/1990");
        swiptswipt();
        steps("input agama");
        setAgama("Hindu");
        steps("input marriage status");
        setStatusPernikahan("Menikah");
        steps("klik selanjutnya button");
        clickSelanjutnyaBtn();
        waitingLoadingSpinner();
    }

}
