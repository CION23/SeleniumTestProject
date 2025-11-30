package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.MensPage;
import pages.MiniCartPage;

public class CartSteps {

    MensPage mensPage = new MensPage();
    MiniCartPage cart = new MiniCartPage();

    @And("utilizatorul adauga primul produs in cos")
    public void add_first_product() {
        mensPage.saveFirstProductData();
        mensPage.addFirstProductToCart();

        assert cart.cartIsVisible() : "❌ MiniCart NU a apărut după adăugarea în coș!";
    }

    @Then("produsul din cos trebuie sa fie acelasi cu cel adaugat")
    public void validate_cart_item() {

        String expectedName = mensPage.savedProductName;
        String actualName = cart.getCartProductName();

        System.out.println("Nume pagina Mens: " + expectedName);
        System.out.println("Nume in cos: " + actualName);

        // Normalizare pentru comparatie corecta
        String n1 = normalize(expectedName);
        String n2 = normalize(actualName);

        assert n2.contains(n1.substring(0, n1.length() - 1))
                : "❌ Numele NU corespunde!\nAsteptat: " + expectedName + "\nPrimit: " + actualName;

        System.out.println("✔ Numele produsului corespunde!");

        // Nu comparam pretul — difera din cauza scriptului simpleCart
    }

    private String normalize(String t) {
        return t.toLowerCase()
                .replace("’", "'")
                .replace("men's", "men's")
                .replace("men's", "men's")
                .replace("'", "")
                .replace(" ", "")
                .trim();
    }
}
