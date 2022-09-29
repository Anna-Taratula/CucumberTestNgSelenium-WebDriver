Feature: Add  item in the cart

  Scenario: Add  the same item in the cart

    Given I choose item and add it to the cart.
    When I add the same item
    Then The item is added