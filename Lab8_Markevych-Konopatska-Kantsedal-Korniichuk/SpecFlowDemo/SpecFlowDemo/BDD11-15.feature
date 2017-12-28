Feature: product deletion button

	In order to be able to regulate the contents of the cart
	As a customer
	I want to be able to choose options to put item into Wish list, or to delete it from cart, or to cancel my actions

//BDD 11
@positive @state_of_cart
Scenario: The new window "Список желаний, удалить без сохранения, отмена" is shown after we press X near the product in cart 
	Given Product is in the cart
	And The cart is open
	When Press X near the product
	Then The new window "Список желаний, удалить без сохранения, отмена" will be shown

//BDD 12
@positive @state_of_cart
Scenario:		
	Given Product is in the cart
	And The cart is empty
	And The cart is open
	And Press X near the product
	And The new window "Список желаний, удалить без сохранения, отмена" is shown
	When Press "Удалить без сохранения" in the new window
	Then There will be notification "Корзина пуста"

//BDD 13
@positive @state_of_cart
Scenario:		
	Given Product is in the cart
	And The cart is empty
	And The cart is open
	And Press X near the product
	And The new window "Список желаний, удалить без сохранения, отмена" is shown
	When Press "Переместить в список желаний" in the new window
	And There will be notification "Корзина пуста"

//BDD 14
@positive @state_of_cart
Scenario:		
	Given Product is in the cart
	And The cart is open
	And Press X near the product
	And The new window "Список желаний, удалить без сохранения, отмена" is shown
	When Press "Отмена" in the new window
	Then There is still only one product (the one we chosed) and its quantity is 1


		

