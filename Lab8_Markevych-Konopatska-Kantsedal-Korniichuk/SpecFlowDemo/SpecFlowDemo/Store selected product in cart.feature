//BDD 9
Feature: store selected product in cart

	In order to not add it again
	As a customer
	I want to see what products are already in the cart

@positive @state_of_cart
Scenario: Only one product that we chose is stored with quantity 1 in previously empty cart after we close it
	Given Go to the main page (https://rozetka.com.ua/hudojestvennaya-literatura/c4326593/)
	And The product is in stock in the shop
	And The cart is empty
	And Press the button buy (near the product)
	And Press close the window (in the window that appeared)
	When Press the button buy ("Товар в корзине") near the product
	Then You are in the cart
	And In the window of cart will be only one product (the one we chosed) and its quantity will be 1