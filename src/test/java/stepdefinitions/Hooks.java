package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.Driver;
import java.net.MalformedURLException;
import java.util.List;

import static utils.Driver.quitDriver;
public class Hooks {
    private static AppiumDriver appiumDriver;
    public static AppiumDriver getDriver() {
        return appiumDriver;
    }
    public static String apk;
    public static int apkIndex = -1; // Nous commençons par -1, car après l'incrémentation, il deviendra 0.

    @Before()
    public void setUpMobile(Scenario scenario) throws MalformedURLException, InterruptedException {
        List<String> tags = (List<String>) scenario.getSourceTagNames();
        if (tags.contains("@kizconnectAndroid")) {
            apk = "kizconnect.apk";
        } else if (tags.contains("@hexaconnectAndroid")) {
            apk = "hexaconnect.apk";
        } else if (tags.contains("@wisniowskiAndroid")) {
            apk = "wisniowski.apk";
        } else if (tags.contains("@flexomV3Android")) {
            apk = "FlexomV3.apk";
        }

    }

    @After()
    public void tearDownMobile(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot;
            WebDriver driver = Driver.getDriver();
            if (driver != null && driver instanceof TakesScreenshot) {
                screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            } else {
                screenshot = new byte[0];
            }
            scenario.attach(screenshot, "image/png", "screenshot");
        }

        quitDriver();
    }
}