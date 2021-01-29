package google.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import google.Browser;

/**
 * @author Vadym Nastoiashchyi
 */

public class GoogleMainPage {

    private String browser;

    @FindBy(name = "q")
    private WebElement googleSearchForm;


    public GoogleMainPage(String browser) {
        this.browser = browser;
        Browser.getWebDriverInstance(browser);
        PageFactory.initElements(Browser.driver, this);
    }

    public void openGooglePage(String url) {
        Browser.driver.get(url);
    }

    public GoogleResultsPage search(String url, String searchWord) {
        openGooglePage(url);
        googleSearchForm.sendKeys(searchWord);
        googleSearchForm.submit();
        return new GoogleResultsPage(browser);
    }

}
