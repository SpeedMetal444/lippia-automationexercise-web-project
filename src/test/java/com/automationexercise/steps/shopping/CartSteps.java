package com.automationexercise.steps.shopping;

import com.automationexercise.services.shopping.CartService;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CartSteps {

    @When("^The user hovers over first product and clicks \"Add to cart\"$")
    public void theUserHoversOverFirstProductAndClicksAddToCart() {
        CartService.addFirstProduct();
    }

    @When("^The user hovers over second product and clicks \"Add to cart\"$")
    public void theUserHoversOverSecondProductAndClicksAddToCart() {
        CartService.addSecondProduct();
    }

    @Then("^The user verifies that both products are added to Cart$")
    public void theUserVerifiesThatBothProductsAreAddedToCart() {
        CartService.verifyAddedProductsInCart();
    }

    @Then("^The user verifies their prices, quantity and total price$")
    public void theUserVerifiesTheirPricesQuantityAndTotalPrice() {
        CartService.verifyProductsDetailsInCart();
    }

    @When("^The user clicks \"View Product\" for any product on home page$")
    public void theUserClicksViewProductForAnyProductOnHomePage() {
        throw new PendingException();
    }

    @When("^The user verifies that product detail is opened$")
    public void theUserVerifiesThatProductDetailIsOpened() {
        throw new PendingException();
    }

    @When("^The user increases quantity to 4$")
    public void theUserIncreasesQuantityTo4() {
        throw new PendingException();
    }

    @When("^The user clicks \"X\" button corresponding to particular product$")
    public void theUserClicksXButtonCorrespondingToParticularProduct() {
        throw new PendingException();
    }

    @Then("^The user verifies that product is removed from the cart$")
    public void theUserVerifiesThatProductIsRemovedFromTheCart() {
        throw new PendingException();
    }

    @When("^The user adds those products to cart$")
    public void theUserAddsThoseProductsToCart() {
        throw new PendingException();
    }

    @When("^The user verifies that products are visible in cart$")
    public void theUserVerifiesThatProductsAreVisibleInCart() {
        throw new PendingException();
    }

    @When("^The user clicks on \"Signup / Login\" button and submits login details$")
    public void theUserClicksOnSignupLoginButtonAndSubmitsLoginDetails() {
        throw new PendingException();
    }

    @When("^The user goes to Cart page$")
    public void theUserGoesToCartPage() {
        throw new PendingException();
    }

    @Then("^The user verifies that those products are visible in cart after login as well$")
    public void theUserVerifiesThatThoseProductsAreVisibleInCartAfterLoginAsWell() {
        throw new PendingException();
    }
}
