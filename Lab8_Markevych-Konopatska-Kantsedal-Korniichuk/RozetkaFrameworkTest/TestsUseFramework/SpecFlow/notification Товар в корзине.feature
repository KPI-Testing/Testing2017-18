Feature: Notification "Товар в корзине"

	In order to not add it again
	As a customer
	I want to see if products are already in the cart

//BDD 5.2
@positive
Scenario: Notification "Товар в корзине" is shown after we buy the product and close the window
	Given Go to the main page (https://rozetka.com.ua/hudojestvennaya-literatura/c4326593/)
	And The product is in stock in the shop
	When Press the button buy (near the product)
	And Press close the window (in the window that appeared)
	Then There will be the notification "Товар в корзине" (on the page of the product)

//BDD 8
@positive 
Scenario: Notification "Товар в корзине" is shown after we buy the product, close the window, go to main page 
		  and hover the cursor over the product that was just added to the cart
	Given Go to the main page (https://rozetka.com.ua/hudojestvennaya-literatura/c4326593/)
	And The product with some name is in stock in the shop
	And Press the button buy (near the product)
	And Press close the window (in the window that appeared)
	And Press go back on the main page(https://rozetka.com.ua/hudojestvennaya-literatura/c4326593/)
	When Hover the cursor over the product that we just added to the cart
	Then There will be notification "Товар в корзине" near this product
