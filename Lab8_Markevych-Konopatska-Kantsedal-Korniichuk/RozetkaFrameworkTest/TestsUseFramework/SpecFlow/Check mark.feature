//BDD 7
Feature: check mark
	In order to not add it again
	As a customer
	I want to see a check mark near the products that are already in the cart

	@positive 
Scenario: a "check mark" is appeared near the buy button on the main page when we return to the main page 
		  after buying the product and closing the window
	Given Go to the main page (https://rozetka.com.ua/hudojestvennaya-literatura/c4326593/)
	And The product is in stock in the shop
	When Press the button buy (near the product)
	And Press close the window (in the window that appeared)
	And You return to the main page
	Then There will be a "check mark" near the buy button (near the product that we added to the cart)
