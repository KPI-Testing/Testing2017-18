package contexts;
import pages.*;

public class FiltrActions {


    public static SearchPage setPrice(SearchPage page, Integer minPrice, Integer maxPrice){
        page.setMinimumPrice(minPrice).setMaximumPrice(maxPrice)
                .priceSumit();
        return page;
    }

    public static ProductPage setProducer(SearchPage page, String producer){

        return page.findCountry(producer);
    }

}
