# Lippia Web Automation – Automation Exercise

This project contains automated web tests built using the Lippia framework (Cucumber + TestNG) targeting the Automation Exercise website.

## Project Overview

The purpose of this project is to simulate real-world QA automation practices by covering end-to-end (E2E) user flows, including both positive and negative scenarios.

Tested application: https://automationexercise.com/

## Test Coverage

The automation suite includes the following scenarios:

- User login (valid and invalid credentials)
- User registration
- Product browsing and selection
- Add and remove products from cart
- Checkout process (E2E)
- UI validations and negative cases

## Tech Stack

- Java
- Lippia Framework
- Cucumber (BDD)
- TestNG
- Maven
- Selenium WebDriver

## Project Structure

    src
     ├── main
     │   └── java
     │       └── (framework core / configuration)
     │
     └── test
         ├── java
         │   └── steps / services / constants
         │
         └── resources
             ├── features
             ├── capabilities
             └── config.properties

## How to Run Tests

Run all tests:

    mvn clean test

Run tests by tag:

    mvn clean test -Dcucumber.filter.tags="@Smoke"

## Key Focus

- Stable and maintainable test design
- Realistic end-to-end scenarios
- Handling dynamic web elements and synchronization
- Clean and scalable automation structure

## Future Improvements

- CI/CD integration (GitHub Actions)
- Improved test reporting
- Data-driven testing
- Cross-browser execution

## Author

Abel Godoy  
QA Automation Tester