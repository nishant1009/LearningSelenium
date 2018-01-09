Feature: Verify Order Checkout

  Scenario: Verify User is able to checkout using Bank Wire Payment
    Given User is logged in Application
    When User adds a product in basket
    And initiates the checkout process using bankwire payment method
    Then Order should be placed sucessfully
    And placed order should be visible in My accounts Orders details tab
