Feature: Quantity_field
	In order to regulate the number of products in the cart
	As a customer
	I want to be able to work with the field of quantity of the selected product in the cart

@positive @state_of_cart
Scenario Outline: Entering_0_in_quantity_field
	Given Product is in the cart with quantity <quantity>
	When You enter <enterquantity> in the <number> field with number of the product
	Then The product shoud be deleted from the cart

	Examples: 
	| quantity | enterquantity | number |
	| 1        | 0             | 1      |