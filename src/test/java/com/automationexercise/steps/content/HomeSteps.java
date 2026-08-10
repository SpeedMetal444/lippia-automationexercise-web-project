package com.automationexercise.steps.content;

import com.automationexercise.services.common.CommonService;
import com.automationexercise.services.content.HomeService;
import com.automationexercise.services.shopping.CartService;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomeSteps {

    @When("^The user scrolls down to the footer$")
    public void theUserScrollsDownToFooter() {
        CommonService.scrollToFooter();
    }

    @When("^The user enters email address in input and clicks arrow button$")
    public void theUserEntersEmailAddressInInputAndClicksArrowButton() {
        HomeService.typeSubscribe();
        CommonService.clickButtonByName("SUBSCRIBE");
    }

    @When("^The user scrolls down to the bottom$")
    public void theUserScrollsToBottomOfPage() {
        CommonService.scrollToBottom();
    }

    @When("^The user clicks \"Add to cart\" on Recommended product$")
    public void theUserClicksOnAddToCartOnRecommendedProduct() {
        CartService.addFirstRecommendedProductToCart();
    }

    @Then("^The user verifies that product is displayed in cart page$")
    public void theUserVerifiesThatProductIsDisplayedInCartPage() {
        CartService.verifyRecommendedProductIsDisplayedInCart();
    }

    @When("^The user clicks on the arrow at bottom right side to move upward$")
    public void theUserClicksOnArrowAtBottomRightSideToMoveUpward() {
        CommonService.clickButtonByName("Scroll upward");
    }

    @Then("^The user verifies that page is scrolled up and \"([^\"]*)\" text is visible on screen$")
    public void theUserVerifiesThatPageIsScrolledUpAndTextIsVisibleOnScreen(String expectedText) {
        CommonService.verifyTextVisibility(expectedText);
    }

    @When("^The user scrolls up to the top$")
    public void theUserScrollsUpPageToTop() {
        CommonService.scrollToTop();
    }
}
