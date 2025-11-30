package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserHooks {

    public static WebDriver driver;

    @Before
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void closeBrowser(io.cucumber.java.Scenario scenario) {
        if (scenario.getSourceTagNames().contains("@CloseBrowser")) {
            if (driver != null) {
                driver.quit();
                System.out.println("✔ Browser închis DOAR pentru scenariul: " + scenario.getName());
            }
        }
    }
}
