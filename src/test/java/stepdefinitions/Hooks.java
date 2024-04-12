package stepdefinitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.Driver;
import java.net.MalformedURLException;
import java.util.*;

import static utils.Driver.getDriver;
import static utils.Driver.quitDriver;

public class Hooks {
    public static String apk;
    private static final Map<String, String> apkMap = new HashMap<>();
    private static final List<String> availableApks = new ArrayList<>();
    private static final Queue<String> lastThreeSelectedApks = new LinkedList<>();

    static {
        apkMap.put("@kizconnectAndroid", "kizconnect.apk");
        apkMap.put("@hexaconnectAndroid", "hexaconnect.apk");
        apkMap.put("@wisniowskiAndroid", "wisniowski.apk");
        apkMap.put("@flexomV3Android", "FlexomV3.apk");
        availableApks.addAll(apkMap.values());
    }

    public static String getApkForTags(List<String> tags) {
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
    public void setUpMobile(Scenario scenario) throws MalformedURLException, InterruptedException {

        List<String> tags = (List<String>) scenario.getSourceTagNames();
        String apk = getApkForTags(tags);
        if (apk != null) {
            Hooks.apk = apk;
            System.out.println("Scenario tags: " + tags);
            System.out.println("Selected APK: " + apk);
        }
    }

    @After()
    public void tearDownMobile(Scenario scenario) throws MalformedURLException, InterruptedException {
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
