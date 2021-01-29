package google.pages;

import google.driverutil.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * @author Vadym Nastoiashchyi
 */

public class GoogleMainPage {

    private String browser;

    @FindBy(name = "q")
    private WebElement googleSearchForm;


    public GoogleMainPage() {

        DriverFactory.getWebDriverInstance();
        PageFactory.initElements(DriverFactory.driver, this);
    }

    public void openGooglePage(String url) {
        DriverFactory.driver.get(url);
    }

    public GoogleResultsPage search(String url, String searchWord) {
        openGooglePage(url);
        googleSearchForm.sendKeys(searchWord);
        googleSearchForm.submit();
        return new GoogleResultsPage();
    }

}
