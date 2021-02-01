package google.pages;

import google.driverutil.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Vadym Nastoiashchyi
 */

public class GoogleResultsPage {

    @FindBy(name = "q")
    private WebElement googleSearchForm;

    @FindBy(xpath = "//div[@class='g']")
    private List<WebElement> findElements;

    @FindBy(tagName = "a")
    private WebElement getLinks;


    private By findSearchElements = By.xpath("//div[@class='g']");
    private By getLinksFromElements = By.tagName("a");
    private By getNextPageElement = By.xpath("//*[@id='pnnext']");


    public GoogleResultsPage() {
        DriverFactory.getWebDriverInstance();
        PageFactory.initElements(DriverFactory.driver, this);
    }

    public void search(String searchWord) {
        googleSearchForm.sendKeys(searchWord);
        googleSearchForm.submit();
    }

    public void goToFirstLink() {
        List<String> links = new LinkedList<>();
        findElements = DriverFactory.driver.findElements(findSearchElements);
        for (WebElement findElement : findElements) {
            getLinks = findElement.findElement(getLinksFromElements);
            links.add(getLinks.getAttribute("href"));
        }
        DriverFactory.driver.navigate().to(links.get(0));
    }

    public String getPageTitle() {
        String actualTitle = DriverFactory.driver.getTitle();
        return actualTitle.toLowerCase();
    }

    public void searchContainsDomainInPages(int numberOfPages, String searchWord) {
        List<String> links = new LinkedList<>();
        List<String> formatLinks = new LinkedList<>();

        int currentPage = 1;
        endIteration:
        for (int i = 1; i < numberOfPages; i++, currentPage++) {
            int linkCount = 1;
            links.clear();
            formatLinks.clear();
            findElements = DriverFactory.driver.findElements(findSearchElements);
            for (WebElement findElement : findElements) {
                getLinks = findElement.findElement(getLinksFromElements);
                links.add(getLinks.getAttribute("href"));
            }
            for (String l : links) {
                String temp = l.substring(8);
                formatLinks.add(temp.substring(0, temp.indexOf('/')));
            }
            for (int j = 0; j < formatLinks.size(); j++) {
                if (formatLinks.get(j).contains(searchWord)) {
                    Assert.assertTrue(formatLinks.get(j).contains(searchWord));
                    break endIteration;
                }
                if (linkCount == formatLinks.size()) {
                    DriverFactory.driver.findElement(getNextPageElement).click();
                    linkCount = 1;
                }
                linkCount++;
            }
        }
        Assert.assertNotEquals(currentPage, numberOfPages);
    }

}
