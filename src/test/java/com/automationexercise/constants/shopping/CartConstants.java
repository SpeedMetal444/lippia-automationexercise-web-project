package com.automationexercise.constants.shopping;

public final class CartConstants {

    public static final String CART_ROW_BY_PRODUCT_ID = "xpath://tr[@id='product-%s']";
    public static final String CART_PRICE_BY_PRODUCT_ID = "xpath://tr[@id='product-%s']//td[contains(@class,'cart_price')]//p";
    public static final String CART_QUANTITY_BY_PRODUCT_ID = "xpath://tr[@id='product-%s']//td[contains(@class,'cart_quantity')]//*[self::button or self::input]";
    public static final String CART_TOTAL_BY_PRODUCT_ID = "xpath://tr[@id='product-%s']//td[contains(@class,'cart_total')]//p";

    private CartConstants() {
    }
}
