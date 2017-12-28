Feature: I_HATE_ROZETKA

  Scenario: buy one
    Given Browser "chrome" is opened
    And Website "https://rozetka.com.ua" is opened
    When I click on "Apple"
    Then The basket is "opened"
    And Good "Apple" is in basket
    And Browser is closed

  Scenario: buy оne more
    Given Browser "chrome" is opened
    And Website "https://rozetka.com.ua" is opened
    When I click on "Apple"
    And I click plus to add one more
    Then Number of items is 2
    And Browser is closed

  Scenario: delete one copy
    Given Browser "chrome" is opened
    And Website "https://rozetka.com.ua" is opened
    When I click on "Apple"
    And I set number of goods 2
    And I click minus to delete one copy
    Then Number of items is 1
    And Browser is closed

  Scenario: buy 50
    Given Browser "chrome" is opened
    And Website "https://rozetka.com.ua" is opened
    When I click on "Apple"
    And I set number of goods 50
    Then Number of items is 50
    And Browser is closed

  Scenario: open basket
    Given Browser "chrome" is opened
    And Website "https://rozetka.com.ua" is opened
    When I click on "basket"
    Then The basket is "opened"
    And Basket is empty
    And Browser is closed

  Scenario: close basket
    Given Browser "chrome" is opened
    And Website "https://rozetka.com.ua" is opened
    When I click on "basket"
    And I close basket
    Then The basket is "closed"
    And Browser is closed

  Scenario: delete by typing zero
    Given Browser "chrome" is opened
    And Website "https://rozetka.com.ua" is opened
    When I click on "Apple"
    And I set number of goods 0
    Then Basket is empty
    And Browser is closed

  Scenario: delete one item
    Given Browser "chrome" is opened
    And Website "https://rozetka.com.ua" is opened
    When I click on "Apple"
    And I delete "Apple"
    Then Basket is empty
    And Browser is closed

  Scenario: two different items
    Given Browser "chrome" is opened
    And Website "https://rozetka.com.ua" is opened
    When I click on "Apple"
    And I close basket
    And I click on "Samsung"
    Then Good "Apple" is in basket
    And Good "Samsung" is in basket
    And Browser is closed

  Scenario: delete one of items
    Given Browser "chrome" is opened
    And Website "https://rozetka.com.ua" is opened
    When I click on "Apple"
    And I close basket
    And I click on "Samsung"
    And I delete "Apple"
    Then Good "Samsung" is in basket
    And Good "Apple" not in basket
    And Browser is closed

  Scenario: calculations
    Given Browser "chrome" is opened
    And Website "https://rozetka.com.ua" is opened
    When I click on "Apple"
    And I set number of goods 10
    Then The price is 254990
    And Browser is closed