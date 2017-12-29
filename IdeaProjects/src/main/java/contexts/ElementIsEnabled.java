package contexts;

import org.testng.Assert;
import pages.Delivery;

public class ElementIsEnabled {
    public static void verifyPurchaseButtonIsEnabled(Delivery page){
        Assert.assertTrue(page.purchaseButton.isEnabled());
    }
}
