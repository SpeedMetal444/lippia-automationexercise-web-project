@Contact @Regression
Feature: Contact - Contact Us Form

  Background:
    Given The user navigates to url "http://automationexercise.com"
    And The user verifies that home page is visible successfully

  @ContactUsForm @Candidate @Smoke
  Scenario: User can submit contact form successfully
    When The user clicks on "Contact Us" button
    And The user verifies that "GET IN TOUCH" is visible
    And The user enters name, email, subject and message
    And The user uploads file
    And The user clicks "Submit" button
    And The user clicks OK button on alert
    And The user verifies success message "Success! Your details have been submitted successfully." is visible
    And The user clicks "Home" button
    Then The user verifies that landed to home page successfully
