package contexts;

import pages.SledgesPage;
import waiters.Waiters;

public class FilteringContext {
    public static void filterByPriceRange(SledgesPage page, int minPrice, int maxPrice){
        setPrice(page, minPrice, maxPrice);
        submitPriceFilter(page);
    }

    public static void filterByCountry(SledgesPage page, String country){
        page.setCountry(country);
        Waiters.waitForLoading(page.getDriver(),Waiters.WAIT_10,page.progressBar);
    }

    private static void setPrice(SledgesPage page, int minPrice, int maxPrice){
        page.setMinPrice(minPrice);
        page.setMaxPrice(maxPrice);
    }

    private static void submitPriceFilter(SledgesPage page){
        page.submitPrice.click();
        Waiters.waitForLoading(page.getDriver(), Waiters.WAIT_10, page.progressBar);
    }
}
