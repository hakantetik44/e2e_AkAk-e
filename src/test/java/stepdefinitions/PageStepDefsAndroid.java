package stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static utils.Driver.getCurrentDriver;

import com.github.javafaker.Faker;
import com.somfy.ui.BaseElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.AppOperationManager;
import pages.BasePage;
import pages.OverkizPages;
import utils.ConfigReader;


public class PageStepDefsAndroid extends BasePage {

    OverkizPages overkiz = new OverkizPages();
    Actions actions = new Actions(getCurrentDriver());
    Faker faker = new Faker();

    Random random = new Random();
    AppOperationManager manager = new AppOperationManager(getCurrentDriver());

    public PageStepDefsAndroid() throws MalformedURLException, InterruptedException {
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
        //TODO:
    }


    @Given("l'utilisateur souhaite modifier ses informations personnelles")
    public void lUtilisateurSouhaiteModifierSesInformationsPersonnelles() {
    }

    @When("il accède à l'application Overkiz avec ses informations de connexion")
    public void ilAccedeALApplicationOverkizAvecSesInformationsDeConnexion() {
        cliquerLogoOverKizConnectSixFois(actions, overkiz.logoOverKizConnect);
        assertTrue(overkiz.serverStd.isDisplayed());
        overkiz.editText105.clear();
        overkiz.serverStd.click();
        overkiz.editText.sendKeys("24");
        overkiz.tvOk.click();
        overkiz.placeHolderEmail.sendKeys(ConfigReader.getProperty("adressseEmail"));
        overkiz.placeHolderMotDePasse.click();
        overkiz.getPlaceHolderMotDePasseText.sendKeys(ConfigReader.getProperty("motDePasse"));
        manager.clickOnElement("tv_login");
    }

    @And("l'utilisateur peut vérifier ses informations personnelles")
    public void lUtilisateurPeutVerifierSesInformationsPersonnelles() throws InterruptedException, MalformedURLException {
        overkiz.btnEnPlus.click();
        overkiz.btnMesInformations.click();
        wait(2);
        List<WebElement> elementList2 = getCurrentDriver().findElements(By.className("android.widget.TextView"));
        String[] textsToVerify2 = {
                "Prénom",
                "Nom",
                "Téléphone",
                "Email",
                "Adresse",
                "Fuseau horaire",
        };

        for (String text : textsToVerify2) {
            boolean isTextFound = false;
            for (WebElement element : elementList2) {
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

        scrollUp(overkiz.placeEmail, -50);

        List<WebElement> elementList3 = getCurrentDriver().findElements(By.className("android.widget.TextView"));
        String[] textsToVerify3 = {
                "Coordonnées GPS",
                "Lever de soleil / Coucher de soleil",
                "Numéro de passerelle",
                "Serveur de connexion"
        };

        for (String text : textsToVerify3) {
            boolean isTextFound = false;
            for (WebElement element : elementList3) {
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


    BaseElement<?, ?> buttonNavMore = new BaseElement<>(
        getCurrentDriver(),
        getCurrentDriver(),
        overkiz.buttonNavMore
    );

    @Then("l'utilisateur peut modifier ses informations personnelles")
    public void lUtilisateurPeutModifierSesInformationsPersonnelles() throws InterruptedException {

        wait(1);
        //manager.clickOnElement("nav_more");
        buttonNavMore.click();
        wait(1);
        manager.clickOnElement("label_google_assistant");
        manager.clickOnElement("edit_text");
        wait(1);
        manager.clearElement("et_email");
        overkiz.placeHolderMesInformations.sendKeys(getRandomName());
        manager.clickOnElement("tv_ok");
        wait(1);
        // assertTrue(overkiz.snackbarText.getText().contains("Votre profil a été mis à jour"));
        overkiz.placeNom.click();
        wait(1);
        overkiz.placeHolderMesInformations.clear();
        overkiz.placeHolderMesInformations.sendKeys(getRandomName());
        manager.clickOnElement("tv_ok");
        wait(1);
        // assertTrue(overkiz.snackbarText.getText().contains("Votre profil a été mis à jour"));
        overkiz.placeTéléphone.click();
        wait(1);
        manager.clickOnElement("et_email");
        manager.clearElement("et_email");
        overkiz.placeHolderMesInformations.sendKeys(getRandomPhoneNumber());
        manager.clickOnElement("tv_ok");
        wait(1);
        //  assertTrue(overkiz.snackbarText.getText().contains("Votre profil a été mis à jour"));
        overkiz.placeAdresse.click();
        wait(1);
        overkiz.btnAutoriser.click();
        wait(1);
        overkiz.btnModifier.click();
        wait(1);
        manager.clearElement("edit_text_address");
        String adresse = faker.address().fullAddress();
        manager.sendKeysToElement("edit_text_address",adresse);

       manager.clearElement("edit_text_code_postal");
        manager.sendKeysToElement("edit_text_code_postal",getRandomPostalCode());
        manager.clickOnElement("tv_ok");
        wait(1);
        //   assertTrue(overkiz.snackbarText.getText().contains("Votre profil a été mis à jour"));
        overkiz.placeEmail.click();
        wait(1);
        overkiz.placeHolderMesInformations.clear();
        overkiz.placeHolderMesInformations.sendKeys("vfovk5934@yopmail.com");
        overkiz.tvOk.click();
        //   assertTrue(overkiz.snackbarText.getText().contains("Votre profil a été mis à jour"));


    }


    @And("l'utilisateur ne peut pas modifier certaines informations")
    public void lUtilisateurNePeutPasModifierCertainesInformations() throws MalformedURLException, InterruptedException {

        assertFalse(overkiz.placeFuseauHoraire.isEnabled());
        scrollUp(overkiz.placeEmail, -50);
        assertFalse(overkiz.placeCoordonnées.isEnabled());
        assertFalse(overkiz.placeLeverDeSoleil.isEnabled());
        assertFalse(overkiz.placeNuméroParselle.isEnabled());
        assertFalse(overkiz.placeServeurDeConnexion.isEnabled());

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

    @When("l'utilisateur sélectionne le {string} pour la géolocalisation")
    public void lUtilisateurSélectionneLePourLaGéolocalisation(String textScénarios) {
        assertEquals(overkiz.btnScénarios.getText(), textScénarios);
        System.out.println(overkiz.btnScénarios.getText() + textScénarios);
        overkiz.btnScénarios.click();
        manager.clickOnElement("name");

    }

    @And("l'utilisateur clique sur Géolocaliser")
    public void lUtilisateurCliqueSurGéolocaliser() {
        manager.clickOnElement("tv_geolocalisation");
        overkiz.btnOk.click();
        overkiz.btnAutoriserToujours.click();
    }

    @Then("trois actions sont possibles : Désactiver, Toujours activer, Activer une fois")
    public void troisActionsSontPossiblesDésactiverToujoursActiverActiverUneFois() {
        assertTrue(manager.verifyElementText("tv_deactivate","Désactiver"));
        assertTrue(manager.verifyElementText("tv_activate_always","Toujours activer"));
        assertTrue(manager.verifyElementText("tv_activate_once","Activer une fois"));

    }

    @And("l'utilisateur clique sur Toujours activer après avoir ajusté la distance")
    public void lUtilisateurCliqueSurToujoursActiverAprèsAvoirAjustéLaDistance() {
        manager.clickOnElement("Toujours activer");
    }

    @When("l'utilisateur peut choisir une distance entre {int}m And {int}km à laide dun curseur nommé {string}")
    public void lUtilisateurPeutChoisirUneDistanceEntreMAndKmÀLaideDunCurseurNommé(int arg0, int arg1, String expectedText) {
        assertTrue(manager.verifyElementText("label_distance",expectedText));
    }

    @Then("l'utilisateur vérifie dans linterface dadministration que la planification est prise en compte dans le menu")
    public void lUtilisateurVérifieDansLinterfaceDadministrationQueLaPlanificationEstPriseEnCompteDansLeMenu() {

        //TODO:faire un test pour vérifier que la planification est prise en compte dans le menu
    }

    @And("l'utilisateur clique de nouveau sur {string}")
    public void lUtilisateurCliqueDeNouveauSur(String expectedText) {
        manager.clickOnElement("im_back");
        assertTrue(manager.verifyElementText("tv_geolocalisation",expectedText));
        manager.clickOnElement("tv_geolocalisation");

    }

    @And("l'utilisateur clique sur Enregistrer")
    public void lUtilisateurCliqueSurEnregistrer() {
        manager.clickOnElement("tv_enregister");

    }

    @When("l'utilisateur clique sur Activer une fois après avoir ajusté la distance")
    public void lUtilisateurCliqueSurActiverUneFoisAprèsAvoirAjustéLaDistance() {
       manager.clickOnElement("tv_activate_once");

    }

    @When("l'utilisateur clique sur Désactiver")
    public void lUtilisateurCliqueSurDésactiver() {

       manager.clickOnElement("tv_deactivate");
    }

    @And("utilisateur voit les champs {string} And {string} sur la page d'accueil")
    public void utilisateurVoitLesChampsAndSurLaPageDAccueil(String expectedText1, String expectedText2) {
        String actualTextConnexionTitle = "Connexion";
        assertEquals(overkiz.titleConnexion.getText(), actualTextConnexionTitle);
        assertTrue(overkiz.textEmail.getText().contains(expectedText1)
                && overkiz.textMotDePasse.getText().contains(expectedText2));
    }


    @When("l'utilisateur clique sur {string} dans longlet {string}")
    public void lUtilisateurCliqueSurDansLonglet(String textGérerMesAccés, String textEnPlus) {
        overkiz.btnEnPlus.click();
        overkiz.btnGérerMesAccèsSecondaires.click();

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

    @When("l'utilisateur clique sur {string}")
    public void lUtilisateurCliqueSur(String arg0) {
    }

    @Then("l'équipement devrait être ouvert")
    public void lÉquipementDevraitÊtreOuvert() {
    }

    @Then("l'équipement devrait être fermé")
    public void lÉquipementDevraitÊtreFermé() {
    }

    @Then("l'équipement devrait sarrêter")
    public void lÉquipementDevraitSarrêter() {
    }

    @Then("l'équipement devrait être allumé")
    public void lÉquipementDevraitÊtreAllumé() {
    }

    @Then("l'équipement devrait être éteint")
    public void lÉquipementDevraitÊtreÉteint() {
    }

    @When("l'utilisateur lit les informations du capteur")
    public void lUtilisateurLitLesInformationsDuCapteur() {
    }

    @Then("l'utilisateur devrait voir les informations du capteur")
    public void lUtilisateurDevraitVoirLesInformationsDuCapteur() {
    }

    @When("Je sélectionne {string} puis {string}")
    public void jeSelectionnePuis(String textExpected1, String textExpected2) throws MalformedURLException, InterruptedException {

        overkiz.btnEnPlus.click();
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

    @And("Je clique sur {string}")
    public void jeCliqueSur(String arg0) {
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



