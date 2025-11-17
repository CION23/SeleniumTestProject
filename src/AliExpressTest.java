import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

public class AliExpressTest {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        String result = ""; // to store test result

        try {
            // 1. Open aliexpress.com
            driver.get("https://www.aliexpress.com/");

            // 2. Search for "computer"
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.name("SearchText")));
            searchBox.sendKeys("computer");
            searchBox.submit();

            // 3. Wait for results page
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("header")));

            // 4. Check that header is displayed
            WebElement header = driver.findElement(By.cssSelector("header"));
            if(header.isDisplayed()) {
                result = "Test Passed: Header is displayed";
                System.out.println(result);
            } else {
                result = "Test Failed: Header not displayed";
                System.out.println(result);
            }

            // 5. Save result to a text file in same directory
            try (FileWriter writer = new FileWriter("test_result.txt")) {
                writer.write(result);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
