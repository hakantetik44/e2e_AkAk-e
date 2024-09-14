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

import static utils.Driver.getCurrentDriver;

public class MyInformationPage {

    public String appName = getAppName(Hooks.apk);

    public MyInformationPage() throws MalformedURLException, InterruptedException {

        PageFactory.initElements(new AppiumFieldDecorator(getCurrentDriver()), this);

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

    public void clickBtnEnPlus() {
        By btnEnplus = OS.isAndroid() ? By.id("comid/nav_more") : By.id("En plus");
        getCurrentDriver().findElement(btnEnplus).click();
    }




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
