Feature: store the last valid quantity of the product when enter valid one
	
	In order to do not remember it myself
	As a customer
	I want the last number of selected items in the cart to be saved when you exit the cart

//BDD 20.1
@positive @state_of_cart
Scenario: the last valid string is stored in the field with quantity of the product 
		   after we enter there a valid string, close cart and open it again
	Given Product is in the cart
	And The cart is open
	When You paste from buffer valid string (integer quantity between 0 and 999) in the field with quantity of the product
	And Press close cart cross
	And Open cart
	Then The product quantity becomes the quantity that we pasted
	
//BDD 20.2
@positive @state_of_cart
Scenario: the last valid string is stored in the field with quantity of the product 
		    after we enter there a valid string, Press "Продолжить покупки" and open it again	
	Given Product is in the cart
	And The cart is open
	When You paste from buffer valid string (integer quantity between 0 and 999) in the field with quantity of the product
	And Press "Продолжить покупки"
	And Open cart
	Then The product quantity becomes the quantity that we pasted

//BDD 20.3
@positive @state_of_cart
Scenario: the last valid string is stored in the field with quantity of the product 
		  after we enter there a valid string, Press "Оформить заказ" and go to the previous page		
	Given Product is in the cart
	And The cart is open
	When You paste from buffer valid string (integer quantity between 0 and 999) in the field with quantity of the product
	And Press "Оформить заказ"
	And Go to the previous page
	Then The product quantity becomes the quantity that we pasted.