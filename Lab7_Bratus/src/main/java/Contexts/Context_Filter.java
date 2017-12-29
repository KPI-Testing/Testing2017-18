package Contexts;

import Page_Objects.Search_Page;
import Waiters.Waiters;

public class Context_Filter {

    public static void Filter_By_Price(Search_Page page, int min_price, int max_price){
        set_price(page, min_price, max_price);
        filter_submit_price(page);
    }

    public static void filter_by_country(Search_Page page, String country){
        page.Set_Country(country);
        Waiters.Wait_For_Loading(page.getDriver(), Waiters.Wait_15_seconds,page.Progress_Bar);
    }
    private static void set_price(Search_Page page, int min_price, int max_price){
        page.Set_Min_Price(min_price);
        page.Set_Max_Price(max_price);
    }

    private static void filter_submit_price(Search_Page page){
        page.Submit_Price.click();
        Waiters.Wait_For_Loading(page.getDriver(), Waiters.Wait_15_seconds, page.Progress_Bar);
    }
}
