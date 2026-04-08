package com.automationexercise.steps.common;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CommonSteps {

    @Given("^The user navigates to url \"([^\"]*)\"$")
    public void theUserNavigatesToUrl(String url) {
        throw new PendingException();
    }

    @Given("^The user verifies that home page is visible successfully$")
    public void theUserVerifiesThatHomePageIsVisibleSuccessfully() {
        throw new PendingException();
    }

    @Given("^The user clicks on \"([^\"]*)\" button$")
    @When("^The user clicks on \"([^\"]*)\" button$")
    public void theUserClicksOnButton(String buttonName) {
        throw new PendingException();
    }

    @Given("^The user clicks \"([^\"]*)\" button$")
    @When("^The user clicks \"([^\"]*)\" button$")
    public void theUserClicksButton(String buttonName) {
        throw new PendingException();
    }

    @When("^The user verifies that \"([^\"]*)\" is visible$")
    @Then("^The user verifies that \"([^\"]*)\" is visible$")
    public void theUserVerifiesThatIsVisible(String text) {
        throw new PendingException();
    }

    @Then("^The user verifies error \"([^\"]*)\" is visible$")
    public void theUserVerifiesErrorIsVisible(String errorMessage) {
        throw new PendingException();
    }

    @When("^The user verifies success message \"([^\"]*)\" is visible$")
    @Then("^The user verifies success message \"([^\"]*)\" is visible$")
    public void theUserVerifiesSuccessMessageIsVisible(String successMessage) {
        throw new PendingException();
    }

    @When("^The user verifies text \"([^\"]*)\"$")
    public void theUserVerifiesText(String text) {
        throw new PendingException();
    }

    @When("^The user verifies \"([^\"]*)\" is visible$")
    public void theUserVerifiesIsVisible(String text) {
        throw new PendingException();
    }

    @When("^The user verifies \"([^\"]*)\" are visible$")
    public void theUserVerifiesAreVisible(String text) {
        throw new PendingException();
    }

    @When("^The user adds products to cart$")
    public void theUserAddsProductsToCart() {
        throw new PendingException();
    }

    @When("^The user verifies that cart page is displayed$")
    public void theUserVerifiesThatCartPageIsDisplayed() {
        throw new PendingException();
    }
}
