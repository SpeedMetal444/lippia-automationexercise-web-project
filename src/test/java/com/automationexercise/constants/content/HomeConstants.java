package com.automationexercise.constants.content;

public final class HomeConstants {

    public static final String HOME_CAROUSEL = "id:slider-carousel";
    public static final String HOME_BUTTON = "css:a[href='/']";
    public static final String PRODUCTS_BUTTON = "css:a[href='/products']";
    public static final String CART_BUTTON = "css:a[href='/view_cart']";
    public static final String SIGNUP_LOGIN_BUTTON = "css:a[href='/login']";
    public static final String TEST_CASES_BUTTON = "css:a[href='/test_cases']";
    public static final String API_TESTING_BUTTON = "css:a[href='/api_list']";
    public static final String TUTORIALS_BUTTON = "css:a[href*='youtube.com/c/AutomationExercise']";
    public static final String CONTACT_BUTTON = "css:a[href='/contact_us']";
    public static final String SUBSCRIBE_INPUT = "id:susbscribe_email";
    public static final String SUBSCRIBE_BUTTON = "id:subscribe";
    public static final String RECOMMENDED_ITEMS_TITLE = "xpath://h2[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'recommended items')]";
    public static final String RECOMMENDED_ACTIVE_FIRST_ADD_TO_CART = "xpath:(//div[@id='recommended-item-carousel']//div[contains(@class,'item') and contains(@class,'active')]//a[contains(@class,'add-to-cart')])[1]";
    public static final String RECOMMENDED_ACTIVE_FIRST_PRODUCT_NAME = "xpath:(//div[@id='recommended-item-carousel']//div[contains(@class,'item') and contains(@class,'active')]//div[contains(@class,'productinfo')]//p)[1]";
    public static final String CART_ROW_BY_PRODUCT_ID = "xpath://tr[@id='product-%s']";


    private HomeConstants() {
    }
}
