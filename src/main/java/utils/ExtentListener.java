package utils;

import org.junit.runner.notification.RunListener;

import java.io.InputStream;
import java.util.Properties;

public class ExtentListener extends RunListener {

    private static Properties prop = new Properties();
    private static ClassLoader loader = Thread.currentThread().getContextClassLoader();
    private static InputStream input = loader.getResourceAsStream( "report-dependencies.properties");
    private static String projectMongoName;
    private static String projectMongoServer;
//    private static ExtentTest test;

//    private  static  void extentFlush(ExtentTest test){
//        extent.endTest(test);

    }

