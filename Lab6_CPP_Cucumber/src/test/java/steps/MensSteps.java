package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.MensPage;

public class MensSteps {

    MensPage mensPage = new MensPage();

    @Given("utilizatorul acceseaza pagina Mens")
    public void open_mens_page() {
        mensPage.openMensPage();
    }

    @When("pagina Mens este incarcata complet")
    public void check_page_is_loaded() {
        assert mensPage.isPageLoaded() : "Pagina Mens nu s-a încărcat!";
    }
}
