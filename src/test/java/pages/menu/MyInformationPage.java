package pages.menu;

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

public class MyInformationPage {

    public String appName = getAppName(Hooks.apk);

    public MyInformationPage() throws MalformedURLException, InterruptedException {

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
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"RS100 io\"]")
    public WebElement btnRS100io;


    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_always_button")
    public WebElement btnAutoriserToujours;





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
            btnEnplus = OS.isAndroid() ? By.id("com.overkiz."+appName+":id/nav_more") : By.id("En plus");

    public By
            btnMesInfo = OS.isAndroid() ? By.id("com.overkiz."+appName+":id/label_google_assistant") : By.id("Mes informations personnelles ");

    public By
            listText = OS.isAndroid() ? By.className("android.widget.EditText") : By.linkText("Nom");

    public By
            placeEmail = OS.isAndroid() ? By.xpath("(//android.widget.EditText)[4]") :  By.name("valueLabel_UserInfoCell");

    public By
            textNom = OS.isAndroid() ? By.xpath("//android.widget.TextView[@text=\"Nom\"]") : By.xpath("//XCUIElementTypeStaticText[@label=\"Nom\"]");

    public By
            textPreNom = OS.isAndroid() ? By.xpath("//android.widget.TextView[@text=\"Prénom\"]") : By.xpath("//XCUIElementTypeStaticText[@label=\"Prénom\"]");
    public By
            textEmail = OS.isAndroid() ? By.xpath("//android.widget.TextView[@text=\"Email\"]") : By.xpath("//XCUIElementTypeStaticText[@label=\"Email\"]");

    public By
            textAdresse = OS.isAndroid() ? By.xpath("//android.widget.TextView[@text=\"Adresse\"]") : By.xpath("//XCUIElementTypeStaticText[@label=\"Adresse\"]");

    public By
            textFuseauHoraire = OS.isAndroid() ? By.xpath("//android.widget.TextView[@text=\"Fuseau horaire\"]") : By.xpath("//XCUIElementTypeStaticText[@label=\"Fuseau horaire\"]");
    public By
            textCoordonnéesGPS = OS.isAndroid() ? By.xpath("//android.widget.TextView[@text=\"Coordonnées GPS\"]") : By.xpath("//XCUIElementTypeStaticText[@label=\"Coordonnées GPS\"]");

    public By
            placeLabelNom = OS.isAndroid() ? By.xpath("(//android.widget.EditText)[1]") : By.xpath("(//XCUIElementTypeImage[@name=\"editableImageView_UserInfoCell\"])[1]");

    public By
            placeLabelPrenom = OS.isAndroid() ? By.xpath("(//android.widget.EditText)[2]") : By.xpath("(//XCUIElementTypeImage[@name=\"editableImageView_UserInfoCell\"])[2]");

    public By
            placeLabelTelephone = OS.isAndroid() ? By.xpath("(//android.widget.EditText)[3]") : By.xpath("(//XCUIElementTypeImage[@name=\"editableImageView_UserInfoCell\"])[3]");

    public By
            placeLabelEmail = OS.isAndroid() ? By.xpath("(//android.widget.EditText)[4]") : By.xpath("(//XCUIElementTypeImage[@name=\"editableImageView_UserInfoCell\"])[4]");
    public By
            placeLabelAdresse = OS.isAndroid() ? By.xpath("(//android.widget.EditText)[5]") : By.xpath("(//XCUIElementTypeImage[@name=\"editableImageView_UserInfoCell\"])[5]");
    public By
           placeHolderMesInformation = OS.isAndroid() ?  By.id("com.overkiz."+appName+":id/et_email") : By.xpath("(//XCUIElementTypeTextField)[1]");

    public By
            btnOk = OS.isAndroid() ?  By.id("com.overkiz."+appName+":id/tv_ok") : By.id("OK");

    public By
            snackbarText = OS.isAndroid() ?  By.id("com.overkiz."+appName+":id/snackbar_text") : By.id("Votre profil a été mis à jour");

    public By
            placeFuseauHoraire = OS.isAndroid() ? By.xpath("//android.widget.EditText[@text=\"Europe/Paris\"]") : By.xpath("//XCUIElementTypeStaticText[@label=\"Europe/Paris\"]");

    public By
            placeCoordonnées = OS.isAndroid() ? By.xpath("(//android.widget.EditText)[4]") : By.xpath("(//XCUIElementTypeStaticText)[15]");

    public By
          placeLeverDeSoleil = OS.isAndroid() ? By.xpath("(//android.widget.EditText)[5]") : By.xpath("(//XCUIElementTypeStaticText)[17]");

    public By
          placeNuméroParselle = OS.isAndroid() ? By.xpath("//android.widget.EditText[@text=\"2202-5934-6827\"]") : By.xpath("(//XCUIElementTypeStaticText)[19]");

   public By
          btnRetour= OS.isAndroid() ?  By.id("com.overkiz."+appName+":id/ic_back") : By.id("OK");


    public String getAppName(String app){
        if(OS.OS.equals("Android")){
            switch (app){
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
