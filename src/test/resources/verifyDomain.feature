@verifyDomain
Feature: Verify domain in Google result pages


  Scenario: Verify domain in Google result pages
  Check if there is a link to the page whose domain contains
  the keyword that we typed in google search?

    Given user is on Google Home Page
    When user search for "automation"
    Then Check if there is a link to the page whose domain contains the keyword "automation"