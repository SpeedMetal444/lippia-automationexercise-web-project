@Products @Regression
Feature: Products - Browse, Search, Categories, Brands and Reviews

  Background:
    Given The user launches the browser
    And The user navigates to url "http://automationexercise.com"
    And The user verifies that home page is visible successfully

  @VerifyAllProductsAndDetails @Candidate @Smoke
  Scenario: User can view all products and product details
    When The user clicks on "Products" button
    And The user verifies that user is navigated to ALL PRODUCTS page successfully
    And The user verifies that products list is visible
    And The user clicks on "View Product" of first product
    Then The user verifies that user is landed to product detail page
    And The user verifies that detail is visible: product name, category, price, availability, condition, brand

  @SearchProduct @Candidate @Smoke
  Scenario: User can search for products
    When The user clicks on "Products" button
    And The user verifies that user is navigated to ALL PRODUCTS page successfully
    And The user enters product name in search input and clicks search button
    Then The user verifies that "SEARCHED PRODUCTS" is visible
    And The user verifies that all the products related to search are visible

  @ViewCategoryProducts @Candidate
  Scenario: User can view products by category
    When The user verifies that categories are visible on left side bar
    And The user clicks on "Women" category
    And The user clicks on any category link under "Women" category
    And The user verifies that category page is displayed and confirms text "WOMEN - TOPS PRODUCTS"
    And The user clicks on any sub-category link of "Men" category on left side bar
    Then The user verifies that user is navigated to that category page

  @ViewBrandProducts @Candidate
  Scenario: User can view products by brand
    When The user clicks on "Products" button
    And The user verifies that Brands are visible on left side bar
    And The user clicks on any brand name
    And The user verifies that user is navigated to brand page and brand products are displayed
    And The user clicks on any other brand link on left side bar
    Then The user verifies that user is navigated to that brand page and can see products

  @AddReviewOnProduct @Candidate
  Scenario: User can add review on product
    When The user clicks on "Products" button
    And The user verifies that user is navigated to ALL PRODUCTS page successfully
    And The user clicks on "View Product" button
    And The user verifies that "Write Your Review" is visible
    And The user enters name, email and review
    And The user clicks "Submit" button
    Then The user verifies success message "Thank you for your review."
