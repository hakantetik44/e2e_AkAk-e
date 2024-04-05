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
    private static AppiumDriver appiumDriver;
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
                    iosOptions.XCODE_ORG_ID_OPTION.contains("");
                    iosOptions.setBundleId("com.saucelabs.mydemoapp.rn")
                            .setDeviceName("iPhone 15 pro")
                            .setPlatformVersion("17.4")
                            .setUdid("")
                            .setApp("/Users/macbook/IdeaProjects/e2e_SomfyProject/src/test/resources/Apps/iOS-Real-Device-MyRNDemoApp.1.3.0-162.ipa")
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
    public static void quitDriver() {
        if (appiumDriver != null) {
            appiumDriver.quit();
            appiumDriver = null;
        }}

    public static boolean isAppiumServerRunning(String host, int port) {
        try (Socket socket = new Socket(host, port)) {
            return true;
        } catch (IOException e) {
            return false;
        }
    }

}

