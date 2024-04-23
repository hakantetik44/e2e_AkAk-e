package utils;
import static stepdefinitions.Hooks.bundleId;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.options.BaseOptions;
import stepdefinitions.Hooks;


import java.net.MalformedURLException;
import java.net.URL;


public class Driver {
    private Driver() {
    }
    public static IOSDriver iOS;
    public static AndroidDriver Android;

    public static BaseOptions getAndroidApps(){
        BaseOptions options = new BaseOptions()
            .amend("appium:platformeVersion", "12")
            .amend("appium:deviceName", "R5CT4308RMB")
            .amend("appium:automationName", "UiAutomator2")
            .amend("appium:udid", "RF8N92CM2GM")
            .amend("appium:noReset", true)
            .amend("appium:wdaLocalPort", "7100")
            .amend("appium:platformName", "Android")
            .amend("appium:app", "/Users/nicola/Documents/GitLab/e2e_overkiz/src/test/resources/Apps/" + Hooks.apk)
            .amend("appium:connectHardwareKeyboard", true)
            .amend("appium:appWaitPackage", Hooks.getAppPackage(Hooks.apk))
            .amend("appium:newCommandTimeout", 3600);
        return options;
    }

    public static AndroidDriver getAndroidDriver(BaseOptions capabilities)
        throws MalformedURLException {
        URL remoteUrl = new URL("http://127.0.0.1:4723/");
        return new AndroidDriver(remoteUrl, capabilities);
    }

    public static BaseOptions getiOSApps(){
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
            .amend("appium:platformName", "iOS")
            .amend("appium:newCommandTimeout", 3600)
            .amend("appium:connectHardwareKeyboard", true);
        return options;
    }

    public static IOSDriver getiOSDriver(BaseOptions Caps) throws MalformedURLException {
        URL remoteUrl = new URL("http://127.0.0.1:4723/");
        return new IOSDriver(remoteUrl, Caps);
    }





    /**
     * get driver.
     *
     * @return appiumDriver
     */
    public static AppiumDriver getCurrentDriver() {
        if (OS.OS.equals("Android")) {
            return Android;
        } else if (OS.OS.equals("iOS")) {
            return iOS;
        } else {
            throw new IllegalStateException("Système d'exploitation non supporté: " + OS.OS);
        }
    }

}