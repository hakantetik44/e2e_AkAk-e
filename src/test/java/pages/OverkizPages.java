package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import stepdefinitions.Hooks;
import utils.Driver;
import utils.OS;


public class OverkizPages {

    public String appName = getAppName(Hooks.apk);

    public OverkizPages() throws MalformedURLException, InterruptedException {

        PageFactory.initElements(new AppiumFieldDecorator(Driver.getCurrentDriver()), this);

    }


    @AndroidFindBy(xpath = "(//android.widget.ImageView)[2]")
    public WebElement logoOverKizConnect; //

    @AndroidFindBy(xpath = "(//android.widget.RadioButton)[2]")
    public WebElement serverStd;

    @AndroidFindBy(xpath = "(//android.widget.EditText)[1]")
    public WebElement editText105;

    @AndroidFindBy(className = "android.widget.EditText")
    public WebElement editText;

    @AndroidFindBy(xpath = "(//android.widget.TextView)[3]")
    public WebElement tvOk;

    @AndroidFindBy(id = "com.overkiz.kizconnect:id/tv_ok")
    public WebElement getTvOk;
    @AndroidFindBy(xpath = "(//android.widget.TextView)[2]")
    public WebElement textEmail;

    @AndroidFindBy(xpath = "(//android.widget.TextView)[3]")
    public WebElement textMotDePasse;

    @AndroidFindBy(xpath = "(//android.widget.TextView)[1]")
    public WebElement titleConnexion;

    @AndroidFindBy(xpath = "(//android.widget.EditText)[1]")
    public WebElement placeHolderEmail;

    @AndroidFindBy(id="com.overkiz.kizconnect:id/zone_pw")
    public WebElement getTvPw;

    @AndroidFindBy(xpath = "(//android.widget.EditText)[1]")
    public WebElement placeHolderMotDePasse;

    @AndroidFindBy(xpath = "(//android.widget.EditText)[2]")
    public WebElement getPlaceHolderMotDePasseText;
    @AndroidFindBy(xpath = "(//android.widget.TextView)[4]")
    public WebElement btnSeConnecter;

    @AndroidFindBy(xpath = "(//android.widget.TextView)[1]")
    public WebElement textBonjourName;

    @AndroidFindBy(xpath = "(//android.widget.TextView)[7]")
    public WebElement invalidSnackbarText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Logement\"]")
    public WebElement btnLogement;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Android vide\"]")
    public WebElement btnAndroidVide;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Accueil\"]")
    public WebElement btnAccueil;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Scénarios\"]")
    public WebElement btnScénarios;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"En plus\"]")
    public WebElement btnEnPlus;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Conso\"]")
    public WebElement btnConso;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"OXIMO io\"]")
    public WebElement btnOXIMOio;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"RS100 io\"]")
    public WebElement btnRS100io;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"BL_Actuator\"]")
    public WebElement btnBL_Actuator;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Zone 1\"]")
    public WebElement btnZone1;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Mes Favoris\"]")
    public WebElement btnMesFavoris;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Mes informations personnelles\"]")
    public WebElement btnMesInformations;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Changer de mot de passe\"]")
    public WebElement btnchangerMotDePasse;


    @AndroidFindBy(xpath = "(//android.widget.EditText)[1]")
    public WebElement placePrénom;

    @AndroidFindBy(xpath = "(//android.widget.EditText)[2]")
    public WebElement placeNom;
    @AndroidFindBy(xpath = "(//android.widget.EditText)[3]")
    public WebElement placeTéléphone;

    @AndroidFindBy(xpath = "(//android.widget.EditText)[4]")
    public WebElement placeEmail;


    @AndroidFindBy(xpath = "(//android.widget.EditText)[5]")
    public WebElement placeAdresse;

    @AndroidFindBy(xpath = "(//android.widget.TextView)[3]")
    public WebElement btnModifier;

    @AndroidFindBy(xpath = "(//android.widget.EditText)[1]")
    public WebElement placeHolderMesInformations;

    @AndroidFindBy(xpath = "(//android.widget.Button)[1]")
    public WebElement btnAutoriser;
    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_always_button")
    public WebElement btnAutoriserToujours;
    @AndroidFindBy(id = "com.overkiz.kizconnect:id/snackbar_text")
    public WebElement snackbarText;





    @AndroidFindBy(id = "com.overkiz.kizconnect:id/edit_text_city")
    public WebElement placeHolderVille;

    @AndroidFindBy(id = "com.overkiz.kizconnect:id/edit_text_country")
    public WebElement placeHolderPays;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Europe/Paris\"]")
    public WebElement placeFuseauHoraire;

    @AndroidFindBy(xpath = "(//android.widget.EditText)[4]")
    public WebElement placeCoordonnées;

    @AndroidFindBy(xpath = "(//android.widget.EditText)[5]")
    public WebElement placeLeverDeSoleil;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"2202-5934-6827\"]")
    public WebElement placeNuméroParselle;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"STD24\"]")
    public WebElement placeServeurDeConnexion;


    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.overkiz.kizconnect:id/rv_scenario\"]/android.view.ViewGroup")
    public WebElement Scénarios;

    @AndroidFindBy(id = "com.overkiz.kizconnect:id/tv_geolocalisation")
    public WebElement btnGeolocalisation;

    @AndroidFindBy(id = "android:id/button1")
    public WebElement btnOk;
    @AndroidFindBy(id = "com.overkiz.kizconnect:id/tv_deactivate")
    public WebElement btnDésactiver;
    @AndroidFindBy(id = "com.overkiz.kizconnect:id/tv_activate_always")
    public WebElement btnToujoursActiver;
    @AndroidFindBy(id = "com.overkiz.kizconnect:id/tv_activate_once")
    public WebElement btnActiverUneFois;
    @AndroidFindBy(id = "com.overkiz.kizconnect:id/progress_distance")
    public WebElement progressDistance;

    @AndroidFindBy(id = "com.overkiz.kizconnect:id/label_distance")
    public WebElement textDistanceDeDomicile;
    @AndroidFindBy(id = "com.overkiz.kizconnect:id/im_back")
    public WebElement btnRetour;
    @AndroidFindBy(id = "com.overkiz.kizconnect:id/tv_enregister")
    public WebElement btnEnregister;
    @AndroidFindBy(xpath = "(//android.widget.TextView)[4]")
    public WebElement btnGérerMesAccèsSecondaires;
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


    public By
        buttonNavMore = OS.isAndroid() ? By.id("com.overkiz."+appName+":id/nav_more") : By.id("finishFooter");



    public static String getAppName(String app){
        switch (app){
            case "kizconnect.apk":
                return "kizconnect";
            case "FlexomV3.apk":
                return "flexomv3";
            case "hexaconnect.apk":
                return "hexaom";
            case "wisniowski.apk":
                return "wisniowski";
        }
        return null;
    }
}
