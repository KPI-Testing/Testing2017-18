//BDD 4
Feature: Button Buy

	In order to buy it later
	As a customer
	I want to add the product that I chose to the cart


	//such test may already exist


@positive @state of cart 
Scenario: Notification "Вы добавили товар в корзину" is shown 
	
	Given Go to the main page (https://rozetka.com.ua/hudojestvennaya-literatura/c4326593/)
	When Press the button buy (near the product)
	Then The notification Вы добавили товар в корзину will be shown
	

@positive @state of cart
Scenario: The name of the shown product is the same as the name of the product we chose 
		  if we press the button buy
	
	Given Product is in the cart with quantity <quantity>
	Then The name of the shown product is the same as the name of the product we chose

//BDD 4.1

@positive @state_of_cart
Scenario: The price of the shown product is the same as the price of the product we chose 
		  if we press the button buy

	Given Product is in the cart with quantity <quantity>
	Then The price of the shown product is the same as the price of the product we chose

//BDD 4.2

@positive @state_of_cart
Scenario: The image of the shown product is the same as the image of the product we chose 
		  if we press the button buy

	Given Product is in the cart with quantity <quantity>
	Then The image of the shown product is the same as the image of the product we chose

//BDD 4.3

@positive @state_of_cart
Scenario: The seller picture of the shown product is the same as the seller picture of the product we chose 
		  if we press the button buy

	Given Product is in the cart with quantity <quantity>
	Then The seller picture of the shown product is the same as the seller picture of the product we chose

	Examples: 
	| quantity |
	| 1        |