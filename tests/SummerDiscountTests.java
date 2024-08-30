import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

public class SummerDiscountTests {

    private DiscountProvider discountProvider;

    @Before
    public void setup() {
        discountProvider = new SummerDiscountProvider();
    }

    @Test
    public void testWhenSubtotalGreaterThan500ReturnDiscount() {
        // ARRANGE
        // ACT
        float subtotal = discountProvider.calculateDiscount(2000);
        // ASSERT
        Assert.assertEquals(1000, subtotal, 0);
    }
}