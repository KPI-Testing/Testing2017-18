package contexts;

import PageObjects.CheckOutPage;
import PageObjects.ProductPage;

public class Buying {
    public static CheckOutPage buyAndSubmitProduct(ProductPage page){
        return page.buyAndSubmit();
    }
}
