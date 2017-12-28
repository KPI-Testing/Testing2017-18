package contexts;

import pages.CartPage;
import pages.ContactsPage;
import pages.ItemPage;
import waiters.Waiters;

public class ItemShoppingContext {
    public static CartPage buy(ItemPage page){
        page.buy.click();
        Waiters.waitForElement(page.getDriver(), "//div[@id=\"cart-popup\"]",Waiters.WAIT_10);
        return new CartPage(page.getDriver());
    }

    public static ContactsPage validatePurchase(CartPage page){
        page.validate.click();
        return new ContactsPage(page.getDriver());
    }
}
