package stepdefinitions.menu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import static utils.Driver.getCurrentDriver;
import com.github.javafaker.Faker;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Random;

import com.somfy.ui.BaseElement;
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

    BaseElement<?, ?> btnEnplus = new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.btnEnplus

    );



    BaseElement<?, ?> btnMesInfo = new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.btnMesInfo

    );

    BaseElement<?, ?> listText = new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.listText

    );


    BaseElement<?, ?> textNom = new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.textNom

    );

    BaseElement<?, ?> textPrenom = new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.textPreNom

    );

    BaseElement<?, ?> placeFuseauHoraire = new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.placeFuseauHoraire

    );


    BaseElement<?, ?> placeLabelTelephone = new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.placeLabelTelephone
    );


    BaseElement<?, ?> placeLabelAdresse = new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.placeLabelAdresse
    );

    BaseElement<?, ?> textEmail = new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.textEmail

    );

    BaseElement<?, ?> placeLabelNom = new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.placeLabelNom

    );

    BaseElement<?, ?> placeLabelPrenom = new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.placeLabelPrenom

    );




    BaseElement<?, ?> placeEmail = new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.placeEmail

    );

    BaseElement<?, ?> textAdresse = new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.textAdresse

    );

    BaseElement<?, ?> textFuseauHoraire = new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.textFuseauHoraire

    );


    BaseElement<?, ?> textCoordonnéesGPS  = new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.textCoordonnéesGPS

    );


    BaseElement<?, ?> placeHolderMesInformation  = new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.placeHolderMesInformation

    );



    BaseElement<?, ?> btnOk = new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.btnOk

    );


    BaseElement<?, ?> placeLabelEmail = new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.placeLabelEmail

    );

    BaseElement<?, ?> snackbarText= new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.snackbarText

    );

    BaseElement<?, ?> placeCoordonnées= new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.placeCoordonnées

    );


    BaseElement<?, ?> placeNuméroParselle= new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.placeNuméroParselle

    );



    BaseElement<?, ?> btnRetour= new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.btnRetour

    );

    BaseElement<?, ?> placeLeverDeSoleil= new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.placeLeverDeSoleil

    );




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

        btnEnplus.click();
        btnMesInfo.click();
    }


    @Given("l'utilisateur souhaite modifier ses informations personnelles")
    public void lUtilisateurSouhaiteModifierSesInformationsPersonnelles() {
        //TODO:Aller à la page d'accueil

    }

    @When("il accède à l'application Overkiz avec ses informations de connexion")
    public void ilAccedeALApplicationOverkizAvecSesInformationsDeConnexion() {

    }

    @And("l'utilisateur peut vérifier ses informations personnelles")
    public void lUtilisateurPeutVerifierSesInformationsPersonnelles() throws InterruptedException, MalformedURLException {
        assertTrue(textPrenom.getText().contains("Prénom"));
        assertTrue(textNom.getText().contains("Nom"));
        assertTrue(textEmail.getText().contains("Email"));
        assertTrue(textAdresse.getText().contains("Adresse"));
        scrollUp(placeEmail.waitVisible(), -50);
        assertTrue(textFuseauHoraire.getText().equalsIgnoreCase("Fuseau Horaire"));
        assertTrue(textCoordonnéesGPS.getText().contains("Coordonnées GPS"));

    }


    @Then("l'utilisateur peut modifier ses informations personnelles")
    public void lUtilisateurPeutModifierSesInformationsPersonnelles() throws InterruptedException {

        placeLabelNom.click();
        placeHolderMesInformation.waitVisible().clear();
        String fakeName = faker.name().fullName();
        placeHolderMesInformation.sendKeys(fakeName);
        btnOk.click();
        assertTrue(snackbarText.getText().contains("Votre profil a été mis à jour"));
        placeLabelPrenom.click();
        placeHolderMesInformation.waitVisible().clear();
        String fakeSurname = faker.name().lastName();
        placeHolderMesInformation.sendKeys(fakeSurname);
        btnOk.click();
        assertTrue(snackbarText.getText().contains("Votre profil a été mis à jour"));
        placeLabelTelephone.click();
        placeHolderMesInformation.waitVisible().clear();
        placeHolderMesInformation.sendKeys(getRandomPhoneNumber());
        btnOk.click();
        placeLabelEmail.click();
        placeHolderMesInformation.waitVisible().clear();
        placeHolderMesInformation.sendKeys("vfovk5934@yopmail.com");
        btnOk.click();
        assertTrue(snackbarText.getText().contains("Votre profil a été mis à jour"));

        /* placeLabelAdresse.click();
        placeHolderMesInformation.waitVisible().clear();
        String fakeAddress = faker.address().fullAddress();
        placeHolderMesInformation.sendKeys(fakeAddress);
        btnOk.click();*/

       //TODO:


    }


    @Then("l'utilisateur ne peut pas modifier certaines informations")
    public void lUtilisateurNePeutPasModifierCertainesInformations() throws MalformedURLException, InterruptedException {

        assertTrue(placeFuseauHoraire.waitVisible().isDisplayed());
        scrollUp(placeEmail.waitVisible(), -50);
        assertTrue(placeCoordonnées.waitVisible().isDisplayed());
        assertTrue(placeNuméroParselle.waitVisible().isDisplayed());
        assertTrue(placeLeverDeSoleil.waitVisible().isDisplayed());

    }

    @Given("l'utilisateur est sur lécran daccueil")
    public void lUtilisateurEstSurLécranDaccueil() throws InterruptedException {
        cliquerLogoOverKizConnectSixFois(actions, overkiz.logoOverKizConnect);
        assertTrue(overkiz.serverStd.isDisplayed());
        overkiz.editText105.clear();
        overkiz.serverStd.click();
        overkiz.editText.sendKeys("24");
        overkiz.tvOk.click();
        overkiz.placeHolderEmail.sendKeys(ConfigReader.getProperty("adressseEmail"));
        overkiz.placeHolderMotDePasse.click();
        overkiz.getPlaceHolderMotDePasseText.sendKeys(ConfigReader.getProperty("motDePasse"));
        overkiz.btnSeConnecter.click();
        wait(2);
        // assertTrue(overkiz.textBonjourName.getText().contains("Bonjour"));
    }


    @And("utilisateur voit les champs {string} And {string} sur la page d'accueil")
    public void utilisateurVoitLesChampsAndSurLaPageDAccueil(String expectedText1, String expectedText2) {
        String actualTextConnexionTitle = "Connexion";
        assertEquals(overkiz.titleConnexion.getText(), actualTextConnexionTitle);
        assertTrue(textEmail.getText().contains(expectedText1)
                && overkiz.textMotDePasse.getText().contains(expectedText2));
    }


    @When("l'utilisateur clique sur {string} dans longlet {string}")
    public void lUtilisateurCliqueSurDansLonglet(String textGérerMesAccés, String textEnPlus) {


    }

    @And("il saisi l'adresse e-mail et le mot de passe du compte secondaire")
    public void ilSaisiLAdresseEMailEtLeMotDePasseDuCompteSecondaire() {
        String email = faker.internet().emailAddress();
        overkiz.placeHolderLogin.sendKeys(email);
        overkiz.placeComteSecondaireMDP.sendKeys(ConfigReader.getProperty("motDePasse"));
        overkiz.placeComteSecondaiConfirmerMDP.sendKeys(ConfigReader.getProperty("motDePasse"));


    }


    @And("il clique sur le bouton {string} en bas")
    public void ilCliqueSurLeBoutonEnBas(String textCréer) {
        assertTrue(overkiz.btnCréer.getText().contains(textCréer));
        overkiz.btnCréer.click();


    }

    @Then("l'accès secondaire est créé")
    public void lAccèsSecondaireEstCréé() {

    }

    @And("un écran récapitulatif des comptes secondaires existants apparaît")
    public void unÉcranRécapitulatifDesComptesSecondairesExistantsApparaît() {

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
        btnEnplus.click();
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



}

