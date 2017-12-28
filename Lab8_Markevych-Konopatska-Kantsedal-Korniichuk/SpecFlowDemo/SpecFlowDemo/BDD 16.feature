Feature: 
	In order to regulate the number of products in the cart
	As a customer
	I want to be able to work with the field of quantity of the selected product in the cart

//BDD 16
@positive @state_of_cart
Scenario:
	Given Product is in the basket
	And The basket is open
	When You enter "0" in the field with number of the product
	And Press enter
	Then The product shoud be delete from the basket (There will be notification "Корзина пуста")