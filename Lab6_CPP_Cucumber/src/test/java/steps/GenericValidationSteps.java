package steps;

import io.cucumber.java.en.Then;
import pages.MensPage;

public class GenericValidationSteps {

    MensPage mensPage = new MensPage();

    @Then("numarul de produse afisate trebuie sa fie mai mare ca 0")
    public void validate_products_exist() {
        int count = mensPage.getProductsCount();
        System.out.println("📦 Numar produse gasite pe pagina Mens: " + count);
        assert count > 0 : "Nu exista produse afisate!";
    }
}
