package steps;

import hooks.BrowserHooks;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.SearchPage;

public class GenericValidationSteps {

    private WebDriver driver = BrowserHooks.getDriver();
    private SearchPage searchPage = new SearchPage(driver);

    @Then("nu se afișează niciun rezultat")
    public void nu_se_afiseaza_niciun_rezultat() {
        Assert.assertTrue(
                "Mesajul de lipsă rezultate NU a fost găsit!",
                searchPage.noResultsFound()
        );
    }

    @Then("apare mesajul {string}")
    public void apare_mesajul(String msg) {

        String xpath = "//*[contains(normalize-space(.),'" + msg + "')]";

        Assert.assertTrue(
                "Mesajul NU a fost găsit pe pagină!",
                !driver.findElements(By.xpath(xpath)).isEmpty()
        );
    }

    @Then("rezultatul conține {string}")
    public void rezultatul_contine(String text) {

        String xpath = "//*[contains(normalize-space(.), '" + text + "')]";

        boolean found = !driver.findElements(By.xpath(xpath)).isEmpty();

        Assert.assertTrue(
                "Textul '" + text + "' NU a fost găsit în pagina rezultatelor!",
                found
        );
    }

    @Then("trebuie să apară o listă de sugestii pentru {string}")
    public void sugestii(String text) {
        Assert.assertTrue(searchPage.suggestionsAppear(text));
    }

    @Then("sugestiile conțin variante similare cuvântului {string}")
    public void sugestii_similare(String text) {
        Assert.assertTrue(searchPage.suggestionsContainSimilar(text));
    }
}
