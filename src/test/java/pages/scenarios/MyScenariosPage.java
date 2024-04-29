package pages.scenarios;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import stepdefinitions.Hooks;
import utils.Driver;
import utils.OS;

import java.net.MalformedURLException;


public class MyScenariosPage {

    public String appName = getAppName(Hooks.apk);

    public MyScenariosPage() throws MalformedURLException, InterruptedException {

        PageFactory.initElements(new AppiumFieldDecorator(Driver.getCurrentDriver()), this);

    }


    @AndroidFindBy(xpath = "(//android.widget.RadioButton)[2]")
    public WebElement serverStd;

    @AndroidFindBy(xpath = "(//android.widget.EditText)[1]")
    public WebElement editText105;

    @AndroidFindBy(className = "android.widget.EditText")
    public WebElement editText;

    @AndroidFindBy(xpath = "(//android.widget.TextView)[3]")
    public WebElement tvOk;

    @AndroidFindBy(xpath = "(//android.widget.TextView)[3]")
    public WebElement textMotDePasse;

    @AndroidFindBy(xpath = "(//android.widget.TextView)[1]")
    public WebElement titleConnexion;

    @AndroidFindBy(xpath = "(//android.widget.EditText)[1]")
    public WebElement placeHolderEmail;


    @AndroidFindBy(xpath = "(//android.widget.EditText)[1]")
    public WebElement placeHolderMotDePasse;

    @AndroidFindBy(xpath = "(//android.widget.EditText)[2]")
    public WebElement getPlaceHolderMotDePasseText;
    @AndroidFindBy(xpath = "(//android.widget.TextView)[4]")
    public WebElement btnSeConnecter;

    @AndroidFindBy(xpath = "(//android.widget.TextView)[7]")
    public WebElement invalidSnackbarText;


    public WebElement btnOXIMOio;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Géolocaliser\"]")
    public WebElement btnRS100io;


    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"STD24\"]")
    public WebElement placeServeurDeConnexion;


    @AndroidFindBy(id = "com.overkiz.kizconnect:id/et_login")
    public WebElement placeHolderLogin;
    @AndroidFindBy(id = "com.overkiz.kizconnect:id/et_password")
    public WebElement placeComteSecondaireMDP;

    @AndroidFindBy(id = "com.overkiz.kizconnect:id/et_confirm_pw")
    public WebElement placeComteSecondaiConfirmerMDP;

    @AndroidFindBy(id = "com.overkiz.kizconnect:id/tv_valide")
    public WebElement btnCréer;

    @AndroidFindBy(xpath = "(//android.widget.TextView)[3]")
    public WebElement btnNotification;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"ic_login_logo\"")
    public WebElement logoOvezKizIos;

    @AndroidFindBy(xpath = "(//android.widget.ImageView)[2]")
    public WebElement logoOverKizConnect; //

    public By
            btnGeolocaliser = OS.isAndroid() ? By.id("com.overkiz." + appName + ":id/tv_geolocalisation") : By.id("Géolocaliser");

    public By
            btnAutoriserToujours = OS.isAndroid() ? By.id("com.overkiz." + appName + ":id/permission_allow_always_button") : By.xpath("(//XCUIElementTypeButton)[12]");

    public By
            titleMesScenarios = OS.isAndroid() ? By.id("com.overkiz." + appName + ":id/label_title") : By.id("Mes scénarios");

    public By
            testScenario = OS.isAndroid() ? By.id("com.overkiz." + appName + ":id/name") : By.id("test");

    public By
            btnScenario = OS.isAndroid() ? By.id("com.overkiz." + appName + ":id/nav_scenario") : By.id("Scénarios");

    public By
            btnDesactiver = OS.isAndroid() ? By.id("com.overkiz." + appName + ":id/tv_deactivate") : By.xpath("(//XCUIElementTypeButton)[10]");
    public By
            btnToujoursActiver = OS.isAndroid() ? By.id("com.overkiz." + appName + ":id/tv_activate_always") : By.xpath("(//XCUIElementTypeButton)[11]");
    public By
            btnActiverUneFois = OS.isAndroid() ? By.id("com.overkiz." + appName + ":id/tv_activate_once") : By.xpath("(//XCUIElementTypeButton)[12]");
   public By
            textDistanceDuDomicile = OS.isAndroid() ? By.id("com.overkiz." + appName + ":id/label_distance") : By.id("Distance du domicile");

    public By
            btnRetour = OS.isAndroid() ? By.id("com.overkiz." + appName + ":id/im_back") : By.xpath("(//XCUIElementTypeButton)[9]");

    public By
            btnEnregister = OS.isAndroid() ? By.id("com.overkiz." + appName + ":id/tv_enregister") : By.id("Enregistrer");

    public By
            progressBarr = OS.isAndroid() ? By.id("com.overkiz." + appName + ":id/progress_distance") : By.id("Enregistrer");


    public String getAppName(String app) {
        if (OS.OS.equals("Android")) {
            switch (app) {
                case "kizconnect.apk":
                    return "kizconnect";
                case "FlexomV3.apk":
                    return "flexomv3";
                case "hexaconnect.apk":
                    return "hexaom";
                case "wisniowski.apk":
                    return "wisniowski";
                default:
                    return null;
            }
        }
        return null;
    }
}
