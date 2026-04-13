package com.automationexercise.services.content;

import com.automationexercise.constants.content.HomeConstants;
import com.crowdar.core.actions.ActionManager;

public class HomeService {

    private static String lastRecommendedProductId;

    public static void isHomeLoaded() {
        ActionManager.isVisible(HomeConstants.HOME_CAROUSEL);
    }

    public static void clickNavbarButton(String buttonName) {
        switch (buttonName.trim().toLowerCase()) {
            case "home":
                ActionManager.click(HomeConstants.HOME_BUTTON);
                break;
            case "products":
                ActionManager.click(HomeConstants.PRODUCTS_BUTTON);
                break;
            case "cart":
                ActionManager.click(HomeConstants.CART_BUTTON);
                break;
            case "signup / login":
            case "signup/login":
                ActionManager.click(HomeConstants.SIGNUP_LOGIN_BUTTON);
                break;
            case "test cases":
                ActionManager.click(HomeConstants.TEST_CASES_BUTTON);
                break;
            case "api testing":
                ActionManager.click(HomeConstants.API_TESTING_BUTTON);
                break;
            case "video tutorials":
            case "tutorials":
                ActionManager.click(HomeConstants.TUTORIALS_BUTTON);
                break;
            case "contact us":
            case "contact":
                ActionManager.click(HomeConstants.CONTACT_BUTTON);
                break;
            default:
                throw new IllegalArgumentException("Unknown navbar button: " + buttonName);
        }
    }

    public static void typeSubscribe() {
        ActionManager.setInput(HomeConstants.SUBSCRIBE_INPUT, "example@email.com");
    }

    public static void addFirstRecommendedProductToCart() {
        ActionManager.waitVisibility(HomeConstants.RECOMMENDED_ITEMS_TITLE);
        ActionManager.waitVisibility(HomeConstants.RECOMMENDED_ACTIVE_FIRST_PRODUCT_NAME);

        lastRecommendedProductId = ActionManager.getAttribute(
                HomeConstants.RECOMMENDED_ACTIVE_FIRST_ADD_TO_CART,
                "data-product-id"
        );

        if (lastRecommendedProductId == null || lastRecommendedProductId.trim().isEmpty()) {
            throw new IllegalStateException("Could not capture recommended product id before adding to cart");
        }

        ActionManager.waitClickable(HomeConstants.RECOMMENDED_ACTIVE_FIRST_ADD_TO_CART);
        ActionManager.click(HomeConstants.RECOMMENDED_ACTIVE_FIRST_ADD_TO_CART);
    }

    public static void verifyRecommendedProductIsDisplayedInCart() {
        if (lastRecommendedProductId == null || lastRecommendedProductId.trim().isEmpty()) {
            throw new IllegalStateException("No recommended product id captured to validate in cart");
        }

        String cartRowLocator = String.format(HomeConstants.CART_ROW_BY_PRODUCT_ID, lastRecommendedProductId.trim());
        ActionManager.waitVisibility(cartRowLocator);
    }
}
