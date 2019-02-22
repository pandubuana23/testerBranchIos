package common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;

/**
 *  Created by novi on 10/9/2018
 */
public class AppiumDriverBuilder {
    @Rule
    public TestName testname = new TestName();
    public static AppiumDriver driver;
    public static AppiumDriver getDriver(){return driver;}

    /**
     * Establish a connetion to TestObject, or to a local device test is local
     *@throws Exception
     */
    public void setDriver() throws Exception{
        File appDir = new File(Constants.DEFAULT_APP_PATH);
        File app = new File(Constants.IOS_APP_NAME);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, Constants.DEFAULT_IOS_PLATFORM_VERSION);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, Constants.DEFAULT_IOS_DEVICE_NAME);
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 320000);
        capabilities.setCapability("launchTimeout", 180000);
        driver= new IOSDriver(new URL(Constants.WD_URL), capabilities);

    }

    public static int step;
    public static int stepTests;
    public void steps(String message){
        System.out.println("* " + message);
//        step = (step);
    }
    public void stepTests(String message){
        System.out.println(stepTests + ". " + message);
        stepTests = (stepTests + 1);
    }

    public void setStep() { step = 1; }
    public int getStep() { return step; }






}
