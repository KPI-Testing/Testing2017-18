package Context;

import PageObject.RozetcaFiltersPage;

public class Filtering {
    public static void filter_by_Price(RozetcaFiltersPage page, String minPrice, String  maxPrice){
        filter_set_Price(page, minPrice, maxPrice);
        filter_submit_Price(page);
    }

    private static void filter_set_Price(RozetcaFiltersPage page, String  min_Price, String  max_Price){
        page.min_price_filter(min_Price);
        page.max_price_filter(max_Price);
    }

    private static void filter_submit_Price(RozetcaFiltersPage page){
        page.submit_price_filter();
    }

    public static void filter_by_Country(RozetcaFiltersPage page, String country){
        page.set_Country(country);

    }
}
