package contexts.actions;

import pages.CheckOut;
import pages.ProductPage;

public class BuyProduct {
    public static CheckOut buyAndSubmitProduct(ProductPage page){
        return page.buyAndSubmit();
    }
}
