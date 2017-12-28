Feature: Button Buy

	In order to buy it later
	As a customer
	I want to add the product that I chose to the cart


	@positive @state of cart
Scenario Outline: The name of the shown product is the same as the name of the product we chose 
		  if we press the button buy
	
	Given Product is in the cart with quantity <quantity>
	Then The name of the shown product is the same as the name of the product we chose

	Examples: 
	| quantity |
	| 3        |

	@positive @state_of_cart
Scenario Outline: The price of the shown product is the same as the price of the product we chose 
		  if we press the button buy

	Given Product is in the cart with quantity <quantity>
	Then The price of the shown product is the same as the price of the product we chose

	Examples: 
	| quantity |
	| 3        |


	@positive @state_of_cart
Scenario Outline: The seller picture of the shown product is the same as the seller picture of the product we chose 
		  if we press the button buy

	Given Product is in the cart with quantity <quantity>
	Then The seller picture of the shown product is the same as the seller picture of the product we chose

	Examples: 
	| quantity |
	| 3        |