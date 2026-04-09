@Authentication @Regression
Feature: Authentication - Register, Login and Logout

  Background:
    Given The user navigates to url "http://automationexercise.com"
    And The user verifies that home page is visible successfully
    And The user clicks on "Signup / Login" button

  @RegisterUser @Automated @Smoke @E2E
  Scenario: Register a new user successfully
    When The user verifies that "New User Signup!" is visible
    And The user enters name and email address
    And The user clicks "Signup" button
    And The user verifies that "ENTER ACCOUNT INFORMATION" is visible
    And The user fills details: Title, Name, Email, Password, Date of birth
    And The user selects checkbox "Sign up for our newsletter!"
    And The user selects checkbox "Receive special offers from our partners!"
    And The user fills details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    And The user clicks "Create Account" button
    And The user verifies that "ACCOUNT CREATED!" is visible
    And The user clicks "Continue" button
    And The user verifies that "Logged in as username" is visible
    And The user clicks "Delete Account" button
    Then The user verifies that "ACCOUNT DELETED!" is visible and clicks "Continue" button

  @LoginCorrectCredentials @Automated @Smoke
  Scenario: Login with correct credentials successfully
    When The user verifies that "Login to your account" is visible
    And The user enters correct email address and password
    And The user clicks "Login" button
    Then The user verifies that "Logged in as username" is visible

  @LoginIncorrectCredentials @Automated
  Scenario: Login fails with incorrect credentials
    When The user verifies that "Login to your account" is visible
    And The user enters incorrect email address and password
    And The user clicks "Login" button
    Then The user verifies error "Your email or password is incorrect!" is visible

  @LogoutUser @Automated
  Scenario: User can logout successfully
    When The user verifies that "Login to your account" is visible
    And The user enters correct email address and password
    And The user clicks "Login" button
    And The user verifies that "Logged in as username" is visible
    And The user clicks "Logout" button
    Then The user verifies that user is navigated to login page

  @RegisterExistingEmail @Automated
  Scenario: Registration fails with existing email
    When The user verifies that "New User Signup!" is visible
    And The user enters name and already registered email address
    And The user clicks "Signup" button
    Then The user verifies error "Email Address already exist!" is visible
