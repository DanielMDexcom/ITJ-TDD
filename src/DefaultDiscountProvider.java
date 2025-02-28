public class DefaultDiscountProvider implements DiscountProvider {
    @Override
    public float getDiscount(float subtotal) {
        float discount = 1;
        if (subtotal > 300) {
            discount = 0.8f;
        } else if (subtotal > 200) {
            discount = 0.9f;
        }
        return discount;
    }
}
