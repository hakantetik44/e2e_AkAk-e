package stepdefinitions;

import static utils.Driver.getCurrentDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.Driver;
import utils.OS;


public class Hooks {
    public static String apk;
    public static String bundleId;


    private static final Map<String, String> apkMap = new HashMap<>();
    private static final List<String> availableApks = new ArrayList<>();
    private static final Queue<String> lastThreeSelectedApks = new LinkedList<>();
    private static final Map<String, String> bundleIdMap = new HashMap<>();
    private static final List<String> availableBundleIds = new ArrayList<>();
    private static final Queue<String> lastThreeSelectedBundleIds = new LinkedList<>();


    public static String getBundleIdForTags(List<String> tags) {
        bundleIdMap.put("@kizconnect", "com.overkiz.kizconnect");
        bundleIdMap.put("@hexaconnect", "com.overkiz.hexaom");
        bundleIdMap.put("@wisniowski", "pl.wisniowski.smartCONNECTED");
        bundleIdMap.put("@flexomV3", "com.overkiz.flexomv3");
        availableBundleIds.addAll(bundleIdMap.values());

        List<String> bundleIdList = new ArrayList<>();
        for (String tag : tags) {
            if (bundleIdMap.containsKey(tag)) {
                bundleIdList.add(bundleIdMap.get(tag));
            }
        }
        if (!bundleIdList.isEmpty()) {
            bundleIdList.removeAll(lastThreeSelectedBundleIds);
            Random random = new Random();
            int index = random.nextInt(bundleIdList.size());
            String selectedBundleId = bundleIdList.get(index);

            lastThreeSelectedBundleIds.add(selectedBundleId);
            if (lastThreeSelectedBundleIds.size() > 3) {
                lastThreeSelectedBundleIds.poll();
            }
            return selectedBundleId;
        }
        return null;
    }

    public static String getApkForTags(List<String> tags) {
        apkMap.put("@kizconnect", "kizconnect.apk");
        apkMap.put("@hexaconnect", "hexaconnect.apk");
        apkMap.put("@wisniowski", "wisniowski.apk");
        apkMap.put("@flexomV3", "FlexomV3.apk");
        availableApks.addAll(apkMap.values());

        List<String> apkList = new ArrayList<>();
        for (String tag : tags) {
            if (apkMap.containsKey(tag)) {
                apkList.add(apkMap.get(tag));
            }
        }
        if (!apkList.isEmpty()) {
            apkList.removeAll(lastThreeSelectedApks);
            Random random = new Random();
            int index = random.nextInt(apkList.size());
            String selectedApk = apkList.get(index);

            lastThreeSelectedApks.add(selectedApk);
            if (lastThreeSelectedApks.size() > 3) {
                lastThreeSelectedApks.poll();
            }
            return selectedApk;
        }
        return null;
    }

    @Before()
    public void beforeAll(Scenario scenario) throws MalformedURLException {
        OS.OS=ConfigReader.getProperty("platformName");
        List<String> tags = (List<String>) scenario.getSourceTagNames();
        if(OS.OS.equals("Android")){
            String apk = getApkForTags(tags);
            if (apk != null) {
                Hooks.apk = apk;
                System.out.println("Scenario tags: " + tags);
                System.out.println("Selected APK: " + apk);
                Driver.Android = Driver.getAndroidDriver(Driver.getAndroidApps());
            }
        }else {
            String bundleId = getBundleIdForTags(tags);
            if (bundleId != null) {
                Hooks.bundleId = bundleId;
                System.out.println("Scenario tags: " + tags);
                System.out.println("Selected Bundle ID: " + bundleId);
                Driver.iOS = Driver.getiOSDriver(Driver.getiOSApps());
            }
        }

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