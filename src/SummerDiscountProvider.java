

public class SummerDiscountProvider implements  DiscountProvider {
    @Override
    public float calculateDiscount(float subtotal) {
        if (subtotal > 500) {
            subtotal = subtotal * 0.5f;
        }
        return subtotal;
    }
}
