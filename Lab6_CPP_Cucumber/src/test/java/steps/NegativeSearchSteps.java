package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.MensPage;
import java.util.List;

public class NegativeSearchSteps {

    MensPage mensPage = new MensPage();
    List<String> titlesBefore;

    @And("utilizatorul introduce in search {string}")
    public void enter_search_text(String text) {
        // salvăm titlurile înainte de search
        titlesBefore = mensPage.getProductTitles();
        mensPage.searchProduct(text);
    }

    @And("utilizatorul apasa butonul de cautare")
    public void click_search() {
        mensPage.clickSearch();
        try { Thread.sleep(1500); } catch (Exception ignored) {}
    }

    @Then("utilizatorul este redirectionat la pagina 404")
    public void redirected_to_404() {
        String url = mensPage.getCurrentUrl();
        String body = mensPage.getPageText();

        boolean is404 = body.contains("Page not found") || url.contains("404");

        Assert.assertTrue("❌ NU a aparut pagina 404 după search!", is404);

        System.out.println("✔ Negative test: Search duce la 404 → Comportament invalid detectat.");
    }

}
