@Home @Regression
Feature: Home - Subscription, Recommended Items and Scroll

  Background:
    Given The user navigates to url "http://automationexercise.com"
    And The user verifies that home page is visible successfully

  @SubscriptionHomePage @Candidate
  Scenario: User can subscribe to newsletter from home page
    When The user scrolls down to footer
    And The user verifies text "SUBSCRIPTION"
    And The user enters email address in input and clicks arrow button
    Then The user verifies success message "You have been successfully subscribed!" is visible

  @AddToCartRecommendedItems @Candidate
  Scenario: User can add recommended items to cart
    When The user scrolls to bottom of page
    And The user verifies "RECOMMENDED ITEMS" are visible
    And The user clicks on "Add To Cart" on Recommended product
    And The user clicks on "View Cart" button
    Then The user verifies that product is displayed in cart page

  @ScrollUpWithArrowButton @Candidate
  Scenario: User can scroll up using arrow button
    When The user scrolls down page to bottom
    And The user verifies "SUBSCRIPTION" is visible
    And The user clicks on arrow at bottom right side to move upward
    Then The user verifies that page is scrolled up and "Full-Fledged practice website for Automation Engineers" text is visible on screen

  @ScrollUpWithoutArrowButton @Candidate
  Scenario: User can scroll up without arrow button
    When The user scrolls down page to bottom
    And The user verifies "SUBSCRIPTION" is visible
    And The user scrolls up page to top
    Then The user verifies that page is scrolled up and "Full-Fledged practice website for Automation Engineers" text is visible on screen
