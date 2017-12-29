package contexts;

import pages.Cart;
import pages.Contacts;
import pages.Item;
import waiters.Waiters;

public class Purchase {
    public static Cart buy(Item page){
        page.buy.click();
        Waiters.waitForElement(page.getDriver(), "//div[@id=\"cart-popup\"]",Waiters.WAIT_10);
        return new Cart(page.getDriver());
    }

    public static Contacts validatePurchase(Cart page){
        page.validate.click();
        return new Contacts(page.getDriver());
    }
}
