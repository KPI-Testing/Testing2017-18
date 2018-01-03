package Contexts;

        import Pageobj.CheckOutPage;
        import Pageobj.ProductPage;

public class Buy {
    public static CheckOutPage Subm_buying_product(ProductPage page){

        return page.Submit_buying();
    }
}