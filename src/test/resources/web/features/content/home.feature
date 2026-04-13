@Home @Regression
Feature: Home - Subscription, Recommended Items and Scroll

  Background:
    Given The user navigates to url "http://automationexercise.com"
    And The user verifies that home page is visible successfully

  @SubscriptionHomePage @Automated
  Scenario: User can subscribe to newsletter from home page
    When The user scrolls down to the footer
    And The user verifies "SUBSCRIPTION" is visible
    And The user enters email address in input and clicks arrow button
    Then The user verifies success message "You have been successfully subscribed!" is visible

  @AddToCartRecommendedItems @Automated
  Scenario: User can add recommended items to cart
    When The user scrolls down to the bottom
    And The user verifies "RECOMMENDED ITEMS" are visible
    And The user clicks "Add To Cart" on Recommended product
    And The user clicks "View Cart" button
    Then The user verifies that product is displayed in cart page

  @ScrollUpWithArrowButton @Automated
  Scenario: User can scroll up using arrow button
    When The user scrolls down to the bottom
    And The user verifies "SUBSCRIPTION" is visible
    And The user clicks on the arrow at bottom right side to move upward
    Then The user verifies that page is scrolled up and "Full-Fledged practice website for Automation Engineers" text is visible on screen

  @ScrollUpWithoutArrowButton @Automated
  Scenario: User can scroll up without arrow button
    When The user scrolls down to the bottom
    And The user verifies "SUBSCRIPTION" is visible
    And The user scrolls up to the top
    Then The user verifies that page is scrolled up and "Full-Fledged practice website for Automation Engineers" text is visible on screen
