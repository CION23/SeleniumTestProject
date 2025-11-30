package steps;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.MensPage;
import pages.ProductDetailsPage;

public class ProductDetailsSteps {

    MensPage mensPage = new MensPage();
    ProductDetailsPage productDetailsPage = new ProductDetailsPage();

    @When("utilizatorul deschide detaliile primului produs")
    public void open_first_product_details() {
        mensPage.openFirstProductDetails();
    }

    @Then("pagina de detalii trebuie sa se deschida corect")
    public void verify_details_page_is_opened() {
        assert productDetailsPage.isDetailsPageLoaded()
                : "❌ Pagina de detalii NU s-a încărcat!";
        System.out.println("✔ Pagina de detalii s-a încărcat corect!");
    }
}
