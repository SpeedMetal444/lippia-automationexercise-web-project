package com.automationexercise.services.content;

import com.automationexercise.constants.content.HomeConstants;
import com.crowdar.core.actions.ActionManager;

public class HomeService {
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
}
