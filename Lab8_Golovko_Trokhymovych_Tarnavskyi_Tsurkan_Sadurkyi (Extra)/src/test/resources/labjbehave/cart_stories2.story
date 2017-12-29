Meta:

Narrative:
As a user
I want to buy few sledges and crash rosetka a little bit
So that I go to ItemPage and add product to cart

Scenario: 6 Changing amount of goods using textfield and plus button
Given opened catalog with empty cart
When select item 1
And click "Buy"
And input quantity 999
And click 1 times + button
Then item at position 1 has quantity 1000
And item name is the same as it was on the item's page
And calculations are correct

Scenario: 7 Adding new product to cart list using functional of going on shopping
Given opened catalog with empty cart
When select item 1
And click "Buy"
And click 2 times + button
And click on "Continue purchase" button
And go to catalog
And select item 2
And click "Buy"
And click 2 times + button
Then item at position 1 has quantity 3
And item at position 2 has quantity 3
And item name is the same as it was on the item's page
And calculations are correct

Scenario: 8 Deleting product from cart list
Given opened catalog with cart fulfilled with quantity 2 of first element from catalog
When click on cart button on menu bar
And click "delete from cart"
Then Cart displays "Cart is empty"

Scenario: 9 Checking availibility of products in a cart
Given opened catalog with cart fulfilled with quantity 2 of first element from catalog
When click element`s 1 "cart button"
Then item at position 1 has quantity 2