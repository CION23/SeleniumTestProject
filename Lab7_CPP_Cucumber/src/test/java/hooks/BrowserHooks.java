package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserHooks {

    private static WebDriver driver;

    @Before
    public void startBrowser() {

        ChromeOptions options = new ChromeOptions();

        // User-agent real pentru a evita fallback-ul Google
        options.addArguments(
                "user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
                        "AppleWebKit/537.36 (KHTML, like Gecko) " +
                        "Chrome/123.0.0.0 Safari/537.36"
        );

        // Evită detectarea Selenium
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");

        // Elimină flag-ul de automatizare din Chrome
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        driver = new ChromeDriver(options);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    @After
    public void closeBrowser() {
        if (driver != null) {
            //driver.quit();
        }
    }
}
