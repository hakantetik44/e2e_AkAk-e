package stepdefinitions;

import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Et;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Étantdonnéque;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePageAndroid;
import pages.OverkizPages;
import utils.ConfigReader;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;
import static utils.DriverMobile.getDriver;

public class PageStepDefsAndroid extends BasePageAndroid {

    private static final Logger LOG = LoggerFactory.getLogger(PageStepDefsAndroid.class);
    OverkizPages overkiz = new OverkizPages();
    Actions actions = new Actions(getDriver());

    Random random = new Random();

    @Étantdonnéque("lutilisateur souhaite se connecter à l'application")
    public void lutilisateurSouhaiteSeConnecterLApplication() {
        //TODO:
    }
    @Quand("il accède à l'application Overkiz")
    public void ilAccedeALApplicationOverkiz(){
        cliquerLogoOverKizConnectSixFois(actions, overkiz.logoOverKizConnect);
        assertTrue(overkiz.serverStd.isDisplayed());
        overkiz.editText105.clear();
        overkiz.serverStd.click();
        overkiz.editText.sendKeys("24");
        overkiz.tvOk.click();}
    @Et("utilisateur voit les champs {string} et {string} sur la page d'accueil")
    public void utilisateurVoitLesChampsEtSurLaPageDAccueil(String expectedText1, String expectedText2) {
        String actualTextConnexionTitle = "Connexion";
        assertEquals(overkiz.titleConnexion.getText(), actualTextConnexionTitle);
        assertTrue(overkiz.textEmail.getText().contains(expectedText1)
                && overkiz.textMotDePasse.getText().contains(expectedText2));}
    @Alors("l'utilisateur saisit ses informations de connexion")
    public void lUtilisateurSaisitSesInformationsDeConnexion() throws InterruptedException {
        overkiz.placeHolderEmail.sendKeys(ConfigReader.getProperty("adressseEmail"));
        overkiz.placeHolderMotDePasse.click();
        overkiz.getPlaceHolderMotDePasseText.sendKeys(ConfigReader.getProperty("motDePasse"));
    }
    @Et("l'utilisateur se connecte à son compte")
    public void lUtilisateurSeConnecteASonCompte() {
        overkiz.btnSeConnecter.click();
        String expectedText = "Bonjour";
        assertTrue(overkiz.textBonjourName.getText().contains(expectedText));

    }
    @Et("l'utilisateur saisit son adresse e-mail valide")
    public void lUtilisateurSaisitSonAdresseEMailValide() {
        overkiz.placeHolderEmail.sendKeys(ConfigReader.getProperty("adressseEmail"));
    }
    @Alors("si l'utilisateur saisit une adresse e-mail invalide")
    public void siLUtilisateurSaisitUneAdresseEMailInvalide() {
        overkiz.placeHolderMotDePasse.click();
        overkiz.getPlaceHolderMotDePasseText.sendKeys(ConfigReader.getProperty("invalideMotDePasse"));
    }
    @Et("un message d'erreur saffiche correctement")
    public void unMessageDErreurSafficheCorrectement() {
        overkiz.btnSeConnecter.click();
        String textMessageDerruer="Le processus d'authentification a échoué à cause d'un problème avec le compte (désactivé, expiré, …)";
        assertTrue(overkiz.invalidSnackbarText.getText().contains(textMessageDerruer));
        System.out.println(overkiz.invalidSnackbarText.getText());

    }
    @Alors("si l'utilisateur saisit un mot de passe invalide")
    public void siLUtilisateurSaisitUnMotDePasseInvalide() {
        overkiz.placeHolderEmail.sendKeys(ConfigReader.getProperty("invalideAdressseEmail"));
        overkiz.btnSeConnecter.click();
        String textMessageDerruer="Le processus d'authentification a échoué à cause d'un problème avec le compte (désactivé, expiré, …)";
        assertTrue(overkiz.invalidSnackbarText.getText().contains(textMessageDerruer));
        System.out.println(overkiz.invalidSnackbarText.getText());

    }
    @Et("l'utilisateur laisse le champ dadresse e-mail vide")
    public void lUtilisateurLaisseLeChampDadresseEMailVide() {
        overkiz.placeHolderMotDePasse.click();
        overkiz.getPlaceHolderMotDePasseText.sendKeys("");

    }
    @Alors("l'utilisateur laisse le champ du mot de passe vide")
    public void lUtilisateurLaisseLeChampDuMotDePasseVide() {
        overkiz.placeHolderEmail.sendKeys("");
        overkiz.btnSeConnecter.click();
        String textMessageDerruer="Le processus d'authentification a échoué à cause d'un problème avec le compte (désactivé, expiré, …)";
        assertTrue(overkiz.invalidSnackbarText.getText().contains(textMessageDerruer));
        System.out.println(overkiz.invalidSnackbarText.getText());
    }
    @Étantdonnéque("lutilisateur souhaite vérifier les éléments sur la page d'accueil")
    public void lutilisateurSouhaiteVerifierLesElementsSurLaPageDAccueil() {
    }



    @Alors("les éléments de la page d'accueil sont vérifiés conformément aux spécifications")
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

                Assert.fail("Erreur : Le texte '" + text + "' n'est pas trouvé dans l'élément !");

            }
        }}
    @Étantdonnéque("l'utilisateur souhaite vérifier ses informations personnelles")
    public void lUtilisateurSouhaiteVerifierSesInformationsPersonnelles() {
        //TODO:
    }


    @Étantdonnéque("l'utilisateur souhaite modifier ses informations personnelles")
    public void lUtilisateurSouhaiteModifierSesInformationsPersonnelles() {
    }

    @Quand("il accède à l'application Overkiz avec ses informations de connexion")
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

    @Et("l'utilisateur peut vérifier ses informations personnelles")
    public void lUtilisateurPeutVerifierSesInformationsPersonnelles() throws InterruptedException {
        overkiz.btnEnPlus.click();
        overkiz.btnMesInformations.click();
        Thread.sleep(3000);
        List<WebElement> elementList2 = getDriver().findElements(By.className("android.widget.TextView"));
        String[] textsToVerify2= {
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

        scrollUp(overkiz.placeEmail,-50);

        List<WebElement> elementList3 = getDriver().findElements(By.className("android.widget.TextView"));
        String[] textsToVerify3= {
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




    @Alors("l'utilisateur peut modifier ses informations personnelles")
    public void lUtilisateurPeutModifierSesInformationsPersonnelles() throws InterruptedException {
        Random random = new Random();

        overkiz.btnEnPlus.click();
        overkiz.btnMesInformations.click();
        overkiz.placePrénom.click();
        Thread.sleep(1000);
        overkiz.placeHolderMesInformations.clear();
        overkiz.placeHolderMesInformations.sendKeys(getRandomName());
        overkiz.tvOk.click();
        assertTrue(overkiz.snackbarText.getText().contains("Votre profil a été mis à jour"));
        overkiz.placeNom.click();
        Thread.sleep(1000);
        overkiz.placeHolderMesInformations.clear();
        overkiz.placeHolderMesInformations.sendKeys(getRandomName());
        overkiz.tvOk.click();
        assertTrue(overkiz.snackbarText.getText().contains("Votre profil a été mis à jour"));
        overkiz.placeTéléphone.click();
        Thread.sleep(1000);
        overkiz.placeHolderMesInformations.clear();
        overkiz.placeHolderMesInformations.sendKeys(getRandomPhoneNumber());
        overkiz.tvOk.click();
        assertTrue(overkiz.snackbarText.getText().contains("Votre profil a été mis à jour"));
        overkiz.placeAdresse .click();
        overkiz.btnAutoriser.click();
        overkiz.btnModifier.click();
        Thread.sleep(1000);
        overkiz.placeHolderAdresse.clear();
        overkiz.placeHolderAdresse.sendKeys(getRandomAddress());
        overkiz.placeHolderCodePostal.clear();
        overkiz.placeHolderCodePostal.sendKeys(getRandomPostalCode());
        overkiz.tvOk.click();
        assertTrue(overkiz.snackbarText.getText().contains("Votre profil a été mis à jour"));
        overkiz.placeEmail.click();
        Thread.sleep(1000);
        overkiz.placeHolderMesInformations.clear();
        overkiz.placeHolderMesInformations.sendKeys("vfovk5934@yopmail.com");
        overkiz.tvOk.click();
        assertTrue(overkiz.snackbarText.getText().contains("Votre profil a été mis à jour"));





        String nouveauNom = overkiz.placePrénom.getText();
        if (nouveauNom.equals("Tom")) {
            System.out.println("L'enregistrement a été effectué avec succès. Le nom Tom est visible.");
        } else {
            System.out.println("L'enregistrement a échoué ou le nom Tom n'est pas visible.");
        }



    }


    @Et("l'utilisateur ne peut pas modifier certaines informations.")
    public void lUtilisateurNePeutPasModifierCertainesInformations() {
        scrollUp(overkiz.placeEmail,-50);
        assertFalse(overkiz.placeFuseauHoraire.isEnabled());
        assertFalse(overkiz.placeCoordonnées.isEnabled());
        assertFalse(overkiz.placeLeverDeSoleil.isEnabled());
        assertFalse(overkiz.placeNuméroParselle.isEnabled());
        assertFalse(overkiz.placeServeurDeConnexion.isEnabled());

    }
}



