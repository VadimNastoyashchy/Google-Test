package google.pages;

import google.driverutil.DriverFactory;
import org.openqa.selenium.support.PageFactory;


/**
 * @author Vadym Nastoiashchyi
 */

public class GoogleMainPage {

    public GoogleMainPage() {
        DriverFactory.getWebDriverInstance();
        PageFactory.initElements(DriverFactory.driver, this);
    }

    public GoogleResultsPage openGooglePage() {
        String url = System.getProperty("google", "https://www.google.com/");
        DriverFactory.driver.get(url);
        return new GoogleResultsPage();
    }

}
