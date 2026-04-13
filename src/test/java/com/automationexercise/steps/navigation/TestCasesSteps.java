package com.automationexercise.steps.navigation;

import com.automationexercise.services.common.CommonService;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;

public class TestCasesSteps {

    @Then("^The user verifies that user is navigated to test cases page successfully$")
    public void theUserVerifiesThatUserIsNavigatedToTestCasesPageSuccessfully() {
        CommonService.verifyTextVisibility("Below is the list of test Cases for you to practice the Automation. Click on the scenario for detailed Test Steps:");
    }
}
