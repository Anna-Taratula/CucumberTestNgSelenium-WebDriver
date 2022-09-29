Feature: Currency change

  Scenario: Change currency in CurrencySettings

    Given I open Currency Settings
    When I change currency
    Then Chosen currency is dispeyed