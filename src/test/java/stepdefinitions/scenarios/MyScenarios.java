package stepdefinitions.scenarios;

import com.github.javafaker.Faker;
import com.somfy.ui.BaseElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.AppOperationManager;
import pages.BasePage;
import pages.scenarios.MyScenariosPage;

import java.net.MalformedURLException;
import java.util.Random;

import static org.junit.Assert.assertTrue;
import static utils.Driver.getCurrentDriver;

public class MyScenarios extends BasePage {
    MyScenariosPage overkiz = new MyScenariosPage();

    public MyScenarios() throws MalformedURLException, InterruptedException {
    }

    BaseElement<?, ?> titleMesScenarios = new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.titleMesScenarios

    );


    BaseElement<?, ?> btnRetour = new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.btnRetour

    );

    BaseElement<?, ?> btnEnregister = new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.btnEnregister

    );


    BaseElement<?, ?> btnAutoriserToujours = new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.btnAutoriserToujours

    );

    BaseElement<?, ?> btnGeolocaliser = new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.btnGeolocaliser

    );

    BaseElement<?, ?> btnScenario = new BaseElement<>(
            getCurrentDriver(),
            getCurrentDriver(),
            overkiz.btnScenario

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
        wait(2);
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

        assertTrue(btnDesactiver.waitVisible().isDisplayed());
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
        assertTrue(btnGeolocaliser.getText().contains(expectedText));
        btnGeolocaliser.click();

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

}

