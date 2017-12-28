Feature: 
	In order to make my order
	As a customer
	I want to be able to switch from the cart immediately to ordering

	//BDD 28
@positive
Scenario: The order processing window opens after pressing "Оформление заказа" in cart with valid product quantity 
	Given Product is in the cart
	And quantity of product is n (valid)
	And The cart is open
	When Press "Оформление заказа"
	Then The order processing window opens
