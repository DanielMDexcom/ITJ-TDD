import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

public class ShoppingCartTests {

    private ShoppingCart shoppingCart;

    @Before
    public void setup() {
        DiscountProvider discountProvider = new DefaultDiscountProvider();
        shoppingCart = new ShoppingCart(discountProvider);
    }

    @Test
    public void testWhenCreatingShoppingListThenItemsAreEmpty() {
        // ARRANGE
        // ACT
        int itemsCount = shoppingCart.getItems().size();
        // ASSERT
        Assert.assertEquals(0, itemsCount);
    }

    @Test
    public void testWhenAddingItemToShoppingListThenReturnItem() {
        // ARRANGE
        Item item = new Item("Keyboard", 100);
        // ACT
        shoppingCart.add(item);
        Item keyboard = shoppingCart.getItems().get(0);
        // ASSERT
        Assert.assertEquals("Keyboard", keyboard.name);
    }

    @Test
    public void testWhenCalculatingSubtotalIfNoItemsThenReturnZero() {
        // ARRANGE
        // ACT
        float subtotal = shoppingCart.calculateSubtotal();
        // ASSERT
        Assert.assertEquals(0, subtotal, 0);
    }

    @Test
    public void testWhenCalculatingSubtotalLessThan200ThenReturnSubtotal() {
        // ARRANGE
        Item item = new Item("Keyboard", 50);
        Item item2 = new Item("Mouse", 50);
        // ACT
        shoppingCart.add(item);
        shoppingCart.add(item2);
        float subtotal = shoppingCart.calculateSubtotal();
        // ASSERT
        Assert.assertEquals(100, subtotal, 0.1);
    }

    // REFACTOR
    @Test
    public void testWhenCalculatingSubtotalGreaterThan200ThenReturnSubtotalWithDiscountOf10() {
        // ARRANGE
        Item item = new Item("Keyboard", 100);
        Item item2 = new Item("Mouse", 200);
        // ACT
        shoppingCart.add(item);
        shoppingCart.add(item2);
        float subtotal = shoppingCart.calculateSubtotal();
        // ASSERT
        Assert.assertEquals(270, subtotal, 0.1);
    }

    // REFACTOR
    @Test
    public void testWhenCalculatingSubtotalGreaterThan300ThenReturnSubtotalWithDiscount() {
        // ARRANGE
        Item item = new Item("Keyboard", 200);
        Item item2 = new Item("Mouse", 200);
        // ACT
        shoppingCart.add(item);
        shoppingCart.add(item2);
        float subtotal = shoppingCart.calculateSubtotal();
        // ASSERT
        Assert.assertEquals(320, subtotal, 0.1);
    }
    @Test
    public void testWhenCalculatingSubtotalGreaterThan500WhenSummerThenReturnSubtotalWithDiscount() {
        // ARRANGE
        DiscountProvider discountProvider = new SummerDiscountProvider();
        shoppingCart = new ShoppingCart(discountProvider);

        Item item = new Item("Keyboard", 500);
        Item item2 = new Item("Mouse", 500);
        // ACT
        shoppingCart.add(item);
        shoppingCart.add(item2);
        float subtotal = shoppingCart.calculateSubtotal();
        // ASSERT
        Assert.assertEquals(500, subtotal, 0.1);
    }

}
