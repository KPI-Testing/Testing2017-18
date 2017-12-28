Feature: Opening Order Processing
	In order to make my order
	As a customer
	I want to be able to switch from the cart immediately to ordering


@positive
Scenario Outline: The order processing window opens after pressing "Оформление заказа" in cart with valid product quantity 
	Given Product is in the cart with quantity <quantity>
	When Press Оформление заказа
	Then The order processing window opens
	
	Examples:
	| quantity |
	| 3        |