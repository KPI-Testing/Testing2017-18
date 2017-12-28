package contexts.actions;
import extentions.NotExistProducerExeption;
import extentions.NotHaveProductsExeption;
import pages.*;

public class Filtering {


    public static SearchPage setPrice(SearchPage page, Integer minPrice, Integer maxPrice){
        page.setMinimumPrice(minPrice).setMaximumPrice(maxPrice)
                .priceSumit();
        return page;
    }

    public static ProductPage setProducer(SearchPage page, String producer)throws NotExistProducerExeption, NotHaveProductsExeption{
        return page.chooseProducer(producer);
    }

}
