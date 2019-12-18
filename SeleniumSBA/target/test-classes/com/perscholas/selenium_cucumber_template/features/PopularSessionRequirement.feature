Feature: Add items to cart

Scenario: After you add an item to cart, the cart should have the correct number of items
Given the user navigates to the online store
When the user clicks on an item
Then the page for that item should open
When you add an item to cart
Then the cart should now have that item
When you add a second item to cart
Then the cart should have both items