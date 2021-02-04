package google.pages;

import google.driverutil.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * @author Vadym Nastoiashchyi
 */

public class GoogleMainPage {
    @FindBy(name = "q")
    private WebElement googleSearchForm;

    public GoogleMainPage() {
        DriverFactory.getWebDriverInstance();
        PageFactory.initElements(DriverFactory.driver, this);
    }

    public GoogleResultsPage openGooglePage() {
        String url = System.getProperty("google", "https://www.google.com/");
        DriverFactory.driver.get(url);
        return new GoogleResultsPage();
    }

    public GoogleResultsPage search(String searchWord) {
        googleSearchForm.sendKeys(searchWord);
        googleSearchForm.submit();
        return new GoogleResultsPage();
    }

}
