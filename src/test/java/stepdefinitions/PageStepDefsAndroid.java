package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePageAndroid;
import pages.OverkizPages;
import utils.ConfigReader;
import java.util.List;
import java.util.Random;
import static org.junit.Assert.*;
import static stepdefinitions.Hooks.apkIndex;
import static utils.Driver.getDriver;

public class PageStepDefsAndroid extends BasePageAndroid {

    private static final Logger LOG = LoggerFactory.getLogger(PageStepDefsAndroid.class);
    OverkizPages overkiz = new OverkizPages();
    Actions actions = new Actions(getDriver());
    Faker faker = new Faker();

    Random random = new Random();

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
    public void unMessageDErreurSafficheCorrectement() {
        //overkiz.btnSeConnecter.click();
        String textMessageDerruer = "Le processus d'authentification a échoué à cause d'un problème avec le compte (désactivé, expiré, …)";
        assertTrue(overkiz.invalidSnackbarText.getText().contains(textMessageDerruer));
        System.out.println(overkiz.invalidSnackbarText.getText());

    }

    @Then("si l'utilisateur saisit un mot de passe invalide")
    public void siLUtilisateurSaisitUnMotDePasseInvalide() {
        overkiz.placeHolderMotDePasse.click();
        overkiz.getPlaceHolderMotDePasseText.sendKeys("invalideAdressseEmail");
        overkiz.btnSeConnecter.click();
        String textMessageDerruer = "Le processus d'authentification a échoué à cause d'un problème avec le compte (désactivé, expiré, …)";
        assertTrue(overkiz.invalidSnackbarText.getText().contains(textMessageDerruer));
        System.out.println(overkiz.invalidSnackbarText.getText());
        System.out.println("textMessageDerruer + overkiz.invalidSnackbarText.getText() = " +"actual"+ textMessageDerruer + overkiz.invalidSnackbarText.getText());

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
        assertTrue(overkiz.invalidSnackbarText.getText().contains(textMessageDerruer));
        System.out.println(overkiz.invalidSnackbarText.getText());
    }

    @Given("lutilisateur souhaite vérifier les éléments sur la page d'accueil")
    public void lutilisateurSouhaiteVerifierLesElementsSurLaPageDAccueil() {
    }


    @Then("les éléments de la page d'accueil sont vérifiés conformément aux spécifications")
    public void lesElementsDeLaPageDAccueilSontVerifiesConformementAuxSpecifications() throws InterruptedException {
        overkiz.btnSeConnecter.click();
        Thread.sleep(2000);
        List<WebElement> elementList = getDriver().findElements(By.className("android.widget.TextView"));
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
                Assert.fail("Erreur : Le texte '" + text + "' n'est pas trouvé dans l'élément !");}
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
        overkiz.btnSeConnecter.click();
    }

    @And("l'utilisateur peut vérifier ses informations personnelles")
    public void lUtilisateurPeutVerifierSesInformationsPersonnelles() throws InterruptedException {
        overkiz.btnEnPlus.click();
        overkiz.btnMesInformations.click();
        Thread.sleep(3000);
        List<WebElement> elementList2 = getDriver().findElements(By.className("android.widget.TextView"));
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
                Assert.fail("Erreur : Le texte '" + text + "' n'est pas trouvé dans l'élément !");
            }
        }

        scrollUp(overkiz.placeEmail, -50);

        List<WebElement> elementList3 = getDriver().findElements(By.className("android.widget.TextView"));
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
                Assert.fail("Erreur : Le texte '" + text + "' n'est pas trouvé dans l'élément !");
            }
        }

    }


    @Then("l'utilisateur peut modifier ses informations personnelles")
    public void lUtilisateurPeutModifierSesInformationsPersonnelles() throws InterruptedException {
        Random random = new Random();

        overkiz.btnEnPlus.click();
        overkiz.btnMesInformations.click();
        overkiz.placePrénom.click();
        Thread.sleep(1000);
        overkiz.placeHolderMesInformations.clear();
        overkiz.placeHolderMesInformations.sendKeys(getRandomName());
        overkiz.tvOk.click();
        Thread.sleep(1000);
        //assertTrue(overkiz.snackbarText.getText().contains("Votre profil a été mis à jour"));
        overkiz.placeNom.click();
        Thread.sleep(1000);
        overkiz.placeHolderMesInformations.clear();
        overkiz.placeHolderMesInformations.sendKeys(getRandomName());
        overkiz.tvOk.click();
       // assertTrue(overkiz.snackbarText.getText().contains("Votre profil a été mis à jour"));
        overkiz.placeTéléphone.click();
        Thread.sleep(1000);
        overkiz.placeHolderMesInformations.clear();
        overkiz.placeHolderMesInformations.sendKeys(getRandomPhoneNumber());
        overkiz.tvOk.click();
     //  assertTrue(overkiz.snackbarText.getText().contains("Votre profil a été mis à jour"));
        overkiz.placeAdresse.click();
        overkiz.btnAutoriser.click();
        overkiz.btnModifier.click();
        Thread.sleep(1000);
        overkiz.placeHolderAdresse.clear();
        String adresse = faker.address().fullAddress();
        overkiz.placeHolderAdresse.sendKeys(adresse);
        overkiz.placeHolderCodePostal.clear();
        overkiz.placeHolderCodePostal.sendKeys(getRandomPostalCode());
        overkiz.getTvOk.click();
        Thread.sleep(1000);
     //   assertTrue(overkiz.snackbarText.getText().contains("Votre profil a été mis à jour"));
        overkiz.placeEmail.click();
        Thread.sleep(1000);
        overkiz.placeHolderMesInformations.clear();
        overkiz.placeHolderMesInformations.sendKeys("vfovk5934@yopmail.com");
        overkiz.tvOk.click();
     //   assertTrue(overkiz.snackbarText.getText().contains("Votre profil a été mis à jour"));





    }


    @And("l'utilisateur ne peut pas modifier certaines informations")
    public void lUtilisateurNePeutPasModifierCertainesInformations() {

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
        Thread.sleep(2000);
        //assertTrue(overkiz.textBonjourName.getText().contains("Bonjour"));
    }

    @When("l'utilisateur sélectionne le {string} pour la géolocalisation")
    public void lUtilisateurSélectionneLePourLaGéolocalisation(String textScénarios) {
        assertEquals(overkiz.btnScénarios.getText(), textScénarios);
        System.out.println(overkiz.btnScénarios.getText() + textScénarios);
        overkiz.btnScénarios.click();
        overkiz.Scénarios.click();
    }

    @And("l'utilisateur clique sur Géolocaliser")
    public void lUtilisateurCliqueSurGéolocaliser() {
        overkiz.btnGeolocalisation.click();
        overkiz.btnOk.click();
        overkiz.btnAutoriserToujours.click();
    }

    @Then("trois actions sont possibles : Désactiver, Toujours activer, Activer une fois")
    public void troisActionsSontPossiblesDésactiverToujoursActiverActiverUneFois() {
        assertTrue(overkiz.btnActiverUneFois.isDisplayed()
                && overkiz.btnToujoursActiver.isDisplayed()
                && overkiz.btnDésactiver.isDisplayed());

    }
    @And("l'utilisateur clique sur Toujours activer après avoir ajusté la distance")
    public void lUtilisateurCliqueSurToujoursActiverAprèsAvoirAjustéLaDistance() {
        overkiz.btnToujoursActiver.click();
    }
    @When("l'utilisateur peut choisir une distance entre {int}m And {int}km à laide dun curseur nommé {string}")
    public void lUtilisateurPeutChoisirUneDistanceEntreMAndKmÀLaideDunCurseurNommé(int arg0, int arg1, String expectedText) {
        assertTrue(overkiz.textDistanceDeDomicile.getText().contains(expectedText));
    }

    @Then("l'utilisateur vérifie dans linterface dadministration que la planification est prise en compte dans le menu")
    public void lUtilisateurVérifieDansLinterfaceDadministrationQueLaPlanificationEstPriseEnCompteDansLeMenu() {

        //TODO:faire un test pour vérifier que la planification est prise en compte dans le menu
    }

    @And("l'utilisateur clique de nouveau sur {string}")
    public void lUtilisateurCliqueDeNouveauSur(String expectedText) {
        overkiz.btnRetour.click();
        assertTrue(overkiz.btnGeolocalisation.getText().contains(expectedText));
        overkiz.btnGeolocalisation.click();

    }

    @And("l'utilisateur clique sur Enregistrer")
    public void lUtilisateurCliqueSurEnregistrer() {
        overkiz.btnEnregister.click();

    }

    @When("l'utilisateur clique sur Activer une fois après avoir ajusté la distance")
    public void lUtilisateurCliqueSurActiverUneFoisAprèsAvoirAjustéLaDistance() {
        if(overkiz.btnActiverUneFois.isEnabled()) {overkiz.btnActiverUneFois.click();}

    }

    @When("l'utilisateur clique sur Désactiver")
    public void lUtilisateurCliqueSurDésactiver() {

        if(overkiz.btnDésactiver.isEnabled()) {
            overkiz.btnDésactiver.click();
        }
    }

    @And("utilisateur voit les champs {string} And {string} sur la page d'accueil")
    public void utilisateurVoitLesChampsAndSurLaPageDAccueil(String expectedText1, String expectedText2) {
        String actualTextConnexionTitle = "Connexion";
        assertEquals(overkiz.titleConnexion.getText(), actualTextConnexionTitle);
        assertTrue(overkiz.textEmail.getText().contains(expectedText1)
                && overkiz.textMotDePasse.getText().contains(expectedText2));}



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
    public void lUtilisateurNavigueDansLesPiècesPourChoisirLéquipementÀPiloter() {
    }

    @And("l'utilisateur clique sur cet équipement")
    public void lUtilisateurCliqueSurCetÉquipement() {
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
}



