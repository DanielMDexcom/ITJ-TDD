import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

public class ShoppingCartTests {

    private ShoppingCart shoppingCart;
    @Before
    public void setup() {
        shoppingCart = new ShoppingCart();
    }

    @Test
    public void testWhenCreatingShoppingListThenItemsAreEmpty() {
        // ARRANGE
        // ACT
        int size = shoppingCart.getItems().size();
        // ASSERT
        Assert.assertEquals(0, size);
    }

    @Test
    public void testWhenAddingItemToShoppingListThenReturnItem() {
        // ARRANGE
        Item keyboard = new Item("Keyboard", 100);
        // ACT
        shoppingCart.addItem(keyboard);
        Item item = shoppingCart.getItems().get(0);
        // ASSERT
        Assert.assertEquals("Keyboard", item.name);
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
        Item keyboard = new Item("Keyboard", 50);
        Item mouse = new Item("Keyboard", 50);
        // ACT
        shoppingCart.addItem(keyboard);
        shoppingCart.addItem(mouse);
        float subtotal = shoppingCart.calculateSubtotal();
        // ASSERT
        Assert.assertEquals(100, subtotal, 0.1);
    }

    @Test
    public void testWhenCalculatingSubtotalGreaterThan200ThenReturnSubtotalWithDiscount() {
        // ARRANGE
        Item keyboard = new Item("Keyboard", 100);
        Item mouse = new Item("Keyboard", 150);
        // ACT
        shoppingCart.addItem(keyboard);
        shoppingCart.addItem(mouse);
        float subtotal = shoppingCart.calculateSubtotal();
        // ASSERT
        Assert.assertEquals(225f, subtotal, 0.1);
    }

    @Test
    public void testWhenCalculatingSubtotalGreaterThan300ThenReturnSubtotalWithDiscount() {
        // ARRANGE
        Item keyboard = new Item("Keyboard", 200);
        Item mouse = new Item("Keyboard", 200);
        // ACT
        shoppingCart.addItem(keyboard);
        shoppingCart.addItem(mouse);
        float subtotal = shoppingCart.calculateSubtotal();
        // ASSERT
        Assert.assertEquals(320f, subtotal, 0.1);
    }
}
