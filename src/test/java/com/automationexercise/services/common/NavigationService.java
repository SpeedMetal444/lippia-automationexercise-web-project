package com.automationexercise.services.common;

import com.crowdar.core.actions.WebActionManager;

public class NavigationService {
    public static void navigatesToUrl(String url) {
        WebActionManager.navigateTo(url);
    }
}
