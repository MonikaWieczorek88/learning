Feature: Test login functionality

  Scenario Outline: Check login is successful with valid credentials
    Given Browser is open
    And User is on login page
    When User enters <username> and <password>
    And user click on login
    Then User is navigated to the home page

    Examples:
      | username | password |
      | Raghav   |12345     |
      | Ele      |12345     |

