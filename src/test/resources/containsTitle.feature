@containsTitle
Feature: First link contains title


  Scenario: First link contains title
  Is it first search results link contains title "automation"?

    Given user is on Google Home Page
    When user search for "automation"
    Then first search results link contains title "automation"

