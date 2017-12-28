package contexts;

import org.testng.Assert;
import pages.CartPage;
import pages.DeliveryPage;
import pages.ItemPage;

public class ItemVerificationContext {
    public static int verifyItemPrice(ItemPage page, int minExpectedValue, int maxExpectedValue){
        int actualPrice = page.getPrice();
        Assert.assertTrue(actualPrice >= minExpectedValue);
        Assert.assertTrue(actualPrice <= maxExpectedValue);
        return actualPrice;
    }

    public static void verifyTotalPrice(CartPage page, int actualPrice){
        int totalPrice = page.getPrice();
        Assert.assertEquals(totalPrice, actualPrice);
    }

    public static void verifySum(DeliveryPage page, int actualPrice){
        int totalPrice = page.getPrice();
        Assert.assertEquals(totalPrice, actualPrice);
    }
}
