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
        GoogleResultsPage googleResultsPage = new GoogleMainPage().openGooglePage().
                search("automation");
        googleResultsPage.goToFirstLink();
        Assert.assertTrue(googleResultsPage.getPageTitle().contains("automation"));
    }

    @Test
    public void verifyWordIsExpectedDomainOnGoogleResultPages() {
        GoogleResultsPage googleResultsPage = new GoogleMainPage().openGooglePage().
                search("automation");
        googleResultsPage.searchContainsDomainInPages(5, "automation");
    }

}






