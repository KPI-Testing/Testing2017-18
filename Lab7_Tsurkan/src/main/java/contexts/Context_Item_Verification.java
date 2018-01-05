package contexts;

import org.testng.Assert;
import pages.Basket_Page;
import pages.Delivery_Page;
import pages.Item_Page;

public class Context_Item_Verification {
    public static int verify_Item_Price(Item_Page page, int min_Value, int max_Value){
        int actual_Price = page.get_Price();
        Assert.assertTrue(actual_Price >= min_Value);
        Assert.assertTrue(actual_Price <= max_Value);
        return actual_Price;
    }

    public static void verify_Total_Price(Basket_Page page, int actual_Price){
        int total_Price = page.get_Price();
        Assert.assertEquals(total_Price, actual_Price);
    }

    public static void verify_Total_Price(Delivery_Page page, int actual_Price){
        int total_Price = page.get_Price();
        Assert.assertEquals(total_Price, actual_Price);
    }

    public static void verify_Purchase_Button_Is_Enabled(Delivery_Page page){
        Assert.assertTrue(page.purchaseButton.isEnabled());
    }
}
