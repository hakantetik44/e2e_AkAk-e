package pages;


import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static utils.DriverMobile.getDriver;


public class OverkizPages {


    public OverkizPages() {

        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);

    }


    @AndroidFindBy(id = "com.overkiz.kizconnect:id/im_logo")
    public WebElement logoOverKizConnect;

    @AndroidFindBy(id = "com.overkiz.kizconnect:id/server_std")
    public WebElement serverStd;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"105\"]")
    public WebElement editText105;

    @AndroidFindBy(className = "android.widget.EditText")
    public WebElement editText;

    @AndroidFindBy(id = "com.overkiz.kizconnect:id/tv_ok")
    public WebElement tvOk;

    @AndroidFindBy(id = "com.overkiz.kizconnect:id/tv_email")
    public WebElement textEmail;

    @AndroidFindBy(id = "com.overkiz.kizconnect:id/tv_pw")
    public WebElement textMotDePasse;

    @AndroidFindBy(id = "com.overkiz.kizconnect:id/tv_title")
    public WebElement titleConnexion;

    @AndroidFindBy(id = "com.overkiz.kizconnect:id/zone_email")
    public WebElement placeHolderEmail;

    @AndroidFindBy(id = "com.overkiz.kizconnect:id/zone_pw")
    public WebElement placeHolderMotDePasse;

    @AndroidFindBy(id = "com.overkiz.kizconnect:id/input_pw")
    public WebElement getPlaceHolderMotDePasseText;
    @AndroidFindBy(id = "com.overkiz.kizconnect:id/tv_login")
    public WebElement btnSeConnecter;

    @AndroidFindBy(id = "com.overkiz.kizconnect:id/name")
    public WebElement textBonjourName;

    @AndroidFindBy(id = "com.overkiz.kizconnect:id/snackbar_text")
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

    @AndroidFindBy(id = "com.overkiz.kizconnect:id/tv_update")
    public WebElement btnModifier;

    @AndroidFindBy(id = "com.overkiz.kizconnect:id/et_email")
    public WebElement placeHolderMesInformations;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    public WebElement btnAutoriser;

    @AndroidFindBy(id = "com.overkiz.kizconnect:id/snackbar_text")
    public WebElement snackbarText;

    @AndroidFindBy(id = "com.overkiz.kizconnect:id/edit_text_address")
    public WebElement placeHolderAdresse;

    @AndroidFindBy(id = "com.overkiz.kizconnect:id/edit_text_code_postal")
    public WebElement placeHolderCodePostal;

    @AndroidFindBy(id = "com.overkiz.kizconnect:id/edit_text_city")
    public WebElement placeHolderVille;

    @AndroidFindBy(id = "com.overkiz.kizconnect:id/edit_text_country")
    public WebElement placeHolderPays;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Europe/Paris\"]")
    public WebElement placeFuseauHoraire;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Latitude : 44.920191300000006\n" +
            "Longitude : 4.902792\"]")
    public WebElement placeCoordonnées;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"6:46 / 20:40\"]")
    public WebElement placeLeverDeSoleil;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"2202-5934-6827\"]")
    public WebElement placeNuméroParselle;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"STD24\"]")
    public WebElement placeServeurDeConnexion;




}
