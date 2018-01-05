package contexts;

import pages.Search_Page;
import waiters.Wait;

public class Context_Filtering {
    public static void filter_by_Price(Search_Page page, int minPrice, int maxPrice){
        filter_set_Price(page, minPrice, maxPrice);
        filter_submit_Price(page);
    }

    private static void filter_set_Price(Search_Page page, int min_Price, int max_Price){
        page.set_Min_Price(min_Price);
        page.set_Max_Price(max_Price);
    }

    private static void filter_submit_Price(Search_Page page){
        page.submit_Price.click();
        Wait.wait_for_Loading(page.getDriver(), Wait.WAIT_Amount_of_Seconds, page.progress_Bar);
    }

    public static void filter_by_Country(Search_Page page, String country){
        page.set_Country(country);
        Wait.wait_for_Loading(page.getDriver(), Wait.WAIT_Amount_of_Seconds,page.progress_Bar);
    }

}
