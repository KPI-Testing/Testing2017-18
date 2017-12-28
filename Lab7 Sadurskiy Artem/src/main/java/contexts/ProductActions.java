package contexts;

import pages.CheckOutPage;
import pages.ProductPage;

public class ProductActions {
    public static CheckOutPage buyAndSubmitProduct(ProductPage page){
        return page.buyAndSubmit();
    }
}
