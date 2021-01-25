package task.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Vadym Nastoiashchyi
 */

public class GoogleSearchPage {

    private WebDriver driver;

    @FindBy(name = "q")
    private WebElement element;

    private By searchFormLocator = By.name("q");


    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
    }


    public void openGooglePage() {
        driver.get("https://www.google.com/");
    }

    public void useGoogleSearchForm(String searchWord) {
        element = driver.findElement(searchFormLocator);
        element.sendKeys(searchWord);
        element.submit();
    }

}
