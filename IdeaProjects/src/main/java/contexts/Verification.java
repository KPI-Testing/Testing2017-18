package contexts;

import org.testng.Assert;
import pages.Cart;
import pages.Delivery;
import pages.Item;

public class Verification {
    public static int verifyItemPrice(Item page, int minExpectedValue, int maxExpectedValue){
        int actualPrice = page.getPrice();
        Assert.assertTrue(actualPrice >= minExpectedValue);
        Assert.assertTrue(actualPrice <= maxExpectedValue);
        return actualPrice;
    }

    public static void verifyTotalPrice(Cart page, int actualPrice){
        int totalPrice = page.getPrice();
        Assert.assertEquals(totalPrice, actualPrice);
    }

    public static void verifySum(Delivery page, int actualPrice){
        int totalPrice = page.getPrice();
        Assert.assertEquals(totalPrice, actualPrice);
    }
}
