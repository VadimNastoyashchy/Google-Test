## About project
This project is used to find and check the match of the searched keyword in the Google search results.
The project consists of two tests:

1.Check if the title of the first open page from the Google search results contains the keyword that we print in Google search form.

2.Check if there is a link to the page whose domain contains the keyword that we typed in google search.

### How to use
**1. You must create Google search page, and pass in the preferred browser parameter:**
   
GoogleSearchPage googleSearchPage = new GoogleSearchPage("Your browser");

**2. Create a google result by calling the method chain, and passing the parameter url address and keyword:**

_GoogleResultsPage googleResultsPage = googleSearchPage.
search("url", "keyword");_

**3. If the first test is used, you need to add a click on the link:**

_goToFirstLink();_

**4. To check tests, use the capabilities of the framework JUnit:**

1. Test:
   _Assert.assertTrue(googleResultsPage.getPageTitle().contains("keyword"));_
   Will return true if the title of the first page contains a keyword.

2. Test:
   _googleResultsPage.searchContainsDomainInPages(number of pages checked, "keyword");
   Will return true if the domain contains the keyword.
   
