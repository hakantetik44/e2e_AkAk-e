package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.options.BaseOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.net.MalformedURLException;
import java.net.URL;
import stepdefinitions.Hooks;

public class Driver {
    private Driver() {
    }

    public static AndroidDriver Android;
    public static WebDriver Web;

    public static BaseOptions getAndroidApps() {
        BaseOptions options = new BaseOptions()
                .amend("appium:platformeVersion", "10.0")
                .amend("appium:deviceName", "Samsung")
                .amend("appium:automationName", "UiAutomator2")
                .amend("appium:noReset", true)
                .amend("appium:wdaLocalPort", "7100")
                .amend("appium:platformName", "Android")
                .amend("appium:app", "/Users/hakan/IdeaProjects/e2e_overkiz/src/test/resources/Apps/" + Hooks.APK_NAME)
                .amend("appium:connectHardwareKeyboard", false)
                .amend("appium:appWaitPackage", Hooks.getAppPackage())
                .amend("appium:newCommandTimeout", 3600);
        return options;
    }

    public static AndroidDriver getAndroidDriver(BaseOptions capabilities)
            throws MalformedURLException {
        URL remoteUrl = new URL("http://127.0.0.1:4723/");
        return new AndroidDriver(remoteUrl, capabilities);
    }

    public static WebDriver getWebDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                return new ChromeDriver();
            case "firefox":
                return new FirefoxDriver();
            case "edge":
                return new EdgeDriver();
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }

    /**
     * get driver.
     *
     * @return driver
     */
    public static WebDriver getCurrentDriver() {
        if (OS.OS.equals("Android")) {
            return Android;
        } else if (OS.OS.equals("Web")) {
            return Web;
        } else {
            throw new IllegalStateException("Unsupported operating system: " + OS.OS);
        }
    }
}