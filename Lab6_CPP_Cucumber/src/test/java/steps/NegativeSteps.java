package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.MensPage;
import pages.ProductDetailsPage;
import pages.MiniCartPage;

public class NegativeSteps {

    MensPage mens = new MensPage();
    ProductDetailsPage details = new ProductDetailsPage();
    MiniCartPage cart = new MiniCartPage();

    @And("utilizatorul adauga produsul in cos fara selectarea marimii")
    public void add_without_size() {
        details.clickAddToCartWithoutSize();
    }

    @Then("produsul este adaugat in cos desi marimea nu a fost selectata")
    public void check_wrong_behavior() {
        boolean itemAdded = cart.getCartItemCount() > 0;

        assert itemAdded : "❌ Produsul NU a fost adaugat, dar mock-ul ar trebui sa-l permita.";

        System.out.println("⚠️ Comportament negativ detectat: Site-ul permite adaugare fara selectare marime.");
    }
}
