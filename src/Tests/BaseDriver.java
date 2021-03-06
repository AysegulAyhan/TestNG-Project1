package Tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseDriver {
    protected WebDriver driver;
    protected Actions builder;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;

    @BeforeClass(alwaysRun = true)
    protected void setup() {
            System.setProperty("webdriver.chrome.driver", "C:\\Selenium dependency\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
            builder = new Actions(driver);
            wait = new WebDriverWait(driver, 10);
            js = (JavascriptExecutor) driver;
    }
    /*
    @AfterClass(alwaysRun = true)
    protected void closeDriver() {
        driver.quit();
    }

     */
}
