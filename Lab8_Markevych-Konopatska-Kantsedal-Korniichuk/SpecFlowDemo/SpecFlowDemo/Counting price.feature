Feature: counting price

	In order to not count it myself
	As a customer
	I want the quantity and the price of the product in the cart to be counted automatically

//BDD 29.1
@positive @state_of_cart
Scenario: Counting price of product by multiply price of 1 product on entereed valid quantity
	Given Product is in the cart
	And quantity of product is n (valid)
	And The cart is open
	When You enter valid quantity k in the field with quantity of the product
	And Press enter
	Then The quantity of product should be n
	And The price of product should be k*price of 1 product

//BDD 29.2
@positive @state_of_cart
Scenario: Counting price of product by multiply price of 1 product on pased from buffer valid quantity		
	Given Product is in the cart
	And quantity of product is n (valid)
	And The cart is open
	When You put valid quantity k from the buffer in the field with quantity of the product
	And Press enter
	Then The quantity of product should be n
	And The price of product should be k*price of 1 product
