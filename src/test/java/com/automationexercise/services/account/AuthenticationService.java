package com.automationexercise.services.account;

import com.automationexercise.constants.account.AuthenticationConstants;
import com.crowdar.core.PropertyManager;
import com.crowdar.core.actions.ActionManager;
import com.crowdar.driver.DriverManager;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AuthenticationService {

    private static final String DEFAULT_GENDER = "male";
    private static final String DEFAULT_NAME = "Hugo Abel Godoy";
    private static final String DEFAULT_BIRTH_DAY = "18";
    private static final String DEFAULT_BIRTH_MONTH = "February";
    private static final String DEFAULT_BIRTH_YEAR = "1993";
    private static final String DEFAULT_FIRST_NAME = "Abel";
    private static final String DEFAULT_LAST_NAME = "Godoy";
    private static final String DEFAULT_ADDRESS = "9 de Julio";
    private static final String DEFAULT_COUNTRY = "United States";
    private static final String DEFAULT_STATE = "Corrientes";
    private static final String DEFAULT_CITY = "Corrientes";
    private static final String DEFAULT_ZIPCODE = "3400";

    public static void registerNameEmail() {
        ActionManager.setInput(AuthenticationConstants.SIGNUP_NAME_INPUT, DEFAULT_NAME);
        ActionManager.setInput(AuthenticationConstants.SIGNUP_EMAIL_INPUT, requiredProperty("signup-login-email"));
    }

    public static void fillAccountPrimaryDetails() {
        selectGender();
        fillCredentials();
        selectBirthDate();
    }

    public static void fillAddressAndContactDetails() {
        fillContactIdentity();
        fillAddressDetails();
    }

    private static void fillCredentials() {
        ActionManager.setInput(AuthenticationConstants.NAME_INPUT, DEFAULT_NAME);
        ActionManager.setInput(AuthenticationConstants.PASSWORD_INPUT, requiredProperty("login-password"));
    }

    private static void fillContactIdentity() {
        ActionManager.setInput(AuthenticationConstants.FIRST_NAME_INPUT, DEFAULT_FIRST_NAME);
        ActionManager.setInput(AuthenticationConstants.LAST_NAME_INPUT, DEFAULT_LAST_NAME);
        ActionManager.setInput(AuthenticationConstants.ADDRESS1_INPUT, DEFAULT_ADDRESS);
    }

    private static void fillAddressDetails() {
        selectCountry();
        ActionManager.setInput(AuthenticationConstants.STATE_INPUT, DEFAULT_STATE);
        ActionManager.setInput(AuthenticationConstants.CITY_INPUT, DEFAULT_CITY);
        ActionManager.setInput(AuthenticationConstants.ZIPCODE_INPUT, DEFAULT_ZIPCODE);
        ActionManager.setInput(AuthenticationConstants.MOBILE_NUMBER_INPUT, requiredProperty("mobile-number"));
    }

    private static void selectBirthDate() {
        selectByVisibleText(AuthenticationConstants.BIRTH_DAY_LIST, DEFAULT_BIRTH_DAY);
        selectByVisibleText(AuthenticationConstants.BIRTH_MONTH_LIST, DEFAULT_BIRTH_MONTH);
        selectByVisibleText(AuthenticationConstants.BIRTH_YEAR_LIST, DEFAULT_BIRTH_YEAR);
    }

    private static void selectCountry() {
        selectByVisibleText(AuthenticationConstants.COUNTRY_LIST, DEFAULT_COUNTRY);
    }

    private static void selectByVisibleText(String locator, String visibleText) {
        try {
            ActionManager.waitVisibility(locator);
            Select dropdown = new Select(ActionManager.getElement(locator));
            dropdown.selectByVisibleText(visibleText);
        } catch (ElementClickInterceptedException e) {
            setSelectValueWithJs(locator, visibleText);
        }
    }

    private static void setSelectValueWithJs(String locator, String visibleText) {
        WebElement selectElement = ActionManager.getElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriverInstance();

        String script = "const sel = arguments[0];"
                + "const target = (arguments[1] || '').trim().toLowerCase();"
                + "for (let i = 0; i < sel.options.length; i++) {"
                + "  const optionText = (sel.options[i].text || '').trim().toLowerCase();"
                + "  if (optionText === target) {"
                + "    sel.selectedIndex = i;"
                + "    sel.dispatchEvent(new Event('change', { bubbles: true }));"
                + "    return;"
                + "  }"
                + "}"
                + "throw new Error('Option not found: ' + arguments[1]);";

        js.executeScript(script, selectElement, visibleText);
    }

    public static void selectNewsOfferCheckbox(String checkboxText) {
        String key = normalize(checkboxText);
        switch (key) {
            case "sign up for our newsletter!":
                ActionManager.click(AuthenticationConstants.NEWSLETTER_CHECKBOX);
                break;
            case "receive special offers from our partners!":
                ActionManager.click(AuthenticationConstants.OFFERS_CHECKBOX);
                break;
            default:
                throw new IllegalArgumentException("Unknown checkbox: " + checkboxText);
        }
    }

    private static void selectGender() {
        String key = normalize(DEFAULT_GENDER);
        switch (key) {
            case "male":
                ActionManager.click(AuthenticationConstants.GENDER_CHECK_MALE);
                break;
            case "female":
                ActionManager.click(AuthenticationConstants.GENDER_CHECK_FEMALE);
                break;
            default:
                throw new IllegalArgumentException("Unknown gender: " + DEFAULT_GENDER);
        }
    }

    private static String requiredProperty(String key) {
        String value = PropertyManager.getProperty(key);
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalStateException("Missing property value for key: " + key);
        }
        return value.trim();
    }

    private static String normalize(String value) {
        return value == null ? "" : value.trim().replaceAll("\\s+", " ").toLowerCase();
    }

    public static String getDefaultName() {
        return DEFAULT_NAME;
    }
}
