package com.automationexercise.constants.common;

public final class CommonConstants {

    public static final String VISIBLE_TEXT_CONTAINS = "xpath://*[not(self::script) and not(self::style) and contains(normalize-space(.),'%s')]";

    private CommonConstants() {
    }
}
