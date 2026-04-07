@Contact @Regression
Feature: Contact - Contact Us Form

  Background:
    Given The user launches the browser
    When The user navigates to url "http://automationexercise.com"
    Then The user verifies that home page is visible successfully

  @ContactUsForm @Candidate @Smoke
  Scenario: User can submit contact form successfully
    When The user clicks on "Contact Us" button
    Then The user verifies that "GET IN TOUCH" is visible
    When The user enters name, email, subject and message
    And The user uploads file
    And The user clicks "Submit" button
    And The user clicks OK button on alert
    Then The user verifies success message "Success! Your details have been submitted successfully." is visible
    When The user clicks "Home" button
    Then The user verifies that landed to home page successfully
