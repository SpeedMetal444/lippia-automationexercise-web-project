@Authentication @Regression
Feature: Authentication - Register, Login and Logout

  Background:
    Given The user launches the browser
    When The user navigates to url "http://automationexercise.com"
    Then The user verifies that home page is visible successfully
    When The user clicks on "Signup / Login" button

  @RegisterUser @Candidate @Smoke @E2E
  Scenario: Register a new user successfully
    Then The user verifies that "New User Signup!" is visible
    When The user enters name and email address
    And The user clicks "Signup" button
    Then The user verifies that "ENTER ACCOUNT INFORMATION" is visible
    When The user fills details: Title, Name, Email, Password, Date of birth
    And The user selects checkbox "Sign up for our newsletter!"
    And The user selects checkbox "Receive special offers from our partners!"
    And The user fills details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    And The user clicks "Create Account" button
    Then The user verifies that "ACCOUNT CREATED!" is visible
    When The user clicks "Continue" button
    Then The user verifies that "Logged in as username" is visible
    When The user clicks "Delete Account" button
    Then The user verifies that "ACCOUNT DELETED!" is visible and clicks "Continue" button

  @LoginCorrectCredentials @Candidate @Smoke
  Scenario: Login with correct credentials successfully
    Then The user verifies that "Login to your account" is visible
    When The user enters correct email address and password
    And The user clicks "Login" button
    Then The user verifies that "Logged in as username" is visible
    When The user clicks "Delete Account" button
    Then The user verifies that "ACCOUNT DELETED!" is visible

  @LoginIncorrectCredentials @Candidate
  Scenario: Login fails with incorrect credentials
    Then The user verifies that "Login to your account" is visible
    When The user enters incorrect email address and password
    And The user clicks "Login" button
    Then The user verifies error "Your email or password is incorrect!" is visible

  @LogoutUser @Candidate
  Scenario: User can logout successfully
    Then The user verifies that "Login to your account" is visible
    When The user enters correct email address and password
    And The user clicks "Login" button
    Then The user verifies that "Logged in as username" is visible
    When The user clicks "Logout" button
    Then The user verifies that user is navigated to login page

  @RegisterExistingEmail @Candidate
  Scenario: Registration fails with existing email
    Then The user verifies that "New User Signup!" is visible
    When The user enters name and already registered email address
    And The user clicks "Signup" button
    Then The user verifies error "Email Address already exist!" is visible
