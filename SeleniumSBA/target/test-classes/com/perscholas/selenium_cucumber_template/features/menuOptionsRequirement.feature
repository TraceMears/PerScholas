Feature: Navigate the menu and add an item to the cart

Scenario: Use the menu to reach the correct category, then add item to cart
Given user navigates to the online store
When you use navigation menu to reach evening dresses
Then you will be on the evening dresses page
When you add printed dress to the cart
Then printed dress should be in cart