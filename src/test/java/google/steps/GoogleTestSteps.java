package google.steps;

import google.driverutil.DriverFactory;
import google.pages.GoogleMainPage;
import google.pages.GoogleResultsPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

/**
 * @author Vadym Nastoiashchyi
 */

public class GoogleTestSteps {
    GoogleResultsPage googleResultsPage;

    @After
    public void tearDown() {
        DriverFactory.quit();
    }

    @Given("user is on Google Home Page")
    public void userIsOnGoogleHomePage() {
    }

    @When("user search for {string}")
    public void userSearchFor(String keyWord) {
        googleResultsPage = new GoogleMainPage().openGooglePage().
                search(keyWord);
    }

    @Then("first search results link contains title {string}")
    public void firstSearchResultsLinkContainsTitle(String keyWord) {
        googleResultsPage.goToFirstLink();
        Assert.assertTrue(googleResultsPage.getPageTitle().contains(keyWord));
    }

    @Then("Check if there is a link to the page whose domain contains the keyword {string}")
    public void checkIfThereIsALinkToThePageWhoseDomainContainsTheKeyword(String keyWord) {
        googleResultsPage.searchContainsDomainInPages(5, keyWord);
    }
}
