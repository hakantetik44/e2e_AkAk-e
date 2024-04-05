package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.junit.runner.JUnitCore;
import io.appium.java_client.AppiumDriver;
import runner.RunCucumberTest;
import utils.Driver;
import java.net.MalformedURLException;
import static utils.Driver.quitDriver;

public class Hooks {
    private static AppiumDriver appiumDriver;
    public static AppiumDriver getDriver() {
        return appiumDriver;
    }
    public static String apk;
    private static int apkIndex = -1; // Nous commençons par -1, car après l'incrémentation, il deviendra 0.
    private static String[] apkList = {"kizconnect.apk", "hexaconnect.apk", "FlexomV3.apk"};
    private static boolean testRunCompleted = false;

    @Before()
    public void setUpMobile() throws MalformedURLException, InterruptedException {
        if (!testRunCompleted) {
            Driver.getDriver();
        }}

    @After
    public void afterScenario() {
        if (!testRunCompleted) {
            quitDriver();
            System.out.println("Le afterScenario est exécuté ici");
            // Après chaque scénario, nous choisissons l'APK suivant
            apkIndex++;
            if (apkIndex >= apkList.length) {
                testRunCompleted = true; // Tous les tests sont terminés
                return;
            }
            apk = apkList[apkIndex];
            System.out.println("Exécution des tests pour l'APK : " + apk);
            runTestRunner();
        }}

    private void runTestRunner() {
        Class<?> testClass = RunCucumberTest.class;
        JUnitCore junit = new JUnitCore();
        junit.run(testClass);
    }
}