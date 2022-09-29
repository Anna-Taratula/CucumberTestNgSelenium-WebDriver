Feature: Login User

  Scenario:I logged in as not registered user

    Given I click login icon
    When I input valid value
    Then I got error message
