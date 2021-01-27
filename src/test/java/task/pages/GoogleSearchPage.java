package task.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import task.BaseClass;

/**
 * @author Vadym Nastoiashchyi
 */

public class GoogleSearchPage {

    private WebDriver driver;
    private String browser;

    @FindBy(name = "q")
    private WebElement googleSearchForm;


    public GoogleSearchPage(String browser) {
        this.browser = browser;
        this.driver = BaseClass.getWebDriverInstance(browser);
        PageFactory.initElements(driver, this);
    }

    public void openGooglePage(String url) {
        driver.get(url);
    }

    public GoogleResultsPage search(String url, String searchWord) {
        openGooglePage(url);
        googleSearchForm.sendKeys(searchWord);
        googleSearchForm.submit();
        return new GoogleResultsPage(browser);
    }

}
