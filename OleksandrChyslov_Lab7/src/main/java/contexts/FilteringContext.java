package contexts;

import pages.FridgesPage;
import utilities.Waiters;

public class FilteringContext {
    public static void filterByPriceRange(FridgesPage page, int minPrice, int maxPrice){
        setPrice(page, minPrice, maxPrice);
        submitPriceFilter(page);
    }

    public static void filterByCountry(FridgesPage page, String country){
        page.setCountry(country);
        Waiters.waitForLoading(page.getDriver(),Waiters.WAIT_10,page.progressBar);
    }

    private static void setPrice(FridgesPage page, int minPrice, int maxPrice){
        page.setMinPrice(minPrice);
        page.setMaxPrice(maxPrice);
    }

    private static void submitPriceFilter(FridgesPage page){
        page.submitPrice.click();
        Waiters.waitForLoading(page.getDriver(), Waiters.WAIT_10, page.progressBar);
    }
}
