Feature: SpecFlowFeature1

Scenario: Filter by price
	Given I am on the books page
	When I filter items by price from 10 to 200
	Then first item price is inside limits