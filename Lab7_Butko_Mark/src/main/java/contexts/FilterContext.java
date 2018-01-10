package contexts;

import pages.SearchPage;
import util.Waiters;

public class FilterContext {

    public static void setPriceRange(SearchPage searchPage, Integer min, Integer max){
        searchPage.setMinPrice(min);
        searchPage.setMaxPrice(max);
        searchPage.getPriceButton().click();
        Waiters.waitForVisibilityByXpath(searchPage.getDriver(), "//*[@id=\"filter_parameters_form\"]/div[4]");
    }

    public static void setCountry(SearchPage searchPage, String country){
        searchPage.setCountry(country);
        Waiters.waitForVisibilityByXpath(searchPage.getDriver(), "//*[@id=\"filter_parameters_form\"]/div[4]");
    }
}
