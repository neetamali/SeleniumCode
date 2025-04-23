

Feature: Application Login
  Scenario: Admin page default login
    Given user is on netbanking landing page
    When user login into application
    Then Homepage is displayed
    And cards are displayed

  