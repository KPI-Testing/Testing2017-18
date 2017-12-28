package contexts;

import pages.*;
import waiters.Waiters;

public class ItemShoppingContext {
    public static CartPage buy(ItemPage page){
        page.buy.click();
        Waiters.waitForElement(page.getDriver(), "//div[@id=\"cart-popup\"]",Waiters.WAIT_10);
        Waiters.waiterForCart(page.getDriver(), Waiters.WAIT_10);
        return new CartPage(page.getDriver());
    }

    public static ContactsPage validatePurchase(CartPage page){
        page.validate.click();
        return new ContactsPage(page.getDriver());
    }

    public static SledgesPage clickBackToCatalog(ItemPage page){
        page.backToCatalog.click();
        return new SledgesPage(page.getDriver(), true);
    }

    public static SledgesPage goToCatalogue(Page page){
        page.getDriver().get(SledgesPage.ROZETKA_SLEDGES_URL);
        return new SledgesPage(page.getDriver(), true);
    }

    public static String getName(ItemPage page){
        return page.getName();
    }
}
