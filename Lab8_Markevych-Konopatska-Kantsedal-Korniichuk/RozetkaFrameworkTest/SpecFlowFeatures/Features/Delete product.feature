Feature: Delete product

	In order to not buy it
	As a customer
	I want to delete product from the cart
	
@positive @delete_product
Scenario Outline: Be able to click cross near product in the cart
	Given Product is in the cart with quantity <quantity>
	Then You can click cross near product

	Examples: 
	| quantity |
	| 1        |
