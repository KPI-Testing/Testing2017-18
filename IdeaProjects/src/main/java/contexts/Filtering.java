package contexts;

import pages.Sledges;
import waiters.Waiters;

public class Filtering {
    public static void filterByPriceRange(Sledges page, int minPrice, int maxPrice){
        setPrice(page, minPrice, maxPrice);
        submitPriceFilter(page);
    }

    public static void filterByCountry(Sledges page, String country){
        page.setCountry(country);
        Waiters.waitForLoading(page.getDriver(),Waiters.WAIT_10,page.progressBar);
    }

    private static void setPrice(Sledges page, int minPrice, int maxPrice){
        page.setMinPrice(minPrice);
        page.setMaxPrice(maxPrice);
    }

    private static void submitPriceFilter(Sledges page){
        page.submitPrice.click();
        Waiters.waitForLoading(page.getDriver(), Waiters.WAIT_10, page.progressBar);
    }
}
