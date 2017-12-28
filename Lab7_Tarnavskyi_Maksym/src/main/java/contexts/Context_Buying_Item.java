package contexts;

import pages.Basket_Page;
import pages.Contacts_Page;
import pages.Item_Page;
import pages.Search_Page;
import waiters.Wait;

public class Context_Buying_Item {

    public static Item_Page selectElement(Search_Page page, int element_Index){
        page.set_of_Results.get(element_Index).click();
        return new Item_Page(page.getDriver());
    }

    public static Basket_Page buy(Item_Page page){
        page.buy.click();
        Wait.wait_for_Element(page.getDriver(), "//div[@id=\"cart-popup\"]", Wait.WAIT_Amount_of_Seconds);
        return new Basket_Page(page.getDriver());
    }

    public static Contacts_Page validate_Purchase(Basket_Page page){
        page.validate.click();
        return new Contacts_Page(page.getDriver());
    }
}
