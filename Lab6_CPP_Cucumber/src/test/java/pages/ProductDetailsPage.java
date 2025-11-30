package pages;

import hooks.BrowserHooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage {

    private WebDriver driver = BrowserHooks.driver;

    private By productTitle = By.cssSelector(".single-right-left h3");
    private By addToCartBtn = By.cssSelector("input[type='submit'][value='Add to cart']");

    public boolean isDetailsPageLoaded() {
        try {
            return driver.findElement(productTitle).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public void clickAddToCartWithoutSize() {
        driver.findElement(addToCartBtn).click();
    }
}
