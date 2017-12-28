//BDD 6

Feature: total quantity of products in cart

	In order to not add more then I need
	As a customer
	I want to see the number of products in the cart 

@positive @state_of_cart
Scenario: showing the quantity 1 near the cart if cart is empty and we buy one product and close the window  
	Given Go to the main page (https://rozetka.com.ua/hudojestvennaya-literatura/c4326593/)
	And The product is in stock in the shop
	And The cart is empty
	When Press the button buy (near the product)
	And Press close the window (in the window that appeared)
	Then The quantity 1 will be near the cart in the upper right corner
	And It will be on all pages
	