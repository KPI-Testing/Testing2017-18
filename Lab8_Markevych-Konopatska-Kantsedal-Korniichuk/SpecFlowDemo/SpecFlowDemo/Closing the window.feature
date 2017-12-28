//BDD 5.1

Feature: closing the window

	In order to view other information about the selected product
	As a customer
	I want to stay on the added product page after adding it and closing the cart window

@positive 
Scenario: stay on the product page after buying it and closing the window
	Given Go to the main page (https://rozetka.com.ua/hudojestvennaya-literatura/c4326593/)
	And The product is in stock in the shop
	When Press the button buy (near the product)
	And Press close the window (in the window that appeared)
	Then You will be on the page of the product
