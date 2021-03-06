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

    @After
    public void tearDown() {
        DriverFactory.quit();
    }

    @Given("user is on Google Home Page")
    public void userIsOnGoogleHomePage() {
        GoogleResultsPage googleResultsPage = new GoogleMainPage().openGooglePage();
    }

    @When("user search for {string}")
    public void userSearchFor(String keyWord) {
        GoogleResultsPage googleResultsPage = new GoogleMainPage().search(keyWord);
    }

    @Then("first search results link contains title {string}")
    public void firstSearchResultsLinkContainsTitle(String keyWord) {
        GoogleResultsPage googleResultsPage = new GoogleResultsPage();
        googleResultsPage.goToFirstLink();
        Assert.assertTrue(googleResultsPage.getPageTitle().contains(keyWord));
    }

    @Then("Check if there is a link to the page whose domain contains the keyword {string}")
    public void checkIfThereIsALinkToThePageWhoseDomainContainsTheKeyword(String keyWord) {
        GoogleResultsPage googleResultsPage = new GoogleResultsPage();
        googleResultsPage.searchContainsDomainInPages(5, keyWord);
    }
}
