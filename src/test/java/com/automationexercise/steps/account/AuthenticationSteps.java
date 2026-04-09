package com.automationexercise.steps.account;

import com.automationexercise.services.account.AuthenticationService;
import com.automationexercise.services.common.CommonService;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AuthenticationSteps {

    @When("^The user enters name and email address$")
    public void theUserEntersNameAndEmailAddress() {
        AuthenticationService.registerNameEmail();
    }

    @When("^The user fills details: Title, Name, Email, Password, Date of birth$")
    public void theUserFillsAccountInformationDetails() {
        AuthenticationService.fillAccountPrimaryDetails();
    }

    @When("^The user selects checkbox \"([^\"]*)\"$")
    public void theUserSelectsCheckbox(String checkboxText) {
        AuthenticationService.selectNewsOfferCheckbox(checkboxText);
    }

    @When("^The user fills details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number$")
    public void theUserFillsAddressDetails() {
        AuthenticationService.fillAddressAndContactDetails();
    }

    @Then("^The user verifies that \"([^\"]*)\" is visible and clicks \"([^\"]*)\" button$")
    public void theUserVerifiesThatAccountDeletedIsVisibleAndClicksContinueButton(String text, String buttonText) {
        CommonService.verifyTextVisibility(text);
        CommonService.clickButtonByName(buttonText);
    }

    @When("^The user enters correct email address and password$")
    public void theUserEntersCorrectEmailAddressAndPassword() {
        AuthenticationService.correctLogin();
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
