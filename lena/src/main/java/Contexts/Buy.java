package Contexts;

import PageObjects.Glue;
import PageObjects.ResultsPageGlue;

public class Buy {
    public static  Glue buy(ResultsPageGlue products, int numberOfGlue){
        products.ItemsBuy.get(numberOfGlue).click();
        return new Glue( products.driver );
    }
}
