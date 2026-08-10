package com.automationexercise.steps.common;

import com.automationexercise.services.common.CommonService;
import com.automationexercise.services.common.NavigationService;
import com.automationexercise.services.content.HomeService;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CommonSteps {

    @Given("^The user navigates to url \"([^\"]*)\"$")
    public void theUserNavigatesToUrl(String url) {
        NavigationService.navigatesToUrl(url);
    }

    @Given("^The user verifies that home page is visible successfully$")
    public void theUserVerifiesThatHomePageIsVisibleSuccessfully() {
        HomeService.isHomeLoaded();
    }

    @When("^The user clicks on \"([^\"]*)\" button$")
    public void theUserClicksOnButton(String buttonName) {
        HomeService.clickNavbarButton(buttonName);
    }

    @When("^The user clicks \"([^\"]*)\" button$")
    public void theUserClicksButton(String buttonName) {
        CommonService.clickButtonByName(buttonName);
    }

    @Then("^The user verifies that \"([^\"]*)\" is visible$")
    public void theUserVerifiesThatIsVisible(String text) {
        CommonService.verifyTextVisibility(text);
    }

    @Then("^The user verifies error \"([^\"]*)\" is visible$")
    public void theUserVerifiesErrorIsVisible(String errorMessage) {
        CommonService.verifyTextVisibility(errorMessage);;
    }

    @Then("^The user verifies success message \"([^\"]*)\" is visible$")
    public void theUserVerifiesSuccessMessageIsVisible(String successMessage) {
        CommonService.verifyTextVisibility(successMessage);
    }

    @When("^The user verifies text \"([^\"]*)\"$")
    public void theUserVerifiesText(String text) {
        CommonService.verifyTextVisibility(text);
    }

    @When("^The user verifies \"([^\"]*)\" is visible$")
    public void theUserVerifiesIsVisible(String text) {
        CommonService.verifyTextVisibility(text);
    }

    @When("^The user verifies \"([^\"]*)\" are visible$")
    public void theUserVerifiesAreVisible(String text) {
        CommonService.verifyTextVisibility(text);
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
