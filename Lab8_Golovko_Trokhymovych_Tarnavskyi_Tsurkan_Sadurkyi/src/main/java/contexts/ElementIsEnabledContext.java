package contexts;

import org.testng.Assert;
import pages.DeliveryPage;

public class ElementIsEnabledContext {
    public static void verifyPurchaseButtonIsEnabled(DeliveryPage page){
        Assert.assertTrue(page.purchaseButton.isEnabled());
    }
}
