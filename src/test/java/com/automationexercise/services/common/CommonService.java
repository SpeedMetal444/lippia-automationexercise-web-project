package com.automationexercise.services.common;

import com.automationexercise.constants.account.AuthenticationConstants;
import com.automationexercise.constants.common.CommonConstants;
import com.automationexercise.constants.content.HomeConstants;
import com.automationexercise.services.account.AuthenticationService;
import com.crowdar.core.actions.ActionManager;
import com.crowdar.driver.DriverManager;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

public class CommonService {

    public static void clearAndType(String locator, String value) {
        WebElement input = ActionManager.getElement(locator);
        input.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        input.sendKeys(Keys.BACK_SPACE);
        ActionManager.setInput(locator, value);
    }

    public static void verifyTextVisibility(String text) {
        String resolvedText = resolvePlaceholders(text);
        String normalized = normalize(resolvedText);

        String locator = String.format(
                CommonConstants.VISIBLE_TEXT_CONTAINS_IGNORE_CASE,
                normalized
        );

        ActionManager.waitVisibility(locator);
        ActionManager.isVisible(locator);
    }

    private static String resolvePlaceholders(String text) {
        if (text == null) {
            return "";
        }

        if ("Logged in as username".equalsIgnoreCase(text.trim())) {
            return "Logged in as " + AuthenticationService.getDefaultName();
        }

        return text;
    }

    private static final Map<String, String> BUTTON_LOCATORS = new HashMap<>();

    static {
        // Navbar
        BUTTON_LOCATORS.put("home", HomeConstants.HOME_BUTTON);
        BUTTON_LOCATORS.put("products", HomeConstants.PRODUCTS_BUTTON);
        BUTTON_LOCATORS.put("cart", HomeConstants.CART_BUTTON);
        BUTTON_LOCATORS.put("signup / login", HomeConstants.SIGNUP_LOGIN_BUTTON);
        BUTTON_LOCATORS.put("signup/login", HomeConstants.SIGNUP_LOGIN_BUTTON);
        BUTTON_LOCATORS.put("register / login", HomeConstants.SIGNUP_LOGIN_BUTTON);
        BUTTON_LOCATORS.put("register/login", HomeConstants.SIGNUP_LOGIN_BUTTON);
        BUTTON_LOCATORS.put("test cases", HomeConstants.TEST_CASES_BUTTON);
        BUTTON_LOCATORS.put("contact us", HomeConstants.CONTACT_BUTTON);

        // Authentication
        BUTTON_LOCATORS.put("signup", AuthenticationConstants.SIGNUP_BUTTON);
        BUTTON_LOCATORS.put("login", AuthenticationConstants.LOGIN_BUTTON);
        BUTTON_LOCATORS.put("create account", AuthenticationConstants.CREATE_ACCOUNT_BUTTON);
        BUTTON_LOCATORS.put("continue", AuthenticationConstants.CONTINUE_BUTTON);
        BUTTON_LOCATORS.put("delete account", AuthenticationConstants.DELETE_ACCOUNT_BUTTON);
        BUTTON_LOCATORS.put("logout", AuthenticationConstants.LOGOUT_BUTTON);

        // Generic flow buttons
        BUTTON_LOCATORS.put("view cart", "xpath://a[normalize-space()='View Cart']");
        BUTTON_LOCATORS.put("continue shopping", "xpath://button[normalize-space()='Continue Shopping']");
        BUTTON_LOCATORS.put("add to cart", "xpath:(//a[contains(normalize-space(),'Add to cart')] | //button[contains(normalize-space(),'Add to cart')])[1]");
        BUTTON_LOCATORS.put("x", "css:.cart_quantity_delete");
        BUTTON_LOCATORS.put("view product", "xpath:(//a[normalize-space()='View Product'])[1]");
        BUTTON_LOCATORS.put("proceed to checkout", "xpath://a[normalize-space()='Proceed To Checkout' or normalize-space()='Proceed to Checkout']");
        BUTTON_LOCATORS.put("pay and confirm order", "xpath://button[normalize-space()='Pay and Confirm Order']");
        BUTTON_LOCATORS.put("download invoice", "xpath://a[normalize-space()='Download Invoice']");
        BUTTON_LOCATORS.put("submit", "css:input[data-qa='submit-button'], button[type='submit']");
    }

    public static void clickButtonByName(String buttonName) {
        String key = normalize(buttonName);
        String locator = BUTTON_LOCATORS.get(key);

        if (locator == null) {
            throw new IllegalArgumentException("Unknown button name: " + buttonName);
        }

        ActionManager.waitClickable(locator);
        try {
            ActionManager.click(locator);
        } catch (ElementClickInterceptedException e) {
            hideAdsIfPresent();
            clickWithJs(locator);
        }
    }

    private static void hideAdsIfPresent() {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriverInstance();
        js.executeScript("document.querySelectorAll(\"iframe[id^='aswift_'], iframe[id^='google_ads_iframe']\").forEach(e => e.style.display='none');");
    }

    private static void clickWithJs(String locator) {
        WebElement element = ActionManager.getElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriverInstance();
        js.executeScript("arguments[0].click();", element);
    }

    private static String normalize(String value) {
        return value == null ? "" : value.trim().replaceAll("\\s+", " ").toLowerCase();
    }
}
