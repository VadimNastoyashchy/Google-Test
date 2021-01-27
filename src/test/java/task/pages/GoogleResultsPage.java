package task.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import task.BaseClass;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Vadym Nastoiashchyi
 */

public class GoogleResultsPage {

    private WebDriver driver;
    private List<String> links;
    private List<String> formatLinks;

    @FindBy(xpath = "//*[@id='rso']/div/div")
    private List<WebElement> findElements;

    @FindBy(tagName = "a")
    private WebElement getLinks;

    @FindBy(xpath = "//*[@id='pnnext']")
    private WebElement getNextPage;

    @FindBy(tagName = "a")
    private WebElement getHref;

    private By findSearchElements = By.xpath("//*[@id='rso']/div/div");
    private By getLinksFromElements = By.tagName("a");
    private By getNextPageElement = By.xpath("//*[@id='pnnext']");


    public GoogleResultsPage(String browser) {
        this.driver = BaseClass.getWebDriverInstance(browser);
        PageFactory.initElements(driver, this);
        links = new LinkedList<>();
        formatLinks = new LinkedList<>();
    }

    public void goToFirstLink() {
        getResult();
        driver.navigate().to(links.get(2));
    }


    public String getPageTitle() {
        String actualTitle = driver.getTitle();
        return actualTitle.toLowerCase();
    }

    public void searchContainsDomainInPages(int numberOfPages, String searchWord) {
        int currentPage = 1;
        endIteration:
        for (int i = 1; i < numberOfPages; i++, currentPage++) {
            int linkCount = 1;
            links.clear();
            formatLinks.clear();
            getResult();
            formatLink(links, formatLinks);
            for (int j = 0; j < formatLinks.size(); j++) {
                if (formatLinks.get(j).contains(searchWord)) {
                    Assert.assertTrue(formatLinks.get(j).contains(searchWord));
                    break endIteration;
                }
                if (linkCount == formatLinks.size()) {
                    driver.findElement(getNextPageElement).click();
                    linkCount = 1;
                }
                linkCount++;
            }
        }
        Assert.assertNotEquals(currentPage, numberOfPages);
    }

    private void getResult() {
        findElements = driver.findElements(findSearchElements);
        getLinks(findElements, links);
    }

    private void getLinks(List<WebElement> findElements, List<String> links) {
        for (WebElement findElement : findElements) {
            getLinks = findElement.findElement(getLinksFromElements);
            links.add(getLinks.getAttribute("href"));
        }
    }

    private void formatLink(List<String> links, List<String> formatLinks) {
        for (String l : links) {
            String temp = l.substring(8);
            formatLinks.add(temp.substring(0, temp.indexOf('/')));
        }
    }
}
