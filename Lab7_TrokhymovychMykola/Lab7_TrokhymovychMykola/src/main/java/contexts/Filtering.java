package contexts;
import PageObjects.*;

public class Filtering {


    public static SearchPage setPrice(SearchPage page, Integer minPrice, Integer maxPrice){
        page.setMinimumPrice(minPrice).setMaximumPrice(maxPrice)
                .priceSumit();
        return page;
    }

    public static ProductPage setCountry(SearchPage page, String country){
        return page.chooseProducer(country);
    }

}
