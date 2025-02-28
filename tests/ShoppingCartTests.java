import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.util.List;

public class ShoppingCartTests {

    // Subject under test
    private ShoppingCart shoppingCart;
    @Before
    public void setup() {
        shoppingCart = new ShoppingCart(new DefaultDiscountProvider());
    }

    @After
    public void tearDown() {
        // Clear
    }

    // RED, GREEN, REFACTOR
    //
    @Test
    public void testWhenCreatingShoppingListThenShoppingCartIsEmpty() {
        // ARRANGE
        // ACT
        int shoppingCartSize = shoppingCart.getItems().size();
        // ASSERT
        Assert.assertEquals(0, shoppingCartSize);
    }


    @Test
    public void testWhenAddingItemToShoppingListThenShoppingHasItems() {
        // ARRANGE
        Item mouse = new Item("Mouse", 100);
        Item keyboard = new Item("Keyboard", 200);
        // ACT
        shoppingCart.add(mouse);
        shoppingCart.add(keyboard);
        int shoppingCartSize = shoppingCart.getItems().size();
        // ASSERT
        Assert.assertEquals(2, shoppingCartSize);
    }


    @Test
    public void testWhenCalculatingSubtotalIfNoItemsThenReturnZero() {
        // ARRANGE
        // ACT
        float subtotal = shoppingCart.calculateSubtotal();
        // ASSERT
        Assert.assertEquals(0, subtotal, 0.1);
    }

    @Test
    public void testWhenCalculatingSubtotalLessThan200ThenReturnSubtotal() {
        // ARRANGE
        Item mouse = new Item("Mouse", 100);
        Item keyboard = new Item("Keyboard", 50);
        shoppingCart.add(mouse);
        shoppingCart.add(keyboard);
        // ACT
        float subtotal = shoppingCart.calculateSubtotal();
        // ASSERT
        Assert.assertEquals(150, subtotal, 0.1);
    }

    // GIVEN -> WHEN -> THEN
    @Test
    public void test_GivenShoppingCartWithItems_WhenCalculatingSubtotalGreaterThan200_ThenReturnSubtotalWithDiscount() {
        // ARRANGE
        Item mouse = new Item("Mouse", 100);
        Item keyboard = new Item("Keyboard", 200);
        shoppingCart.add(mouse);
        shoppingCart.add(keyboard);
        // ACT
        float subtotal = shoppingCart.calculateSubtotal();
        // ASSERT
        Assert.assertEquals(270, subtotal, 0.1);
    }

    @Test
    public void testWhenCalculatingSubtotalGreaterThan300ThenReturnSubtotalWith20Discount() {
        // ARRANGE
        Item mouse = new Item("Mouse", 200);
        Item keyboard = new Item("Keyboard", 200);
        shoppingCart.add(mouse);
        shoppingCart.add(keyboard);
        // ACT
        float subtotal = shoppingCart.calculateSubtotal();
        // ASSERT
        Assert.assertEquals(320, subtotal, 0.1);
    }
}
