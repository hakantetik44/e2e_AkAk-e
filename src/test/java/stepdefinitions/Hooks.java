package stepdefinitions;

import static utils.Driver.getCurrentDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import java.net.MalformedURLException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.Driver;
import utils.OS;


public class Hooks {
    public static String apk;
    public static String bundleId;


    @Given("Je lance mon app {string}")
    public void launchapp(String appname) throws MalformedURLException {
        if(OS.OS.equals("Android")){
            String apk = getApkForTags(appname);
            if (apk != null) {
                Hooks.apk = apk;
                System.out.println("Scenario tags: " + appname);
                System.out.println("Selected APK: " + apk);
                Driver.Android = Driver.getAndroidDriver(Driver.getAndroidApps());
            }
        }else {
            String bundleId = getBundleIdForTags(appname);
            if (bundleId != null) {
                Hooks.bundleId = bundleId;
                System.out.println("Scenario tags: " + appname);
                System.out.println("Selected Bundle ID: " + bundleId);
                Driver.iOS = Driver.getiOSDriver(Driver.getiOSApps());
            }
        }
    }

    public static String getBundleIdForTags(String app) {
        return switch (app) {
            case "kizconnect" -> "com.overkiz.kizconnect";
            case "hexaconnect" -> "com.overkiz.hexaom";
            case "wisniowski" -> "pl.wisniowski.smartCONNECTED";
            case "flexomV3" -> "com.overkiz.flexomv3";
            default -> null;
        };
    }

    public static String getApkForTags(String app) {
        return switch (app) {
            case "kizconnect" -> "kizconnect.apk";
            case "hexaconnect" -> "hexaconnect.apk";
            case "wisniowski" -> "wisniowski.apk";
            case "flexomV3" -> "FlexomV3.apk";
            default -> null;
        };
    }

    @Before()
    public void beforeAll(Scenario scenario) throws MalformedURLException {
        OS.OS=ConfigReader.getProperty("platformName");
    }

    @After()
    public void tearDownMobile(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot;
            WebDriver driver = Driver.getCurrentDriver() ;
            if (driver != null && driver instanceof TakesScreenshot) {
                screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            } else {
                screenshot = new byte[0];
            }
            scenario.attach(screenshot, "image/png", "screenshot");
        }
        quitDriver();
    }

    public static String getAppPackage(String app){
        switch (app){
            case "kizconnect.apk":
                return "com.overkiz.kizconnect";
            case "FlexomV3.apk":
                return "com.overkiz.flexomv3";
            case "hexaconnect.apk":
                return "com.overkiz.hexaom";
            case "wisniowski.apk":
                return "com.overkiz.wisniowski";
        }
        return null;
    }


    public void killApplication(AndroidDriver driver){
        driver.terminateApp(getAppPackage(Hooks.apk));
    }

    public void killApplication(IOSDriver driver){
        driver.terminateApp(bundleId);
    }

    public void quitDriver() {
        if(OS.OS.equals("Android"))
            killApplication(Driver.Android);
        if(OS.OS.equals("iOS"))
            killApplication(Driver.iOS);
        getCurrentDriver().quit();
    }




}