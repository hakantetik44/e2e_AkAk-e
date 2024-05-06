package stepdefinitions.scenarios;

import com.github.javafaker.Faker;
import com.somfy.ui.BaseElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.BasePage;
import pages.scenarios.MyScenariosPage;
import utils.ConfigReader;
import java.net.MalformedURLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utils.Driver.getCurrentDriver;

public class MyScenarios extends BasePage {
    MyScenariosPage overkiz = new MyScenariosPage();

    public MyScenarios() throws MalformedURLException, InterruptedException {
    }
    Actions actions = new Actions(getCurrentDriver());
    Faker faker = new Faker();

    BaseElement<?, ?> btnLogement= new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.btnLogement

    );

    BaseElement<?, ?> titleMesScenarios = new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.titleMesScenarios

    );

    BaseElement<?, ?> btnOuvrir= new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.btnOuvrir

    );

    BaseElement<?, ?> btnFermer= new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.btnFermer

    );

    BaseElement<?, ?> btnCréerUnScénario= new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.btnCréerUnScénario

    );

    BaseElement<?, ?> btnNommezScénario= new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.btnNommezScénario

    );

    BaseElement<?, ?> iconeScénario= new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.iconeScénario

    );




    BaseElement<?, ?> snackbarText = new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.snackbarText

    );


    BaseElement<?, ?> btnValider = new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.btnValider

    );


    BaseElement<?, ?> btnRetour = new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.btnRetour

    );

    BaseElement<?, ?> btnSupprimer = new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.btnSupprimer

    );

    BaseElement<?, ?> btnEnregister = new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.btnEnregister

    );



    BaseElement<?, ?> progressBarr= new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.progressBarr
    );


    BaseElement<?, ?> btnAutoriserToujours = new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.btnAutoriserToujours

    );

    BaseElement<?, ?>btnSuivant = new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.btnSuivant

    );


    BaseElement<?, ?>getBtnScenario2 = new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.getBtnScenario2

    );


    BaseElement<?, ?>textSupprimer = new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.textSupprimer

    );

    BaseElement<?, ?> btnGeolocaliser = new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.btnGeolocaliser

    );


    BaseElement<?, ?>  getIconeSelectionné  = new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz. getIconeSelectionné

    );
    BaseElement<?, ?> btnScenario = new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.btnScenario

    );

    BaseElement<?, ?> btnAjouterUnEquipement = new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.btnAjouterUnEquipement

    );

    BaseElement<?, ?> btnOximoIo = new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.btnOximoIo

    );

    BaseElement<?, ?> btnTerminer = new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.btnTerminer

    );



    BaseElement<?, ?> btnDesactiver = new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.btnDesactiver

    );

    BaseElement<?, ?> btnToujoursActiver = new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.btnToujoursActiver

    );

    BaseElement<?, ?> btnActiverUneFois = new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.btnActiverUneFois

    );



    BaseElement<?, ?> textDistanceDuDomicile = new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.textDistanceDuDomicile

    );

    BaseElement<?, ?> testScenario = new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.testScenario

    );

    @Given("l'utilisateur souhaite planifier via la géolocalisation")
    public void lUtilisateurSouhaitePlanifierViaLaGeolocalisation() {
        // TODO Auto-generated method

    }

    @When("l'utilisateur sélectionne le {string} pour la géolocalisation")
    public void lUtilisateurSélectionneLePourLaGéolocalisation(String textScénarios) {

        btnScenario.click();
        //assertTrue(btnScenario.getText().contains(textScénarios));

    }

    @And("l'utilisateur clique sur Géolocaliser")
    public void lUtilisateurCliqueSurGéolocaliser() {
        String expectedTextScénarios = "Mes scénarios";
        assertTrue(titleMesScenarios.getText().contains(expectedTextScénarios));
        testScenario.click();
        btnGeolocaliser.click();
       // btnAutoriserToujours.waitVisible().click();

    }

    @Then("trois actions sont possibles : Désactiver, Toujours activer, Activer une fois")
    public void troisActionsSontPossiblesDésactiverToujoursActiverActiverUneFois() {
        System.out.println(btnDesactiver.getText());
        assertTrue(btnDesactiver.getText().contains("Désactiver"));

        assertTrue(btnToujoursActiver.waitVisible().isDisplayed());
        assertTrue(btnActiverUneFois.waitVisible().isDisplayed());


    }

    @And("l'utilisateur clique sur Toujours activer après avoir ajusté la distance")
    public void lUtilisateurCliqueSurToujoursActiverAprèsAvoirAjustéLaDistance() {
        btnToujoursActiver.click();
    }

    @When("l'utilisateur peut choisir une distance entre {int}m And {int}km à laide dun curseur nommé {string}")
    public void lUtilisateurPeutChoisirUneDistanceEntreMAndKmÀLaideDunCurseurNommé(int arg0, int arg1, String expectedText) {
        assertTrue(textDistanceDuDomicile.getText().contains(expectedText));
        //TODO:faire random pour progressbar

    }

    @Then("l'utilisateur vérifie dans linterface dadministration que la planification est prise en compte dans le menu")
    public void lUtilisateurVérifieDansLinterfaceDadministrationQueLaPlanificationEstPriseEnCompteDansLeMenu() {

        //TODO:faire un test api
    }

    @And("l'utilisateur clique de nouveau sur {string}")
    public void lUtilisateurCliqueDeNouveauSur(String expectedText) {
        btnRetour.click();
        btnGeolocaliser.click();
        //TODO:

    }

    @And("l'utilisateur clique sur Enregistrer")
    public void lUtilisateurCliqueSurEnregistrer() {
       btnEnregister.click();

    }

    @When("l'utilisateur clique sur Activer une fois après avoir ajusté la distance")
    public void lUtilisateurCliqueSurActiverUneFoisAprèsAvoirAjustéLaDistance() {
        btnActiverUneFois.click();

    }

    @When("l'utilisateur clique sur Désactiver")
    public void lUtilisateurCliqueSurDésactiver() {

        btnDesactiver.click();
    }

    @When("l'utilisateur sélectionne le {string}")
    public void lUtilisateurSelectionneLe(String expectedText) {

        btnScenario.click();
    }


    @And("l'utilisateur clique sur {string}")
    public void lUtilisateurCliqueSur(String expectedText) {
     testScenario.click();



    }

    @And("l'utilisateur sélectionne léquipement à ajouter")
    public void lUtilisateurSelectionneLequipementAAjouter() {
        btnAjouterUnEquipement.click();
        btnLogement.click();


    }

    @And("l'utilisateur ne choisit pas daction à réaliser lors de lexécution du scénario")
    public void lUtilisateurNeChoisitPasDactionARealiserLorsDeLexecutionDuScenario() {
        // TODO on choisit pas une action à réaliser
    }



    @Then("l'utilisateur clique sur Valider")
    public void lUtilisateurCliqueSurValider() {
        btnValider.click();


    }




    @And("le message de mis à jour avec succès devrait s'afficher")
    public void leMessageDeMisAJourAvecSuccesDevraitSAfficher() {

        String actualText = snackbarText.waitVisible().getText();
        String regexPattern = "Le scénario [a-zA-Z]+ a été mis à jour avec succès\\.";
        assertTrue(actualText.matches(regexPattern));

    }
    @And("l'utilisateur choisit une action à réaliser lors de lexécution du scénario")
    public void lUtilisateurChoisitUneActionARealiserLorsDeLexecutionDuScenario() {
        wait(2);
        btnOximoIo.waitVisible().click();

        if(btnFermer.waitVisible().isEnabled()){
            btnFermer.click();
        } else if (btnOuvrir.waitVisible().isEnabled()) {
            btnOuvrir.click();
        }


    }

    @And("l'utilisateur clique sur Terminer")
    public void lUtilisateurCliqueSurTerminer() {
        btnTerminer.click();
    }


    @And("l'utilisateur resélectionne léquipement à ajouter")
    public void lUtilisateurReselectionneLequipementAAjouter() {
        btnOximoIo.click();
    }

    @When("l'utilisateur sélectionne le Scénarios")
    public void lUtilisateurSelectionneLeScenarios() {
        btnScenario.click();
    }

    @And("l'utilisateur choisit licône du scénario")
    public void lUtilisateurChoisitLiconeDuScenario() {
        iconeScénario.click();

    }

    @And("l'utilisateur nomme le scénario dans le champ {string}")
    public void lUtilisateurNommeLeScenarioDansLeChamp(String text) {
        String randomScenarioName = faker.lorem().word();


        if(ConfigReader.getProperty("platformName").equals("iOS")) {
            btnNommezScénario.waitVisible().sendKeys(randomScenarioName,Keys.ENTER);
        } else {
            btnNommezScénario.waitVisible().sendKeys(randomScenarioName);

            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        }




        }

    @And("l'utilisateur choisit léquipement à ajouter au scénario")
    public void lUtilisateurChoisitLequipementAAjouterAuScenario() {

        if(ConfigReader.getProperty("platformName").equals("iOS")) {
            btnLogement.click();
            btnOximoIo.click();
        } else {
            btnOximoIo.click();
        }





    }

    @And("l'utilisateur ne choisit pas la position de léquipement")
    public void lUtilisateurNeChoisitPasLaPositionDeLequipement() {
        //TODO: ne choisit pas la position de léquipement

    }

    @And("l'utilisateur verifie léquipement à ajouter au scénario")
    public void lUtilisateurVerifieLequipementAAjouterAuScenario() {
        assertTrue(getIconeSelectionné.waitVisible().isDisplayed());
    }



    @And("l{string}exécution du scénario")
    public void lUtilisateurChoisitLaPositionDeLequipementLorsDeLExecutionDuScenario() {
    }

    @And("Je clique sur {string}")
    public void jeCliqueSur(String arg0) {
    }


    @And("l'utilisateur clique sur Créer un scénario")
    public void lUtilisateurCliqueSurCreerUnScenario() {
        btnCréerUnScénario.waitVisible().click();

    }

    @And("l'utilisateur clique sur Suivant")
    public void lUtilisateurCliqueSurSuivant() {
        btnSuivant.click();

    }


    @And("le message de créé devrait s'afficher")
    public void leMessageDeCreeDevraitSAfficher() {

        String actualText = snackbarText.waitVisible().getText();
        String regexPattern = "Le scénario [a-zA-Z]+ a été créé avec succès\\.";
        System.out.println("regexPattern = " + regexPattern);
        assertTrue(actualText.matches(regexPattern));

    }
    @And("l'utilisateur clique sur le bouton retour")
    public void lUtilisateurCliqueSurLeBoutonRetour() {
        wait(3);
        btnRetour.click();

    }

    @Then("l'utilisateur sélectionne un scénario à supprimer")
    public void lUtilisateurSelectionneUnScenarioASupprimer() throws MalformedURLException, InterruptedException {

        wait(3);
        }

    @And("l'utilisateur le fait glisser vers la gauche")
    public void lUtilisateurLeFaitGlisserVersLaGauche() {
        swipe(getBtnScenario2.waitVisible(), "left", 0.5, 1000);
    }

    @Then("l'utilisateur clique sur Supprimer")
    public void lUtilisateurCliqueSurSupprimer() {
        btnSupprimer.click();
    }

    @And("le pop-up {string} s'affiche")
    public void lePopUpSAffiche(String expectedText) {
        assertTrue(textSupprimer.waitVisible().getText().contains(expectedText));
        wait(2);

    }



    @And("le message de suppression avec succès devrait s'afficher")
    public void leMessageDeSuppressionAvecSuccesDevraitSAfficher() {
        String actualText = snackbarText.waitVisible().getText();
        System.out.println("actualText = " + actualText);
        String regexPattern = "Le scénario [a-zA-Z]+ a été supprimé";
        System.out.println("regexPattern = " + regexPattern);
        assertTrue(actualText.matches(regexPattern));
    }




    @Then("l'utilisateur contrôler les données sur ladmin")
    public void lUtilisateurControlerLesDonneesSurLadmin() {
        //TODO:
    }
}

