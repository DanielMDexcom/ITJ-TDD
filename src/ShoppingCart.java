import java.util.ArrayList;

/**
 * 1. Create a Shopping Cart
 * 2. I want to be able to add items to my shopping cart
 * 3. I should be able to calculate the subtotal of my shopping cart
 *    if the shopping cart is empty return 0
 *    calculate the subtotal of all items
 *    apply a discount of 10% if subtotal is Greater than 200 and 20% if is Greater than 300
 * */
public class ShoppingCart {

    ArrayList<Item> items;

    {
        items = new ArrayList<>();
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void add(Item item) {
        items.add(item);
    }

    public float calculateSubtotal() {
        float subtotal = calculateTotal();
        subtotal = applyDiscount(subtotal);
        return subtotal;
    }

    private float calculateTotal() {
        float subtotal = 0;
        for (Item item:
                items) {
            subtotal += item.price;
        }
        return subtotal;
    }

    private float applyDiscount(float subtotal) {
        if (subtotal > 200 && subtotal < 300) {
            subtotal = subtotal * (.90f);
        } else if (subtotal > 300) {
            subtotal = subtotal * (.80f);
        }
        return subtotal;
    }
}
