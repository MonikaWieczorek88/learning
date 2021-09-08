Feature: Check home page functionality

  Background: User is logged in
    Given User is on login page
    When User enters username and password
    And User clicks on login button
    Then User is navigated to the home page

  Scenario: Check logout link
    When User clicks on welcome link
    Then Logout link is displayed

  Scenario: Verify quick launch toolbar is present
    When User clicks on dashboard link
    Then Quick launch toolbar is dispalyed

