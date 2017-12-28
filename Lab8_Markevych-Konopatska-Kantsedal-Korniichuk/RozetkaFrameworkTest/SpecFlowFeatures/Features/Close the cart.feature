Feature: Close the cart

	In order to continue shopping
	As a customer
	I want to close the cart
	
	@positive @close_the_cart
	Scenario: Close the cart by clicking cross
	Given The cart is open
	When You click closing cross on the right corner
	Then The window of the cart will be closed
