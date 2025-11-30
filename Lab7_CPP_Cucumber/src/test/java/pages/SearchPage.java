package pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locatori relativi
    private By searchBar = By.name("q");
    private By noResultsMessage =
            By.xpath("//*[contains(normalize-space(.), 'nu a returnat niciun document')]");
    private By didYouMeanLink = By.id("fprsl");
    private By suggestionsList = By.cssSelector("ul[role='listbox'] li span");

    public void openGoogle() {
        driver.get("https://www.google.com/");
    }

    public void typeInSearchBar(String text) {
        driver.findElement(searchBar).clear();
        driver.findElement(searchBar).sendKeys(text);
    }

    public void pressEnter() {
        driver.findElement(searchBar).sendKeys(Keys.ENTER);
    }

    public String readSearchBar() {
        return driver.findElement(searchBar).getAttribute("value");
    }

    public boolean noResultsFound() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(noResultsMessage));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void waitForDidYouMean(String corrected) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(didYouMeanLink));
        String text = element.getText().toLowerCase();

        if (!text.contains(corrected.toLowerCase())) {
            throw new AssertionError("Did you mean text does not contain expected suggestion: " + corrected);
        }
    }

    public void clickDidYouMean() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(didYouMeanLink));
        element.click();
    }

    public boolean suggestionsAppear(String text) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(suggestionsList));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean suggestionsContainSimilar(String text) {
        List<WebElement> items = driver.findElements(suggestionsList);
        return items.stream().anyMatch(el -> el.getText().toLowerCase().contains(text.toLowerCase().substring(0, 3)));
    }

}

