package utils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import stepdefinitions.Hooks;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.time.Duration;




public class Driver {
    private Driver() {
    }
    private static UiAutomator2Options options;
    private static XCUITestOptions iosOptions;
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
                    iosOptions = new XCUITestOptions();
                    iosOptions.XCODE_ORG_ID_OPTION.contains("somfy.test.auto@gmail.com" );
                    iosOptions
                            .setDeviceName("iPhone")
                            .setPlatformVersion("15.8.2")
                            .setUdid("081e0d0b4ebe6ba46dd0acf2e7b7e3534056bc9f")
                          // .setApp("/Users/hakan/IdeaProjects/e2e_overkiz/src/test/resources/Apps/Flexom.ipa")
                            .setAutomationName("XCUITest")
                            .setNoReset(false)
                            .setPlatformName("ios")
                            .setNewCommandTimeout(Duration.ofMinutes(10));

                    try {
                        appiumDriver = new IOSDriver(
                                new URL("http://127.0.0.1:4723"), iosOptions
                        );
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
            }}
        appiumDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return appiumDriver;
    }

    public static void setBundleId(String bundleId) {
        if (iosOptions != null) {
            iosOptions.setBundleId(bundleId);
        } else {
            throw new IllegalStateException("iosOptions is null. Make sure to call setBundleId after iosOptions initialization.");
        }

    }
    public static void quitDriver() {
        if (appiumDriver != null) {
            appiumDriver.quit();
            appiumDriver = null;
        }}


}

