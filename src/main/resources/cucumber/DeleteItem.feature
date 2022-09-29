Feature: Delete item

  Scenario: I delete item from the cart

    Given I choose item and add it to the cart
    When I delete item
    Then The item is deleted