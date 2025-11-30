package pages;

import hooks.BrowserHooks;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MensPage {

    private WebDriver driver = BrowserHooks.driver;

    private By cartButton = By.cssSelector(".w3view-cart");
    private By productItems = By.cssSelector(".col-md-3.product-men");
    private By productTitle = By.cssSelector("h4 a");
    private By productPrice = By.cssSelector(".item_price");
    private By productImage = By.cssSelector(".pro-image-front");
    private By addToCartBtn = By.cssSelector("input[type='submit'][value='Add to cart']");

    public String savedProductName;
    public String savedProductPrice;

    private By priceElements = By.cssSelector(".item_price");
    private By sortDropdown = By.id("country1");

    private By searchInput = By.cssSelector("input[type='search']");
    private By searchButton = By.cssSelector("input[type='submit'][value=' ']");


    public void openMensPage() {
        driver.get("https://adoring-pasteur-3ae17d.netlify.app/mens");
    }

    public boolean isPageLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(productItems));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public int getProductsCount() {
        List<WebElement> products = driver.findElements(productItems);
        return products.size();
    }

    public void addFirstProductToCart() {
        WebElement firstCard = driver.findElements(productItems).get(0);
        WebElement addBtn = firstCard.findElement(addToCartBtn);
        addBtn.click();
    }

    public String getFirstProductName() {
        WebElement firstCard = driver.findElements(productItems).get(0);
        return firstCard.findElement(productTitle).getText().trim();
    }

    public void openFirstProductDetails() {
        WebElement firstCard = driver.findElements(productItems).get(0);
        WebElement quickView = firstCard.findElement(By.cssSelector(".link-product-add-cart"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", quickView);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", quickView);
    }

    public void saveFirstProductData() {
        WebElement first = driver.findElements(productItems).get(0);
        savedProductName = first.findElement(productTitle).getText();
        savedProductPrice = first.findElement(productPrice).getText();
    }

    public List<Double> getPrices() {
        List<WebElement> prices = driver.findElements(priceElements);
        List<Double> priceValues = new ArrayList<>();

        for (WebElement p : prices) {
            String text = p.getText().replace("$", "").trim();
            priceValues.add(Double.parseDouble(text));
        }
        return priceValues;
    }

    public void sortByPriceLowToHigh() {
        Select dropdown = new Select(driver.findElement(sortDropdown));
        dropdown.selectByValue("3"); // Price(Low - High)
    }

    public void searchProduct(String text) {
        WebElement input = driver.findElement(searchInput);
        input.clear();
        input.sendKeys(text);
    }

    public void clickSearch() {
        driver.findElement(searchButton).click();
    }

    public List<String> getProductTitles() {
        List<WebElement> products = driver.findElements(productItems);
        List<String> titles = new ArrayList<>();

        for (WebElement p : products) {
            titles.add(p.findElement(productTitle).getText());
        }
        return titles;
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getPageText() {
        return driver.findElement(By.tagName("body")).getText();
    }

}
