package com.automationexercise.services.shopping;

import com.automationexercise.constants.content.HomeConstants;
import com.automationexercise.constants.shopping.CartConstants;
import com.automationexercise.constants.shopping.ProductsConstants;
import com.crowdar.core.actions.ActionManager;
import com.crowdar.driver.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CartService {

    private static String lastRecommendedProductId;
    private static final List<String> addedProductIds = new ArrayList<>();
    private static final Map<String, Integer> expectedPrices = new LinkedHashMap<>();
    private static final Map<String, Integer> expectedQuantities = new LinkedHashMap<>();

    public static void verifyProductsInCart(String... productIds) {
        requireProductIds(productIds, "No product ids were provided to validate the cart contents");

        for (String productId : productIds) {
            String normalizedProductId = normalizeProductId(productId);
            String cartRowLocator = String.format(CartConstants.CART_ROW_BY_PRODUCT_ID, normalizedProductId);
            ActionManager.waitVisibility(cartRowLocator);
        }
    }

    public static void addFirstRecommendedProductToCart() {
        ActionManager.waitVisibility(HomeConstants.RECOMMENDED_ITEMS_TITLE);
        ActionManager.waitVisibility(HomeConstants.RECOMMENDED_ACTIVE_FIRST_PRODUCT_NAME);
        ActionManager.waitClickable(HomeConstants.RECOMMENDED_ACTIVE_FIRST_ADD_TO_CART);

        String productId = ActionManager.getAttribute(
                HomeConstants.RECOMMENDED_ACTIVE_FIRST_ADD_TO_CART, "data-product-id"
        );
        lastRecommendedProductId = normalizeProductId(productId);

        ActionManager.click(HomeConstants.RECOMMENDED_ACTIVE_FIRST_ADD_TO_CART);
    }

    public static void verifyRecommendedProductIsDisplayedInCart() {
        if (lastRecommendedProductId == null || lastRecommendedProductId.trim().isEmpty()) {
            throw new IllegalStateException("No recommended product id captured to validate in cart");
        }

        String cartRowLocator = String.format(CartConstants.CART_ROW_BY_PRODUCT_ID, lastRecommendedProductId.trim());
        ActionManager.waitVisibility(cartRowLocator);
    }

    public static void addFirstProduct() {
        addProductByIndex(1);
    }

    public static void addSecondProduct() {
        addProductByIndex(2);
    }

    public static void verifyAddedProductsInCart() {
        if (addedProductIds.isEmpty()) {
            throw new IllegalStateException("No products were captured while adding items to the cart");
        }

        verifyProductsInCart(addedProductIds.toArray(new String[0]));
    }

    public static void verifyProductsDetailsInCart() {
        if (addedProductIds.isEmpty()) {
            throw new IllegalStateException("No products were captured while adding items to the cart");
        }

        for (String productId : addedProductIds) {
            int expectedPrice = expectedPrices.getOrDefault(productId, -1);
            int expectedQuantity = expectedQuantities.getOrDefault(productId, 0);
            int expectedTotal = expectedPrice * expectedQuantity;

            String cartPriceText = getVisibleText(String.format(CartConstants.CART_PRICE_BY_PRODUCT_ID, productId));
            String cartQuantityText = getVisibleText(String.format(CartConstants.CART_QUANTITY_BY_PRODUCT_ID, productId));
            String cartTotalText = getVisibleText(String.format(CartConstants.CART_TOTAL_BY_PRODUCT_ID, productId));

            int actualPrice = extractAmount(cartPriceText);
            int actualQuantity = extractAmount(cartQuantityText);
            int actualTotal = extractAmount(cartTotalText);

            if (actualPrice != expectedPrice) {
                throw new AssertionError(String.format(
                        "Price mismatch for product %s. Expected: %s but was: %s",
                        productId, expectedPrice, actualPrice
                ));
            }

            if (actualQuantity != expectedQuantity) {
                throw new AssertionError(String.format(
                        "Quantity mismatch for product %s. Expected: %s but was: %s",
                        productId, expectedQuantity, actualQuantity
                ));
            }

            if (actualTotal != expectedTotal) {
                throw new AssertionError(String.format(
                        "Total mismatch for product %s. Expected: %s but was: %s",
                        productId, expectedTotal, actualTotal
                ));
            }
        }
    }

    private static void addProductByIndex(int productIndex) {
        String cardLocator = String.format(ProductsConstants.PRODUCT_CARD_BY_INDEX, productIndex);
        String priceLocator = String.format(ProductsConstants.PRODUCT_PRICE_BY_INDEX, productIndex);
        String addToCartLocator = String.format(ProductsConstants.PRODUCT_ADD_TO_CART_BY_INDEX, productIndex);

        WebElement productCard = ActionManager.waitVisibility(cardLocator);
        scrollIntoView(productCard);
        hover(productCard);

        String productId = normalizeProductId(ActionManager.getAttribute(addToCartLocator, "data-product-id"));

        String productPriceText = getVisibleText(priceLocator);
        int productPrice = extractAmount(productPriceText);

        ActionManager.waitClickable(addToCartLocator);
        ActionManager.click(addToCartLocator);

        String normalizedProductId = productId;
        if (!addedProductIds.contains(normalizedProductId)) {
            addedProductIds.add(normalizedProductId);
        }
        expectedPrices.put(normalizedProductId, productPrice);
        expectedQuantities.put(normalizedProductId, 1);
    }

    private static void hover(WebElement element) {
        new Actions(DriverManager.getDriverInstance())
                .moveToElement(element)
                .perform();
    }

    private static void scrollIntoView(WebElement element) {
        JavascriptExecutor js = DriverManager.getDriverInstance();
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);
    }

    private static String getVisibleText(String locator) {
        WebElement element = ActionManager.waitVisibility(locator);
        String text = element.getText();

        if ((text == null || text.trim().isEmpty()) && "input".equalsIgnoreCase(element.getTagName())) {
            text = element.getAttribute("value");
        }

        return text == null ? "" : text.trim();
    }

    private static int extractAmount(String text) {
        String normalized = text == null ? "" : text.replaceAll("[^0-9]", "");
        if (normalized.isEmpty()) {
            throw new IllegalStateException("Could not extract numeric value from text: " + text);
        }
        return Integer.parseInt(normalized);
    }

    private static void requireProductIds(String[] productIds, String message) {
        if (productIds == null || productIds.length == 0) {
            throw new IllegalStateException(message);
        }
    }

    private static String normalizeProductId(String productId) {
        if (productId == null || productId.trim().isEmpty()) {
            throw new IllegalStateException("Could not capture a valid product id");
        }
        return productId.trim();
    }
}
