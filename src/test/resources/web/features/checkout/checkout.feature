@Checkout @Regression
Feature: Checkout - Place Orders, Verify Addresses and Download Invoice

  Background:
    Given The user launches the browser
    When The user navigates to url "http://automationexercise.com"
    Then The user verifies that home page is visible successfully

  @PlaceOrderRegisterDuringCheckout @Candidate @Smoke @E2E
  Scenario: User can register during checkout process
    When The user adds products to cart
    And The user clicks "Cart" button
    Then The user verifies that cart page is displayed
    When The user clicks Proceed To Checkout
    And The user clicks "Register / Login" button
    And The user fills all details in Signup and creates account
    Then The user verifies "ACCOUNT CREATED!" and clicks "Continue" button
    And The user verifies "Logged in as username" at top
    When The user clicks "Cart" button
    And The user clicks "Proceed To Checkout" button
    Then The user verifies Address Details and Review Your Order
    When The user enters description in comment text area and clicks "Place Order"
    And The user enters payment details: Name on Card, Card Number, CVC, Expiration date
    And The user clicks "Pay and Confirm Order" button
    Then The user verifies success message "Your order has been placed successfully!"
    When The user clicks "Delete Account" button
    Then The user verifies "ACCOUNT DELETED!" and clicks "Continue" button

  @PlaceOrderRegisterBeforeCheckout @Candidate @E2E
  Scenario: User can register first then checkout
    When The user clicks on "Signup / Login" button
    And The user fills all details in Signup and creates account
    Then The user verifies "ACCOUNT CREATED!" and clicks "Continue" button
    And The user verifies "Logged in as username" at top
    When The user adds products to cart
    And The user clicks "Cart" button
    Then The user verifies that cart page is displayed
    When The user clicks Proceed To Checkout
    Then The user verifies Address Details and Review Your Order
    When The user enters description in comment text area and clicks "Place Order"
    And The user enters payment details: Name on Card, Card Number, CVC, Expiration date
    And The user clicks "Pay and Confirm Order" button
    Then The user verifies success message "Your order has been placed successfully!"
    When The user clicks "Delete Account" button
    Then The user verifies "ACCOUNT DELETED!" and clicks "Continue" button

  @PlaceOrderLoginBeforeCheckout @Candidate @Smoke @E2E
  Scenario: User can login first then checkout
    When The user clicks on "Signup / Login" button
    And The user fills email, password and clicks "Login" button
    Then The user verifies "Logged in as username" at top
    When The user adds products to cart
    And The user clicks "Cart" button
    Then The user verifies that cart page is displayed
    When The user clicks Proceed To Checkout
    Then The user verifies Address Details and Review Your Order
    When The user enters description in comment text area and clicks "Place Order"
    And The user enters payment details: Name on Card, Card Number, CVC, Expiration date
    And The user clicks "Pay and Confirm Order" button
    Then The user verifies success message "Your order has been placed successfully!"
    When The user clicks "Delete Account" button
    Then The user verifies "ACCOUNT DELETED!" and clicks "Continue" button

  @VerifyAddressDetailsCheckout @Candidate
  Scenario: User can verify address details during checkout
    When The user clicks on "Signup / Login" button
    And The user fills all details in Signup and creates account
    Then The user verifies "ACCOUNT CREATED!" and clicks "Continue" button
    And The user verifies "Logged in as username" at top
    When The user adds products to cart
    And The user clicks "Cart" button
    Then The user verifies that cart page is displayed
    When The user clicks Proceed To Checkout
    Then The user verifies that the delivery address is same address filled at the time registration of account
    And The user verifies that the billing address is same address filled at the time registration of account
    When The user clicks "Delete Account" button
    Then The user verifies "ACCOUNT DELETED!" and clicks "Continue" button

  @DownloadInvoiceAfterPurchase @Candidate @E2E
  Scenario: User can download invoice after purchase
    When The user adds products to cart
    And The user clicks "Cart" button
    Then The user verifies that cart page is displayed
    When The user clicks Proceed To Checkout
    And The user clicks "Register / Login" button
    And The user fills all details in Signup and creates account
    Then The user verifies "ACCOUNT CREATED!" and clicks "Continue" button
    And The user verifies "Logged in as username" at top
    When The user clicks "Cart" button
    And The user clicks "Proceed To Checkout" button
    Then The user verifies Address Details and Review Your Order
    When The user enters description in comment text area and clicks "Place Order"
    And The user enters payment details: Name on Card, Card Number, CVC, Expiration date
    And The user clicks "Pay and Confirm Order" button
    Then The user verifies success message "Your order has been placed successfully!"
    When The user clicks "Download Invoice" button
    Then The user verifies that invoice is downloaded successfully
    And The user clicks "Continue" button
    When The user clicks "Delete Account" button
    Then The user verifies "ACCOUNT DELETED!" and clicks "Continue" button
