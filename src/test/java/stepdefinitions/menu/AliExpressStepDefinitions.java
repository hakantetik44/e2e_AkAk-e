package stepdefinitions.menu;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.menu.AcceuilPage;
import utils.Driver;
import utils.OS;

public class AliExpressStepDefinitions {

    private AcceuilPage acceuilPage = new AcceuilPage();

    @Given("I am on the AliExpress platform")
    public void iAmOnTheAliExpressPlatform() {
        if (OS.isWeb()) {
            Driver.getWebDriver("firefox").get("https://www.aliexpress.com");
        } else if (OS.isAndroid()) {

        }
    }

    @When("Je vérifie que l'URL est correcte")
    public void jeVerifieQueLURLEstCorrecte() {
        Driver.getCurrentDriver(); // Bu çağrı, driver null ise onu başlatacak

        acceuilPage.clickBtnEnPlus();

    }

    @Then("Je devrais voir la page d'accueil d'AliExpress")
    public void jeDevraisVoirLaPageDAccueilDAliExpress() {
        Assert.assertTrue("Le logo AliExpress n'est pas affiché", acceuilPage.isLogoDisplayed());
    }

    @When("Je clique sur le bouton pour appeler le service client")
    public void jeCliqueSurLeBoutonPourAppelerLeServiceClient() {
        acceuilPage.clickCustomerServiceCallButton();
    }

    @Then("Je devrais voir l'écran d'appel téléphonique")
    public void jeDevraisVoirLEcranDAppelTelephonique() {

        if (OS.isWeb()) {

            Assert.assertTrue("L'écran de confirmation d'appel n'est pas affiché",
                    Driver.getCurrentDriver().findElement(By.cssSelector(".call-confirmation")).isDisplayed());
        } else if (OS.isAndroid()) {
            Assert.assertTrue("L'écran d'appel n'est pas affiché",
                    Driver.getCurrentDriver().findElement(By.id("com.android.dialer:id/dialpad")).isDisplayed());
        }
    }
}