Feature: Automated End2End Tests
  Description: To test  End2End automation Tests

  Scenario Outline: Customer places an order by purchasing an item from search
    Given User is on home page
    When he searhes for "dress"
    And choose to buy first item
    And move to checkout from mini cart
    And enter "<customer>" personal details on checkout page 
    And enters shipping details
    And select payment method as "check" payment
    And place the order
    Then verify the order details

Examples:
|customer|
|Lakshay|
