package Contexts;

import Page_Objects.Card_Page;
import Page_Objects.CheckOut_Page;
import Page_Objects.Item_Page;
import Page_Objects.Search_Page;
import Waiters.Waiters;

public class Context_Buy_Product {

    public static Item_Page Select_Element(Search_Page page, int element_Index){
        page.Results.get(element_Index).click();
        page.Results.get(element_Index).click();
        return new Item_Page(page.getDriver());
    }

    public static Card_Page Click_Element(Item_Page page){
        page.buy.click();
        Waiters.Wait_For_Element(page.getDriver(), "//div[@id=\"cart-popup\"]", Waiters.Wait_15_seconds);
        return new Card_Page(page.getDriver());
    }

    public static CheckOut_Page Buy_Element(Card_Page page){
        page.validate.click();
        return new CheckOut_Page(page.getDriver());
    }
}
