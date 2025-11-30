package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MiniCartPage;
import pages.MensPage;

public class MensCartSteps {

    MensPage mensPage = new MensPage();
    MiniCartPage cartPage = new MiniCartPage();

    @When("adauga primul produs in cos")
    public void add_first_product_to_cart() {
        mensPage.addFirstProductToCart();  // se deschide MiniCart direct
    }

    @Then("cardul produsului din cos trebuie sa fie valid")
    public void validate_cart_product_card() {
        assert cartPage.cartIsVisible() : "❌ MiniCart nu este vizibil!";
        assert cartPage.getCartItemCount() > 0 : "❌ Coșul nu conține produse!";

        boolean valid = cartPage.validateCartItem(cartPage.getFirstCartItem());
        assert valid : "❌ Cardul produsului din coș NU este valid!";

        System.out.println("✔ Cardul produsului din coș este valid!");
    }
}
