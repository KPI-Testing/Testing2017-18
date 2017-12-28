Feature: Advertising
	In order to read more information
	As a customer
	I want to go to the advertising page
	
@positive @advertising
Scenario: Correct transition to the advertisement page after clicking on the advertisement
	Given The cart is open
	When You click on any of the ads
	Then You are on the relevant ad page

