package stepdefinitions.menu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static utils.Driver.getCurrentDriver;
import com.github.javafaker.Faker;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Random;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.AppOperationManager;
import pages.BasePage;
import pages.menu.MyInformationPage;
import utils.ConfigReader;

public  class MyInformation extends BasePage{
    MyInformationPage overkiz = new MyInformationPage();
    Actions actions = new Actions(getCurrentDriver());
    Faker faker = new Faker();

    Random random = new Random();
    AppOperationManager manager = new AppOperationManager(getCurrentDriver());

    public MyInformation() throws MalformedURLException, InterruptedException {
    }


    

    @Given("lutilisateur souhaite se connecter à l'application")
    public void lutilisateurSouhaiteSeConnecterLApplication() {

        //TODO:
    }

    @When("il accède à l'application Overkiz")
    public void ilAccedeALApplicationOverkiz() {

        cliquerLogoOverKizConnectSixFois(actions, overkiz.logoOverKizConnect);
        assertTrue(overkiz.serverStd.isDisplayed());
        overkiz.editText105.clear();
        overkiz.serverStd.click();
        overkiz.editText.sendKeys("24");
        overkiz.tvOk.click();
    }

    @And("utilisateur voit les champs {string} et {string} sur la page d'accueil")
    public void utilisateurVoitLesChampsEtSurLaPageDAccueil(String expectedText1, String expectedText2) {
        //TODO:
    }

    @Then("l'utilisateur saisit ses informations de connexion")
    public void lUtilisateurSaisitSesInformationsDeConnexion() throws InterruptedException {
        overkiz.placeHolderEmail.sendKeys(ConfigReader.getProperty("adressseEmail"));
        overkiz.placeHolderMotDePasse.click();
        overkiz.getPlaceHolderMotDePasseText.sendKeys(ConfigReader.getProperty("motDePasse"));
    }

    @And("l'utilisateur se connecte à son compte")
    public void lUtilisateurSeConnecteASonCompte() {
        overkiz.btnSeConnecter.click();
        String expectedText = "Bonjour";
        // assertTrue(overkiz.textBonjourName.getText().contains(expectedText));


    }

    @And("l'utilisateur saisit son adresse e-mail valide")
    public void lUtilisateurSaisitSonAdresseEMailValide() {
        overkiz.placeHolderEmail.sendKeys(ConfigReader.getProperty("adressseEmail"));
    }

    @Then("si l'utilisateur saisit une adresse e-mail invalide")
    public void siLUtilisateurSaisitUneAdresseEMailInvalide() {
        overkiz.placeHolderMotDePasse.click();
        overkiz.getPlaceHolderMotDePasseText.sendKeys(ConfigReader.getProperty("invalideMotDePasse"));
    }

    @And("un message d'erreur saffiche correctement")
    public void unMessageDErreurSafficheCorrectement() throws InterruptedException {

        overkiz.btnSeConnecter.click();


        String textMessageDerruer = "Le processus d'authentification a échoué à cause d'un problème avec le compte (désactivé, expiré, …)";
        wait(2);

        assertTrue(overkiz.invalidSnackbarText.getText().contains(textMessageDerruer));


    }

    @Then("si l'utilisateur saisit un mot de passe invalide")
    public void siLUtilisateurSaisitUnMotDePasseInvalide() {
        overkiz.placeHolderMotDePasse.click();
        overkiz.getPlaceHolderMotDePasseText.sendKeys("invalideAdressseEmail");
        overkiz.btnSeConnecter.click();
        String textMessageDerruer = "Le processus d'authentification a échoué à cause d'un problème avec le compte (désactivé, expiré, …)";
        assert manager.verifyElementText("snackbar_text", textMessageDerruer);
    }

    @And("l'utilisateur laisse le champ dadresse e-mail vide")
    public void lUtilisateurLaisseLeChampDadresseEMailVide() {
        overkiz.placeHolderMotDePasse.click();
        overkiz.getPlaceHolderMotDePasseText.sendKeys("");

    }

    @Then("l'utilisateur laisse le champ du mot de passe vide")
    public void lUtilisateurLaisseLeChampDuMotDePasseVide() {
        overkiz.placeHolderEmail.sendKeys("");
        overkiz.btnSeConnecter.click();
        String textMessageDerruer = "Le processus d'authentification a échoué à cause d'un problème avec le compte (désactivé, expiré, …)";
        assert manager.verifyElementText("snackbar_text", textMessageDerruer);
    }

    @Given("lutilisateur souhaite vérifier les éléments sur la page d'accueil")
    public void lutilisateurSouhaiteVerifierLesElementsSurLaPageDAccueil() {
    }


    @Then("les éléments de la page d'accueil sont vérifiés conformément aux spécifications")
    public void lesElementsDeLaPageDAccueilSontVerifiesConformementAuxSpecifications() throws InterruptedException, MalformedURLException {
        overkiz.btnSeConnecter.click();
        wait(2);
        List<WebElement> elementList = getCurrentDriver().findElements(By.className("android.widget.TextView"));
        // Parcourons la liste pour valider les textes
        String[] textsToVerify = {
                "Android vide",
                "ios vide",
                "Accueil",
                "Scénarios",
                "En plus",
                "Conso",
                "OXIMO io",
                "RS100 io",
                "BL_Actuator",
                "Zone 1",
                "Mes Favoris"};

        for (String text : textsToVerify) {
            boolean isTextFound = false;
            for (WebElement element : elementList) {
                String elementText = element.getText();
                if (elementText.contains(text)) {
                    System.out.println(text + " Le text visible.");
                    isTextFound = true;
                    break;
                }
            }
            if (!isTextFound) {
                System.out.println(text + " Le text non visible.");
                fail("Erreur : Le texte '" + text + "' n'est pas trouvé dans l'élément !");
            }
        }
    }

    @Given("l'utilisateur souhaite vérifier ses informations personnelles")
    public void lUtilisateurSouhaiteVerifierSesInformationsPersonnelles() {
        //TODO:Aller à la page d'accueil
    }

    @When("il accède à l'application Overkiz pour accéder à son profil")
    public void ilAccedeALApplicationOverkizPourAccederASonProfil() {
      wait(3);

        overkiz.clickBtnEnPlus();

        wait(3);
    }


    @Given("l'utilisateur souhaite modifier ses informations personnelles")
    public void lUtilisateurSouhaiteModifierSesInformationsPersonnelles() {
        //TODO:Aller à la page d'accueil

    }

    @When("il accède à l'application Overkiz avec ses informations de connexion")
    public void ilAccedeALApplicationOverkizAvecSesInformationsDeConnexion() {

    }

 




    @When("l'utilisateur navigue dans les pièces pour choisir léquipement à piloter")
    public WebElement lUtilisateurNavigueDansLesPiècesPourChoisirLéquipementÀPiloter() {
        WebElement[] elements = {overkiz.btnOXIMOio, overkiz.btnRS100io};
        // Generate a random index
        Random random = new Random();
        int randomIndex = random.nextInt(elements.length);
        // Get the random element
        WebElement randomElement = elements[randomIndex];
        // Click on the random element
        actions.moveToElement(randomElement).click().perform();
        return randomElement;
    }


    @Then("l'utilisateur devrait être redirigé vers lécran dexploitation")
    public void lUtilisateurDevraitÊtreRedirigéVersLécranDexploitation() {


    }

    @And("l'utilisateur devrait voir le nom de léquipement")
    public void lUtilisateurDevraitVoirLeNomDeLéquipement() {
    }

    @And("l'utilisateur devrait voir les boutons")
    public void lUtilisateurDevraitVoirLesBoutons() {
    }

    @And("l'utilisateur devrait voir licône de léquipement")
    public void lUtilisateurDevraitVoirLicôneDeLéquipement() {
    }

    @And("l'utilisateur devrait voir létoile permettant de placer léquipement en favori")
    public void lUtilisateurDevraitVoirLétoilePermettantDePlacerLéquipementEnFavori() {
    }



    @When("l'utilisateur lit les informations du capteur")
    public void lUtilisateurLitLesInformationsDuCapteur() {
    }

    @Then("l'utilisateur devrait voir les informations du capteur")
    public void lUtilisateurDevraitVoirLesInformationsDuCapteur() {
    }

    @When("Je sélectionne {string} puis {string}")
    public void jeSelectionnePuis(String textExpected1, String textExpected2) throws MalformedURLException, InterruptedException {
        getCurrentDriver().findElement(overkiz.btnEnplus).click();
        wait(1);
        scrollUp(overkiz.btnNotification, -40);
        manager.clickOnElement("tv_log_out");


    }

    @Then("On est sur la page de connexion de l’application")
    public void onEstSurLaPageDeConnexionDeLApplication() {
        System.out.println();
    }

    @And("Je choisis un serveur parmi:")
    public void jeChoisisUnServeurParmi() {
        System.out.println();

    }

    @And("Je renseigne le numéro du serveur dans le champ dédié")
    public void jeRenseigneLeNumeroDuServeurDansLeChampDedie() {
        System.out.println();
    }


    @Then("L’application pointe sur le serveur sélectionné")
    public void lApplicationPointeSurLeServeurSelectionne() {
        System.out.println();
    }

    @And("L'écran de connexion est de nouveau visible")
    public void lEcranDeConnexionEstDeNouveauVisible() {
        System.out.println();
    }


    @Then("l'utilisateur peut vérifier ses informations personnelles")
    public void lUtilisateurPeutVerifierSesInformationsPersonnelles() {
    }
}

