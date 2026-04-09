package com.automationexercise.constants.account;

public final class AuthenticationConstants {

    public static final String SIGNUP_NAME_INPUT = "css:[data-qa='signup-name']";
    public static final String SIGNUP_EMAIL_INPUT = "css:[data-qa='signup-email']";
    public static final String LOGIN_EMAIL_INPUT = "css:[data-qa='login-email']";
    public static final String LOGIN_PASSWORD_INPUT = "css:[data-qa='login-password']";
    public static final String SIGNUP_BUTTON = "css:button[data-qa='signup-button']";
    public static final String LOGIN_BUTTON = "css:button[data-qa='login-button']";
    public static final String CREATE_ACCOUNT_BUTTON = "css:button[data-qa='create-account']";
    public static final String CONTINUE_BUTTON = "css:[data-qa='continue-button']";
    public static final String DELETE_ACCOUNT_BUTTON = "css:a[href='/delete_account']";
    public static final String LOGOUT_BUTTON = "css:a[href='/logout']";
    public static final String NAME_INPUT = "id:name";
    public static final String GENDER_CHECK_MALE = "id:id_gender1";
    public static final String GENDER_CHECK_FEMALE = "id:id_gender2";
    public static final String BIRTH_DAY_LIST = "id:days";
    public static final String BIRTH_MONTH_LIST = "id:months";
    public static final String BIRTH_YEAR_LIST = "id:years";
    public static final String PASSWORD_INPUT = "id:password";
    public static final String NEWSLETTER_CHECKBOX = "id:newsletter";
    public static final String OFFERS_CHECKBOX = "id:optin";
    public static final String FIRST_NAME_INPUT = "id:first_name";
    public static final String LAST_NAME_INPUT = "id:last_name";
    public static final String ADDRESS1_INPUT = "id:address1";
    public static final String COUNTRY_LIST = "id:country";
    public static final String STATE_INPUT = "id:state";
    public static final String CITY_INPUT = "id:city";
    public static final String ZIPCODE_INPUT = "id:zipcode";
    public static final String MOBILE_NUMBER_INPUT = "id:mobile_number";

    private AuthenticationConstants() {
    }
}
