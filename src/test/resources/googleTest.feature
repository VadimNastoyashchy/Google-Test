Feature: Google Test


  Scenario: First link contains title
  Is it first search results link contains title "automation"?

    Given user is on Google Home Page
    When user search for "automation"
    Then first search results link contains title "automation"


  Scenario: Verify domain in Google result pages
  Check if there is a link to the page whose domain contains
  the keyword that we typed in google search?

    Given user is on Google Home Page
    When user search for "automation"
    Then Check if there is a link to the page whose domain contains the keyword "automation"
