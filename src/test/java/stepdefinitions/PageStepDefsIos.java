package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import java.net.MalformedURLException;
import java.util.Random;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;
import pages.OverkizPages;
import utils.Driver;


public class PageStepDefsIos extends BasePage {

    private static final Logger LOG = LoggerFactory.getLogger(PageStepDefsIos.class);
    OverkizPages overkiz = new OverkizPages();
    Actions actions = new Actions(Driver.getCurrentDriver());
    Faker faker = new Faker();

    Random random = new Random();

    public PageStepDefsIos() throws MalformedURLException, InterruptedException {
    }


    @Given("lutilisateur souhaite se connecter à l'application Ios")
    public void lutilisateurSouhaiteSeConnecterALApplicationIos() throws InterruptedException {
        wait(2);
        cliquerLogoOverKizConnectSeptFois(actions,overkiz.logoOvezKizIos);
        wait(2);
    }

    @Given("pause")
    public void pause() throws InterruptedException {
        Thread.sleep(5000);
    }
}



