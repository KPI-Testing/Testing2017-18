package contexts.actions;
import pages.*;

public class Filtering {


    public static SearchPage setPrice(SearchPage page, Integer minPrice, Integer maxPrice){
        page.setMinimumPrice(minPrice).setMaximumPrice(maxPrice)
                .priceSumit();
        return page;
    }

    public static ProductPage setProducer(SearchPage page, String producer){

        return page.chooseProducer(producer);
    }

}
