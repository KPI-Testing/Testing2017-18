package contexts;

import pages.*;
import util.Waiters;

public class ShopContext {

    public static ProductPage getProductPage(SearchPage searchPage, int productNumber){
        searchPage.getProductList().get(productNumber).click();
        Waiters.waitForVisibilityByName(searchPage.getDriver(),"topurchases");
        return new ProductPage(searchPage.getDriver());
    }

    public static BasketPage clickBuyButton(ProductPage productPage){
        productPage.getBuyButton().click();
        Waiters.waitForVisibilityById(productPage.getDriver(), "popup-checkout");
        return new BasketPage(productPage.getDriver());
    }

    public static ContactsPage makeOrder(BasketPage basketPage){
        basketPage.getCheckoutBtutton().click();
        Waiters.waitForVisibilityById(basketPage.getDriver(),"reciever_name");
        return new ContactsPage(basketPage.getDriver());
    }
}
