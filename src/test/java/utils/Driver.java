package utils;
import static stepdefinitions.Hooks.bundleId;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.options.BaseOptions;
import stepdefinitions.Hooks;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;




public class Driver {
    private Driver() {
    }
    private static UiAutomator2Options options;
    public static AppiumDriver appiumDriver;

    public static AppiumDriver getDriver() {

        if (appiumDriver== null) {
            switch (ConfigReader.getProperty("platformName")) {
                case "Android":
                    String appUrl=System.getProperty("user.dir")
                            + File.separator +"src"
                            + File.separator +"test"
                            + File.separator +"resources"
                            + File.separator +"Apps"
                            + File.separator + Hooks.apk;
                    System.out.println("appUrl = " + appUrl);
                    options = new UiAutomator2Options()
                            .setAutomationName(ConfigReader.getProperty("automationName"))
                            .setPlatformVersion(ConfigReader.getProperty("platformVersion"))
                            .setDeviceName(ConfigReader.getProperty("deviceName"))
                            //.setAppActivity("com.bouygues.flexom.views.main.MainActivity")
                            //  .setAppPackage("com.overkiz.kizconnect")
                            .setApp(appUrl)
                            .setNoReset(false)
                            .setNewCommandTimeout(Duration.ofMinutes(10));
                    try {
                        appiumDriver = new AndroidDriver(
                                new URL("http://127.0.0.1:4723"), options
                        );
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);}
                    break;
                case "IOS":
                    System.out.println("bundle ID = ->" + bundleId );
                    BaseOptions options = new BaseOptions()
                            .amend("appium:deviceName", "iPhone de Phillipe (2)")
                            .amend("appium:platformeVersion", "15.8")
                            .amend("appium:noReset", true)
                            .amend("appium:automationName", "XCUITest")
                            .amend("appium:udid", "081e0d0b4ebe6ba46dd0acf2e7b7e3534056bc9f")
                            .amend("appium:bundleId", bundleId)
                            .amend("appium:wdaLocalPort", "8100")
                            .amend("appium:language", "fr")
                            .amend("appium:locale", "FR")
                            //.amend("appium:version", "iPhone de Nicolas")
                            .amend("appium:platformName", "iOS")
                            .amend("appium:newCommandTimeout", 3600)
                            .amend("appium:connectHardwareKeyboard", true);

                    try {
                        appiumDriver = new IOSDriver(
                                new URL("http://127.0.0.1:4723"), options
                        );
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
            }}
        appiumDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return appiumDriver;
    }


    public static void quitDriver() {
        if (appiumDriver != null) {
            appiumDriver.quit();
            appiumDriver = null;
        }}

    public static void killApp(String apkPackageName) {
        if (appiumDriver instanceof IOSDriver) {
            IOSDriver iosDriver = (IOSDriver) appiumDriver;
            iosDriver.terminateApp(Hooks.bundleId);
            iosDriver.quit();
        } else if (appiumDriver instanceof AndroidDriver) {
            AndroidDriver androidDriver = (AndroidDriver) appiumDriver;

            androidDriver.quit();
        }
    }


}