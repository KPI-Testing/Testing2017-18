Meta:

Narrative:
As a user
I want to buy few sledges and crash rosetka a little bit
So that I go to ItemPage and add product to cart

Scenario: 0.1 Buying product
Given opened catalog with empty cart
When select item 1
And click "Buy"
Then item at position 1 has quantity 1
And item name is the same as it was on the item's page
And calculations are correct

Scenario: 1 Adding element after buying from ElementPage
Given opened catalog with empty cart
When select item 1
And click "Buy"
And click 2 times + button
Then item at position 1 has quantity 3
And item name is the same as it was on the item's page
And calculations are correct

Scenario: 2 Adding element after buying from SearchPage
Given opened catalog with empty cart
When click element`s 1 "cart button"
And click on "Continue purchase" button
And click on cart button on menu bar
And click 2 times + button
Then item at position 1 has quantity 3
And calculations are correct

Scenario: 3 Decreasing amount of product in the cart
Given opened catalog with cart fulfilled with quantity 2 of first element from catalog
When click on cart button on menu bar
And click 1 times - button
Then item at position 1 has quantity 1
And item name is the same as it was on the item's page
And calculations are correct

Scenario: 4 Adding new product to cart list
Given opened catalog with cart fulfilled with quantity 2 of first element from catalog
When select item 2
And click "Buy"
And click 2 times + button
Then item at position 1 has quantity 3
And item at position 2 has quantity 2
And item name is the same as it was on the item's page
And calculations are correct

Scenario: 5 Changing amount of goods using textfield
Given opened catalog with empty cart
When select item 1
And click "Buy"
And input quantity 999
Then item at position 1 has quantity 999
And item name is the same as it was on the item's page
And calculations are correct
