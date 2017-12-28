//BDD 4
Feature: Button Buy

	In order to buy it later
	As a customer
	I want to add the product that I chose to the cart

@positive @state of cart
Scenario: Notification "Вы добавили товар в корзину" is shown and
		  the name of the shown product is the same as the name of the product we chose 
		  if we press the button buy
	
	Given Go to the main page (https://rozetka.com.ua/hudojestvennaya-literatura/c4326593/)
	And The product is in stock in the shop
	When Press the button buy (near the product)
	Then New window will be shown
	And The notification "Вы добавили товар в корзину" will be shown
	And The name of the shown product is the same as the name of the product we chose

//BDD 4.1

@positive @state_of_cart
Scenario: Notification "Вы добавили товар в корзину" is shown and
		  the price of the shown product is the same as the price of the product we chose 
		  if we press the button buy

	Given Go to the main page (https://rozetka.com.ua/hudojestvennaya-literatura/c4326593/)
	And The product is in stock in the shop
	When Press the button buy (near the product)
	Then New window will be shown
	And The notification "Вы добавили товар в корзину" will be shown
	And The price of the shown product is the same as the price of the product we chose

//BDD 4.2

@positive @state_of_cart
Scenario: Notification "Вы добавили товар в корзину" is shown and
		  the image of the shown product is the same as the image of the product we chose 
		  if we press the button buy

	Given Go to the main page (https://rozetka.com.ua/hudojestvennaya-literatura/c4326593/)
	And The product is in stock in the shop
	When Press the button buy (near the product)
	Then New window will be shown
	And The notification "Вы добавили товар в корзину" will be shown
	And The image of the shown product is the same as the image of the product we chose

//BDD 4.3

@positive @state_of_cart
Scenario: Notification "Вы добавили товар в корзину" is shown and
		  the seller picture of the shown product is the same as the seller picture of the product we chose 
		  if we press the button buy

	Given Go to the main page (https://rozetka.com.ua/hudojestvennaya-literatura/c4326593/)
	And The product is in stock in the shop
	When Press the button buy (near the product)
	Then New window will be shown
	And The notification "Вы добавили товар в корзину" will be shown
	And The seller picture of the shown product is the same as the seller picture of the product we chose