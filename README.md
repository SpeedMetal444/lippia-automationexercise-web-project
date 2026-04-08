# AutomationExercise Web Automation

This project contains web UI automated tests for [AutomationExercise](https://automationexercise.com/) using Lippia, Cucumber, TestNG, and Selenium.

## Tech Stack

- Java
- Maven
- Lippia Framework
- Cucumber (BDD)
- TestNG
- Selenium WebDriver
- Extent Reports

## Project Structure

```tree
.
|-- pom.xml
|-- testng.xml
|-- testng-sequential.xml
|-- testng-parallel.xml
`-- src
    |-- main
    |   |-- java
    |   |   `-- com
    |   |       `-- automationexercise
    |   |           `-- reporters
    |   |               |-- CucumberReporter.java
    |   |               `-- TestManagerReporter.java
    |   `-- resources
    |       |-- browsers
    |       |   |-- chromeCapabilities.json
    |       |   |-- chromeCapabilitiesGrid.json
    |       |   `-- firefoxCapabilities.json
    |       |-- config.properties
    |       |-- cucumber.properties
    |       |-- extent.properties
    |       |-- log4j.properties
    |       `-- webdrivermanager.properties
    `-- test
        |-- java
        |   `-- com
        |       `-- automationexercise
        |           |-- constants
        |           |   |-- account
        |           |   |-- common
        |           |   |-- content
        |           |   |-- navigation
        |           |   |-- shopping
        |           |   `-- support
        |           |-- services
        |           |   |-- account
        |           |   |-- common
        |           |   |-- content
        |           |   |-- navigation
        |           |   |-- shopping
        |           |   `-- support
        |           `-- steps
        |               |-- account
        |               |-- common
        |               |-- content
        |               |-- navigation
        |               |-- shopping
        |               `-- support
        `-- resources
            `-- web
                `-- features
                    |-- account
                    |-- content
                    |-- navigation
                    |-- shopping
                    `-- support
```

## Run Tests

Default run:

```bash
mvn clean test
```

Useful executions:

```bash
# Chrome local, sequential (default profile)
mvn clean test -Pchrome,local,sequential

# Firefox local, sequential
mvn clean test -Pfirefox,local,sequential

# Chrome headless, sequential
mvn clean test -PchromeHeadless,local,sequential

# Parallel run
mvn clean test -Pchrome,local,parallel

# Run by tags
mvn clean test -Dcucumber.tags="@Smoke"
```

## Main Configuration Points

- Base URL: `src/main/resources/config.properties`
- Browser capabilities: `src/main/resources/browsers/`
- Cucumber options: `src/main/resources/cucumber.properties`
- Steps glue package: configured in `pom.xml` as `com.automationexercise.steps`

## Functional Coverage

- Authentication
- Home
- Products
- Cart
- Checkout
- Contact
- Test Cases

## Notes

- Features are organized by functional domain.
- Steps, services, and constants are also organized by domain to keep the suite scalable.
- Custom reporters are under `src/main/java/com/automationexercise/reporters/`.
