import java.util.ArrayList;

/**
 * 1. Create an empty Shopping Cart
 * 2. I want to be able to add items to my shopping cart
 * 3. I should be able to calculate the subtotal of my shopping cart
 *    if the shopping cart is empty return 0
 *    calculate the subtotal of all items
 *    apply a discount of 10% if subtotal is Greater than 200
 *    and 20% if is Greater than 300
 * 4. If it's summer then ONLY apply 50% discount if Greater 500
 * */
public class ShoppingCart {

    private DiscountProvider discountProvider;
    private ArrayList<Item> items;

    ShoppingCart(DiscountProvider discountProvider) {
        this.discountProvider = discountProvider;
        items = new ArrayList<>();
    }
    public ArrayList<Item> getItems() {
        return items;
    }

    public void add(Item item) {
        items.add(item);
    }
    // SRP -> Should the shopping determine the discount everytime? -> GOOD
    // OCP -> What is discount changes? -> GOOD
    // LSP -> We can change implementation of the DiscountProvider -> GOOD (DEFAULT, SUMMER)
    // ISP -> Specific interfaces -> GOOD
    // DIP -> We have create abstractions -> GOOD
    public float calculateSubtotal() {
        float subtotal = 0;

        for (Item item:
             items) {
            subtotal += item.price;
        }

        subtotal = discountProvider.calculateDiscount(subtotal);
        return subtotal;
    }
}
