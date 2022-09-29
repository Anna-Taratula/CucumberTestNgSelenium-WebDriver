Feature: Add item to cart

  Scenario: I add toy

    Given I choose toys
    When I click add to cart
    Then I have an item in the basket