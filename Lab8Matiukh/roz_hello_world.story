Scenario: Check basket is empty
Given open schoolbookspage
When open basketpage
Then should be empty
Then close basketpage

Scenario: Order schoolbag number 1
Given open schoolbookspage
When open schoolbagspage
Then should see goods 
Then order number 1
Then continue shopping

Scenario: Check basket isn't empty
When open basketpage
Then should be not empty
Then close basketpage

Scenario: Delete from basket 
When open basketpage
Then should be not empty
Then delete from basket
Then should be empty
Then close basketpage

Scenario: Order schoolbag number 2
Given open schoolbookspage
When open schoolbagspage
Then should see goods 
Then order number 2
Then should be not empty
Then close basketpage

Scenario: Checkout
When open basketpage
Then should be not empty
Then proceed checkout
Then fill form Pupkin bpupkin@yahoo.com 0505000068
Then should see confirm



