Feature: Check login functionality

  @smoke
  Scenario:
    Given Login is on login page
    When User enters valid username and password
    And User clicks on login button
    Then User is navigated to the home page

  Scenario:
    Given Login is on login page
    When User enters valid username and password
    And User clicks on login button
    Then User is navigated to the home page