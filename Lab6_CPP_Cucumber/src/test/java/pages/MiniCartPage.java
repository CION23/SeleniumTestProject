package pages;

import hooks.BrowserHooks;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;


import java.util.List;

public class MiniCartPage {

    private WebDriver driver = BrowserHooks.driver;

    // MINI CART
    private By cartContainer = By.id("PPMiniCart");
    private By cartItems = By.cssSelector("#PPMiniCart .minicart-item");

    // ELEMENTE DIN CARDUL DIN COS
    private By itemName = By.cssSelector(".minicart-name");
    private By itemPrice = By.cssSelector(".minicart-price");
    private By itemQty = By.cssSelector(".minicart-quantity");
    private By itemRemove = By.cssSelector(".minicart-remove");

    public boolean cartIsVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(cartContainer));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public int getCartItemCount() {
        return driver.findElements(cartItems).size();
    }

    public WebElement getFirstCartItem() {
        return driver.findElements(cartItems).get(0);
    }

    public boolean validateCartItem(WebElement item) {
        boolean name = item.findElement(itemName).isDisplayed();
        boolean price = item.findElement(itemPrice).isDisplayed();
        boolean qty = item.findElement(itemQty).isDisplayed();
        boolean removeBtn = item.findElement(itemRemove).isDisplayed();

        return name && price && qty && removeBtn;
    }

    public String getCartProductName() {
        return driver.findElement(itemName).getText();
    }

    public String getCartProductPrice() {
        return driver.findElement(itemPrice).getText();
    }
}
