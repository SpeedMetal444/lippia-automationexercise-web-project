package com.automationexercise.constants.common;

public final class CommonConstants {

    public static final String VISIBLE_TEXT_CONTAINS_IGNORE_CASE = "xpath://*[not(self::script) and not(self::style) and contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '%s')]";
    public static final String SCROLL_UP_BUTTON = "id:scrollUp";

    private CommonConstants() {
    }
}
