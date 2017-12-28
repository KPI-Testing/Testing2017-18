Feature: 
	In order to keep my order right
	As a customer
	I want the number of selected products to be kept in the cart 
	 //тут тре ше це одне 

//BDD 27.1
@positive @state_of_cart
Scenario: cart closes when there is product with valid quantity and you press "Продолжить покупки"
	Given Product is in the cart
	And quantity of product is n (valid)
	And The cart is open
	When Press "Продолжить покупки"
	Then The window of the cart will be closed

//BDD 27.2
@positive @state_of_cart
Scenario: cart contains the same valid quantity of prod when we reopen cart after pressing "Продолжить покупки"
	Given Product is in the cart
	And quantity of product is n (valid)
	And The cart is open
	When Press "Продолжить покупки"
	And Open the cart after the window of the cart is closed.
	Then Product is in the cart
	And The quantity of prod should be n
