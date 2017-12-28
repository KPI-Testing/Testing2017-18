Feature: regulation of the quantity of products in the cart

	In order to regulate the number of products in the cart
	As a customer
	I want to be able to work with the field of quantity of the selected product in the cart

	//BDD 22
@positive @state_of_cart
Scenario: increase by one the volid quantity of the product in cart by pressing plus
	Given Product is in the cart
	And quantity of product is n (valid)
	And The cart is open
	When Press plus
	Then The quantity of product should be n+1

//BDD 23
@positive @state_of_cart
Scenario: decrease by one the volid quantity of the product in cart by pressing minus
	Given Product is in the cart
	And quantity of product is n (valid and greatet than or equal to 2).
	And The cart is open
	When Press minus
	Then The quantity of prod should be n-1
