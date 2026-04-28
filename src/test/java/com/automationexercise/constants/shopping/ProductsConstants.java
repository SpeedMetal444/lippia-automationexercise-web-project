package com.automationexercise.constants.shopping;

public final class ProductsConstants {

    public static final String PRODUCT_CARD_BY_INDEX = "xpath:(//div[contains(@class,'features_items')]//div[contains(@class,'product-image-wrapper')])[%s]";
    public static final String PRODUCT_PRICE_BY_INDEX = "xpath:((//div[contains(@class,'features_items')]//div[contains(@class,'product-image-wrapper')])[%s]//div[contains(@class,'productinfo')]/h2)[1]";
    public static final String PRODUCT_ADD_TO_CART_BY_INDEX = "xpath:((//div[contains(@class,'features_items')]//div[contains(@class,'product-image-wrapper')])[%s]//a[contains(@class,'add-to-cart') and @data-product-id])[last()]";

    private ProductsConstants() {

    }
}
