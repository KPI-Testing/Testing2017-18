package Contexts;

import org.testng.Assert;
import Page_Objects.Card_Page;
import Page_Objects.Delivery_Page;
import Page_Objects.Item_Page;

public class Context_Item_Verification {
    public static int verify_item_price(Item_Page page, int min_price, int max_price){
        int current_price = page.Get_Price();
        Assert.assertTrue(current_price >= min_price);
        Assert.assertTrue(current_price <= max_price);
        return current_price;
    }

    public static void Verify_Total_Price(Card_Page page, int current_price){
        int total_price = page.Get_Price();
        Assert.assertEquals(total_price, current_price);
    }

    public static void Verify_Total_Price(Delivery_Page page, int current_price){
        int total_price = page.Get_Price();
        Assert.assertEquals(total_price, current_price);
    }

    public static void Verify_Purchase_Button_Is_Enabled(Delivery_Page page){
        Assert.assertTrue(page.purchaseButton.isEnabled());
    }
}
