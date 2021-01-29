package google;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

/**
 * @author Vadym Nastoiashchyi
 */

public class Browser {
    public static WebDriver driver = null;

    private Browser() {
    }

    public static void getWebDriverInstance(String browser) {
        if (driver == null) {
            if ("CHROME".contains(browser.toUpperCase())) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if ("FIREFOX".contains(browser.toUpperCase())) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else if ("OPERA".contains(browser.toUpperCase())) {
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
            } else if ("EDGE".contains(browser.toUpperCase())) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            } else if ("IEXPLORER".contains(browser.toUpperCase())) {
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
            } else {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
        }
    }

    public static void quit() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
