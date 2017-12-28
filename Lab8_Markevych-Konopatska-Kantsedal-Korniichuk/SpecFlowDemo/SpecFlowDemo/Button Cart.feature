//BDD 3
Feature: Button Cart   

	In order to know which product I have already chosen
	As a customer
	I want to check the status of the shopping cart without going to another page

@positive @state_of_cart

Scenario: Notification "Cart is empty" is shown, if the cart is empty and we hover the cursor over button cart  
	Given Go to the main page (https://rozetka.com.ua/hudojestvennaya-literatura/c4326593/)
	And You haven't made any purchases yet
	When Put the cursor on the button cart (on the right corner)
	Then New window with the notification "Ваша корзина пуста" will be shown
