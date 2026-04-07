# Lippia Web Automation – Automation Exercise

This project contains automated web tests built using the Lippamente framework (Cucumber + TestNG) targeting the Automation Exercise website.

## Project Overview

The purpose of this project is to simulate real-world QA automation practices by covering end-to-end (E2E) user flows, including both positive and negative scenarios.

Tested application: https://automationexercise.com/

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
     │   ├── java
     │   │   └── lippia
     │   │       └── web
     │   │           ├── constants/    (Project constants)
     │   │           ├── services/     (Page objects / Services)
     │   │           ├── steps/        (Cucumber step definitions)
     │   │           └── reporters/    (Custom reporters)
     │   └── resources
     │       ├── browsers/             (Browser capabilities)
     │       └── (config/properties)
     │
     └── test
         └── resources
             └── web
                 └── features/        (Gherkin .feature files)

## How to Run Tests

Run all tests:

    mvn clean test

Run tests by tag:

    mvn clean test -Dcucumber.filter.tags="@Smoke"

## Key Focus

- Stable and maintainable test design
- Scalable automation structure
- Clean and reusable code

## Future Improvements

- CI/CD integration (GitHub Actions)
- Improved test reporting
- Data-driven testing
- Cross-browser execution

## Author

Abel Godoy  
QA Automation Tester