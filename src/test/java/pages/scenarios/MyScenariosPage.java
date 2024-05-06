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



    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"STD24\"]")
    public WebElement placeServeurDeConnexion;


    @AndroidFindBy(id = "com.overkiz.kizconnect:id/et_login")
    public WebElement placeHolderLogin;
    @AndroidFindBy(id = "com.overkiz.kizconnect:id/et_password")
    public WebElement placeComteSecondaireMDP;

    @AndroidFindBy(id = "com.overkiz.kizconnect:id/et_confirm_pw")
    public WebElement placeComteSecondaiConfirmerMDP;


    @iOSXCUITFindBy(iOSNsPredicate = "name == \"ic_login_logo\"")
    public WebElement logoOvezKizIos;

    @AndroidFindBy(xpath = "(//android.widget.ImageView)[2]")
    public WebElement logoOverKizConnect; //


    public By
            btnLogement= OS.isAndroid() ? By.xpath("//android.widget.TextView[@text=\"Logement\"]") : By.xpath("//XCUIElementTypeStaticText[@name=\"Logement\"]");

    public By
            btnOximoIo= OS.isAndroid() ? By.id("com.overkiz." + appName + ":id/name") : By.id("OXIMO io");

    public By
            btnTerminer= OS.isAndroid() ? By.id("com.overkiz." + appName + ":id/tv_validate") : By.id("Terminer");

    public By
            btnValider= OS.isAndroid() ? By.id("com.overkiz." + appName + ":id/tv_valid") : By.id("Valider");

    public By
            btnAjouterUnEquipement= OS.isAndroid() ? By.id("com.overkiz." + appName + ":id/tv_add") : By.xpath("(//XCUIElementTypeOther/XCUIElementTypeButton)[7]");

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
            btnRetour = OS.isAndroid() ? By.id("com.overkiz." + appName + ":id/ic_back") : By.xpath("(//XCUIElementTypeButton)[9]");

    public By
            btnSupprimer = OS.isAndroid() ? By.xpath("//android.widget.Button[@text=\"SUPPRIMER\"]") : By.xpath("(//XCUIElementTypeButton)[9]");


    public By
            btnEnregister = OS.isAndroid() ? By.id("com.overkiz." + appName + ":id/tv_enregister") : By.id("Enregistrer");

    public By
            progressBarr = OS.isAndroid() ? By.id("com.overkiz." + appName + ":id/progress_distance") : By.id("Enregistrer");

    public By
            snackbarText= OS.isAndroid() ? By.id("com.overkiz." + appName + ":id/snackbar_text") : By.xpath("//XCUIElementTypeStaticText[starts-with(@name, 'Le scénario ') and (contains(@name, 'créé avec succès') or contains(@name, 'mis à jour avec succès') or contains(@name, 'a été supprimé'))]");

    public By
            btnFermer= OS.isAndroid() ? By.id("com.overkiz." + appName + ":id/tv_off") : By.xpath("//XCUIElementTypeStaticText[@name=\"Fermer\"]");

    public By
            btnOuvrir= OS.isAndroid() ? By.id("com.overkiz." + appName + ":id/tv_on") : By.id("Ouvrir");

    public By
            btnCréerUnScénario= OS.isAndroid() ? By.id("com.overkiz." + appName + ":id/addTitle") : By.xpath("(//XCUIElementTypeOther/XCUIElementTypeButton)[1]");

    public By
            btnNommezScénario= OS.isAndroid() ? By.id("com.overkiz." + appName + ":id/et_piece_name") : By.xpath("//XCUIElementTypeTextField");

    public By
            iconeScénario = OS.isAndroid() ? By.xpath("//android.widget.ImageView[5]") : By.id("scenario_movie");

    public By
            textSupprimer = OS.isAndroid() ? By.xpath("//android.widget.TextView[@resource-id=\"android:id/message\"]"): By.id("Suivant");

    public By
            btnSuivant = OS.isAndroid() ? By.id("com.overkiz." + appName + ":id/tv_next") : By.id("Suivant");



    public By
            getBtnScenario2 = OS.isAndroid() ? By.xpath("//android.view.ViewGroup[2]") : By.xpath("//XCUIElementTypeStaticText[@label=\"Adresse\"]");
    public By
          getIconeSelectionné   = OS.isAndroid() ? By.xpath("//android.widget.ViewSwitcher/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.ImageView[2]") : By.id("check");

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
