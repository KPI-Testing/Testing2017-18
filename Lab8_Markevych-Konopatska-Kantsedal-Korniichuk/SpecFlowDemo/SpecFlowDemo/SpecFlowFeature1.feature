
Feature: Button Cart
	In order to know which product I have already chosen
	As a customer
    I want to check the status of the shopping cart 


@positive @state_of_cart
Scenario: Empty cart
	Given Go to the main page (https://rozetka.com.ua/hudojestvennaya-literatura/c4326593/)
	And You haven't made any purchases yet
	When Press the button cart (on the right corner)
	Then New window with the notification "Корзина пуста" will be opened

