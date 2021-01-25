package task;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import task.pages.GoogleResultsPage;
import task.pages.GoogleSearchPage;

/**
 * @author Vadym Nastoiashchyi
 */

public class TestClass extends BaseTest {

    @Test
    public void testFirst() {
        GoogleSearchPage googleSearchPage = PageFactory.initElements(driver, GoogleSearchPage.class);
        GoogleResultsPage googleResultsPage = PageFactory.initElements(driver, GoogleResultsPage.class);
        googleSearchPage.openGooglePage();
        googleSearchPage.useGoogleSearchForm("automation");
        googleResultsPage.goToFirstLink();
        Assert.assertTrue(googleResultsPage.getPageTitle().contains("automation"));
    }

    @Test
    public void testSecond() {
        GoogleSearchPage googleSearchPage = PageFactory.initElements(driver, GoogleSearchPage.class);
        GoogleResultsPage googleResultsPage = PageFactory.initElements(driver, GoogleResultsPage.class);
        googleSearchPage.openGooglePage();
        googleSearchPage.useGoogleSearchForm("automation");
        googleResultsPage.searchContainsDomainInPages(5, "automation");
    }

}






