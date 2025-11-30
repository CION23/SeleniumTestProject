package steps;

import hooks.BrowserHooks;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.MensPage;

import java.util.List;

public class NegativeSortSteps {

    MensPage mensPage = new MensPage();
    List<Double> pricesBefore;

    @And("utilizatorul salveaza lista de preturi curente")
    public void save_prices() {
        pricesBefore = mensPage.getPrices();
        System.out.println("Preturi initiale: " + pricesBefore);
    }

    @And("utilizatorul selecteaza sortarea dupa pret crescator")
    public void select_sort_low_to_high() {
        mensPage.sortByPriceLowToHigh();
        // Asteptam putin ca mock-ul sa nu faca nimic :)
        try { Thread.sleep(1000); } catch (Exception ignored) {}
    }

    @Then("lista de preturi ramane neschimbata")
    public void verify_sort_not_working() {
        List<Double> pricesAfter = mensPage.getPrices();
        System.out.println("Preturi dupa sortare: " + pricesAfter);

        Assert.assertEquals("❌ Sortarea AR FI TREBUIT să modifice prețurile, dar nu s-a întâmplat!",
                pricesBefore, pricesAfter);

        System.out.println("⚠️ Comportament negativ detectat: sortarea NU funcționează.");
    }
}
