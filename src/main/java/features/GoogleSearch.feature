
Feature: Testing google search functionality

  Scenario: Validate if google search is working
    Given Chrome browser is open
    And User is on google search page
    When User enters aa text in search box
    And User hits enter
    Then User is navigated to search result

