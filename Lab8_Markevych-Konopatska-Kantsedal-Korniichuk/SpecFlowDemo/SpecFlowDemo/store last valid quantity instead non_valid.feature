Feature: store the last valid quantity of the product instead of non-valid one
	
	In order to avoid errors with the number of items in the cart
	As a customer
	I want to be sure that when entering incorrect data, the last correct is stored

//BDD 19.1
@positive @state_of_cart
Scenario:  the last valid string is stored in the field with quantity of the product 
		   after we paste there a non-valid string, close cart and open it again
	Given Product is in the cart
	And The cart is open
	When You paste from buffer non-valid string (for example, "kkoijapi4qtu89u$32984902a;ngklna") in the field with quantity of the product
	And Press close cart cross
	And Open cart
	Then The product quantity is the same, as it was before pasting

//BDD 19.2
@positive @state_of_cart
Scenario:	the last valid string is stored in the field with quantity of the product 
		    after we paste there a non-valid string, Press "Продолжить покупки" and open it again	
	Given Product is in the cart
	And The cart is open
	When You paste from buffer non-valid string (for example, "kkoijapi4qtu89u$32984902a;ngklna") in the field with quantity of the product
	And Press "Продолжить покупки"
	And Open cart
	Then The product quantity is the same, as it was before pasting.

//BDD 19.3
@positive @state_of_cart
Scenario: the last valid string is stored in the field with quantity of the product 
		  after we paste there a non-valid string, Press "Оформить заказ" and go to the previous page		
	Given Product is in the cart
	And The cart is open
	When You paste from buffer non-valid string (for example, "kkoijapi4qtu89u$32984902a;ngklna") in the field with quantity of the product
	And Press "Оформить заказ"
	And Go to the previous page
	Then The product quantity is the same, as it was before pasting

//BDD 21
@positive @state_of_cart
Scenario: the last valid string is stored in the field with quantity of the product 
		  after we enter there a non-valid string
	Given Product is in the cart
	And The cart is open
	When You enter some char (not int value) in the field quantity of product
	Then The quantity of product shouldn't change (the field becomes red for a second)