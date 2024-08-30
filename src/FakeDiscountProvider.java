public class FakeDiscountProvider implements DiscountProvider {
    @Override
    public float calculateDiscount(float subtotal) {
        return subtotal * 0.8f;
    }
}
