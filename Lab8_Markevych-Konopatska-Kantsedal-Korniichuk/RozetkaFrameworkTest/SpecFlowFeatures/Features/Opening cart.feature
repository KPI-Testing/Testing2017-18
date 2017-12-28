Feature:Opening cart

	In order to see my current cart state
	As a customer
	I want to open the cart

@positive @opening_cart @manual
Scenario: Put the cursor on the button cart and be able to click "Перейти в корзину", when there are some products in the cart
	Given There are some products in the cart
	And The cart is closed
	When Put the cursor on the button cart (on the right corner)
	Then You can click on the button "Перейти в корзину" in the appeared window

@positive @opening_cart @manual
Scenario: Put the cursor on the button cart and click "Перейти в корзину", when there are some products in the cart
	Given There are some products in the cart
	And The cart is closed
	When Put the cursor on the button cart (on the right corner)
	And You click on the button "Перейти в корзину" in the appeared window
	Then The cart opens
