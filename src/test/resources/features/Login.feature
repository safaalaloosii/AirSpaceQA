Feature: 1. As a user, I should be able to login to the Airspace app.

  Scenario: As a user, I should be able to Login using valid username and password
  When user is on the home page
    And provides  valid username and password
    Then see Login success message

    Scenario: As a user I should not be able to Login with invalid credentials
      When user is on the home page
      And provides invalid username and password
      Then user should see failure message
