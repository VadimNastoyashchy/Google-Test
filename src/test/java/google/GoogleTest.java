package google;

import google.pages.GoogleMainPage;
import org.junit.Assert;
import org.junit.Test;
import google.pages.GoogleResultsPage;

/**
 * @author Vadym Nastoiashchyi
 */

public class GoogleTest extends BaseTest {

    @Test
    public void verifyContainsWordFirstLinkTitleOnGoogleResultPages() {
        GoogleMainPage googleMainPage = new GoogleMainPage("Chrome");
        GoogleResultsPage googleResultsPage = googleMainPage.
                search("https://www.google.com/", "automation");
        googleResultsPage.goToFirstLink();
        Assert.assertTrue(googleResultsPage.getPageTitle().contains("automation"));
    }

    @Test
    public void verifyWordIsExpectedDomainOnGoogleResultPages() {
        GoogleMainPage googleMainPage = new GoogleMainPage("Chrome");
        GoogleResultsPage googleResultsPage = googleMainPage.
                search("https://www.google.com/", "automation");
        googleResultsPage.searchContainsDomainInPages(5, "automation");
    }

}






