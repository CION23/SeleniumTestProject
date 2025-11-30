package steps;

import hooks.BrowserHooks;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.SearchPage;

public class SearchSteps {

    private WebDriver driver = BrowserHooks.getDriver();
    private SearchPage searchPage = new SearchPage(driver);

    @When("se introduce textul {string} în bara de căutare")
    public void se_introduce_textul(String text) throws InterruptedException {
        searchPage.openGoogle();
        Thread.sleep(600);
        searchPage.typeInSearchBar(text);
        Thread.sleep(800);
    }

    @And("se apăsa Enter")
    public void se_apasa_enter() throws InterruptedException {
        searchPage.pressEnter();
        Thread.sleep(1200);
    }

    @And("aștept sugestia DidYouMean {string}")
    public void astept_sugestia_did_you_mean(String corect) throws InterruptedException {
        searchPage.waitForDidYouMean(corect);
    }

    @And("selectez sugestia DidYouMean")
    public void selectez_sugestia_did_you_mean() throws InterruptedException {
        searchPage.clickDidYouMean();
    }

}
