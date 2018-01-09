Feature: Verify my account functions

	Scenario: Verify User is able to see his oders in Order History and Details Tab
		Given User is logged in Applicaon
		When User navigates to My Accounts Order details tab
		Then User should see placed order details
		
		Scenario: Verify User is able to see the added address
		Given User is logged in Applicaon
		When User tries to navigate to My Account Address tab
		Then Added address should be shown correctly
		
		Scenario: Verify user is able to update existing address
			Given User is logged in Applicaon
			And Users address exists
			When User tries to update the existing address
			Then address should be updated successfully
			
		Scenario: Verify User is able to save item to his whislist
			Given User is logged in Applicaon
			When User adds a item to his whishlist
			Then item should be added to his wishlist successfully
			