import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
        int shoppingCartSize = shoppingCart.getItems().size();
        // ASSERT
        Assert.assertEquals(shoppingCartSize, 0);
    }

    @Test
    public void testWhenAddingItemToShoppingListThenReturnItem() {
        // ARRANGE
        Item keyboard = new Item("Keyboard", 100f);
        // ACT
        shoppingCart.add(keyboard);
        Item item = shoppingCart.items.getFirst();
        // ASSERT
        Assert.assertEquals(item.name, "Keyboard");
    }

    @Test
    public void testWhenCalculatingSubtotalIfNoItemsThenReturnZero() {
        // ARRANGE
        // ACT
        float subtotal = shoppingCart.calculateSubtotal();
        // ASSERT
        Assert.assertEquals(subtotal, 0, 0);
    }

    @Test
    public void testWhenCalculatingSubtotalLessThan200ThenReturnSubtotal() {
        // ARRANGE
        Item keyboard = new Item("Keyboard", 50f);
        Item mouse = new Item("Mouse", 50f);
        // ACT
        shoppingCart.add(keyboard);
        shoppingCart.add(mouse);
        float subtotal = shoppingCart.calculateSubtotal();
        // ASSERT
        Assert.assertEquals(subtotal, 100f, 0);
    }

    @Test
    public void testWhenCalculatingSubtotalGreaterThan200ThenReturnSubtotalWithDiscount() {
        // ARRANGE
        Item keyboard = new Item("Keyboard", 150f);
        Item mouse = new Item("Mouse", 100f);
        // ACT
        shoppingCart.add(keyboard);
        shoppingCart.add(mouse);
        float subtotal = shoppingCart.calculateSubtotal();
        // ASSERT
        Assert.assertEquals(225f, subtotal, 0.1);
    }

    @Test
    public void testWhenCalculatingSubtotalGreaterThan300ThenReturnSubtotalWithDiscount() {
        // ARRANGE
        Item keyboard = new Item("Keyboard", 200);
        Item mouse = new Item("Mouse", 200);
        // ACT
        shoppingCart.add(keyboard);
        shoppingCart.add(mouse);
        float subtotal = shoppingCart.calculateSubtotal();
        // ASSERT
        Assert.assertEquals(320, subtotal, 0.1);
    }
}
