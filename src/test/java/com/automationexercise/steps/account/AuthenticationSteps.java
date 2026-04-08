package com.automationexercise.steps.account;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AuthenticationSteps {

    @When("^The user enters name and email address$")
    public void theUserEntersNameAndEmailAddress() {
        throw new PendingException();
    }

    @When("^The user fills details: Title, Name, Email, Password, Date of birth$")
    public void theUserFillsAccountInformationDetails() {
        throw new PendingException();
    }

    @When("^The user selects checkbox \"([^\"]*)\"$")
    public void theUserSelectsCheckbox(String checkboxText) {
        throw new PendingException();
    }

    @When("^The user fills details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number$")
    public void theUserFillsAddressDetails() {
        throw new PendingException();
    }

    @Then("^The user verifies that \"ACCOUNT DELETED!\" is visible and clicks \"Continue\" button$")
    public void theUserVerifiesThatAccountDeletedIsVisibleAndClicksContinueButton() {
        throw new PendingException();
    }

    @When("^The user enters correct email address and password$")
    public void theUserEntersCorrectEmailAddressAndPassword() {
        throw new PendingException();
    }

    @When("^The user enters incorrect email address and password$")
    public void theUserEntersIncorrectEmailAddressAndPassword() {
        throw new PendingException();
    }

    @Then("^The user verifies that user is navigated to login page$")
    public void theUserVerifiesThatUserIsNavigatedToLoginPage() {
        throw new PendingException();
    }

    @When("^The user enters name and already registered email address$")
    public void theUserEntersNameAndAlreadyRegisteredEmailAddress() {
        throw new PendingException();
    }
}
