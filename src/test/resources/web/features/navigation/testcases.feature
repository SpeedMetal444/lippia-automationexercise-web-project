@TestCases @Regression
Feature: Test Cases - Verify Test Cases Page

  Background:
    Given The user navigates to url "http://automationexercise.com"
    And The user verifies that home page is visible successfully

  @VerifyTestCasesPage @Candidate
  Scenario: User can navigate to Test Cases page
    When The user clicks on "Test Cases" button
    Then The user verifies that user is navigated to test cases page successfully
