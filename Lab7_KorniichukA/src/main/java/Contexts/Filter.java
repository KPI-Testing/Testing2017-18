package Contexts;

import Pageobj.SearchPage;
import Pageobj.ProductPage;

public class Filter {

    public static SearchPage set_price(SearchPage page, Integer min_pr, Integer max_pr){
        page.set_min_price(min_pr).set_max_price(max_pr).price_submit();
        return page;
    }

    public static ProductPage set_country(SearchPage page, String country){
        return page.choose_manufacturer(country);
    }
}