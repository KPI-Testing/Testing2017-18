Feature: test functionality of basket on rozetka.com.ua
  Scenario: add good in basket way 1
    Given browser is opened
    And  Site "rozetka.com.ua" is opened
    When I click on "3 Autores"
    And choose good of the customer "3 Autores"
    And click on button buy
    Then the basket is opened
    And the good of "3 Autores" should be displayed in the basket
    And browser is closed

  Scenario: add good in basket way 2
    Given browser is opened
    And  Site "rozetka.com.ua" is opened
    When I click on icon basket near price of the good
    Then the basket is opened
    And the good should be displayed in the basket
    And browser is closed

  Scenario: add +1 good in basket
    Given browser is opened
    And  Site "rozetka.com.ua" is opened
    And good is added to basket
    When click on "+"
    Then quantity of the goods should be "added" on 1 count
    And browser is closed

  Scenario: delete -1 good from basket
    Given browser is opened
    And  Site "rozetka.com.ua" is opened
    And two or more goods is added to basket
    When click on "-"
    Then quantity of the goods should be "deleted" on 1 count
    And browser is closed

  Scenario: delete good from basket
    Given browser is opened
    And  Site "rozetka.com.ua" is opened
    And good is added to basket
    When click on button cross
    And click on delete without saving
    Then good should be deleted from the basket
    And browser is closed

  Scenario: open basket
    Given browser is opened
    And  Site "rozetka.com.ua" is opened
    When click on button basket
    Then the basket is opened
    And browser is closed

  Scenario: close basket
    Given browser is opened
    And  Site "rozetka.com.ua" is opened
    And user is on basket page
    When click on button close
    Then basket is closed
    And browser is closed

  Scenario: adding two different goods
    Given browser is opened
    And  Site "rozetka.com.ua" is opened
    When user add 1 good to the basket
    And return to previous page
    And user add 2 good to the basket
    Then quantity of the goods in the basket should be 2
    And browser is closed

  Scenario:entering quantity of the good using textfield
    Given browser is opened
    And  Site "rozetka.com.ua" is opened
    And user add 1 good to the basket
    When user enter "10" in textfield
    Then textfield should contain "10"
    And browser is closed

  Scenario:price of the good is changed correctly
    Given browser is opened
    And  Site "rozetka.com.ua" is opened
    And user add 1 good to the basket
    When user enter "10" in textfield
    Then price should be increased in 10 times
    And browser is closed

  Scenario: Whole price calculate correctly
    Given browser is opened
    And  Site "rozetka.com.ua" is opened
    When user add 1 good to the basket
    And return to previous page
    And user add 2 good to the basket
    Then whole price should be added correctly
    And browser is closed

  Scenario: adding two different goods and right order in a basket
    Given browser is opened
    And  Site "rozetka.com.ua" is opened
    When user add 1 good to the basket
    And return to previous page
    And user add 2 good to the basket
    Then the basket is opened
    And the good should be displayed in the basket
    And browser is closed