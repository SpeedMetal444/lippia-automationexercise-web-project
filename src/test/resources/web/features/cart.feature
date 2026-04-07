@Cart @Regression
Feature: Cart - Add, Remove, Persist and Subscribe

  Background:
    Given The user launches the browser
    When The user navigates to url "http://automationexercise.com"
    Then The user verifies that home page is visible successfully

  @SubscriptionCartPage @Candidate
  Scenario: User can subscribe to newsletter from cart page
    When The user clicks "Cart" button
    And The user scrolls down to footer
    Then The user verifies text "SUBSCRIPTION"
    When The user enters email address in input and clicks arrow button
    Then The user verifies success message "You have been successfully subscribed!" is visible

  @AddProductsToCart @Candidate @Smoke
  Scenario: User can add multiple products to cart
    When The user clicks on "Products" button
    And The user hovers over first product and clicks "Add to cart"
    And The user clicks "Continue Shopping" button
    And The user hovers over second product and clicks "Add to cart"
    And The user clicks "View Cart" button
    Then The user verifies that both products are added to Cart
    And The user verifies their prices, quantity and total price

  @VerifyProductQuantityCart @Candidate
  Scenario: User can add product with specific quantity to cart
    When The user clicks "View Product" for any product on home page
    Then The user verifies that product detail is opened
    When The user increases quantity to 4
    And The user clicks "Add to cart" button
    And The user clicks "View Cart" button
    Then The user verifies that product is displayed in cart page with exact quantity

  @RemoveProductsFromCart @Candidate
  Scenario: User can remove products from cart
    When The user adds products to cart
    And The user clicks "Cart" button
    Then The user verifies that cart page is displayed
    When The user clicks "X" button corresponding to particular product
    Then The user verifies that product is removed from the cart

  @SearchProductsVerifyCartAfterLogin @Candidate @E2E
  Scenario: User can search products and verify cart after login
    When The user clicks on "Products" button
    Then The user verifies that user is navigated to ALL PRODUCTS page successfully
    When The user enters product name in search input and clicks search button
    Then The user verifies that "SEARCHED PRODUCTS" is visible
    And The user verifies that all the products related to search are visible
    When The user adds those products to cart
    And The user clicks "Cart" button
    Then The user verifies that products are visible in cart
    When The user clicks on "Signup / Login" button and submits login details
    And The user goes to Cart page
    Then The user verifies that those products are visible in cart after login as well
