package Contexts;

import Elements.CheckBox;
import PageObjects.FictionBook;
import Waiter.Waiter;


public class Filter {
    public static void filterByRange(FictionBook page, int min, int max){
        submitFilter(setFilterRange(page, min, max));
        Waiter.Wait(5000);
    }

    private static FictionBook setFilterRange(FictionBook page, int min, int max){
        page.set_min_price(min);
        page.set_max_price(max);
        return page;
    }

    private static void submitFilter(FictionBook page){
        page.submit_filter_price();
    }

    private static boolean verifyMin(FictionBook page, Integer min){
        return Integer.parseInt(page.getMinPrice()) >= min;
    }

    private static boolean verifyMax(FictionBook page, Integer max){
        return Integer.parseInt(page.getMaxPrice()) <= max;
    }

    public static boolean verifyRange(FictionBook page, Integer min, Integer max){
        return verifyMin(page, min) && verifyMax(page, max);
    }

    public static void filterByCountry(FictionBook page, String country){
        for(CheckBox iter: page.getProducers()) {
            if (iter.getText().contains(country) && (!isChecked(iter))) {
                iter.click();
                break;
            }
        }
        Waiter.Wait(5000);
    }

   private static boolean isChecked(CheckBox label){
            return label.isSelected();//isExisting(label.findElement(By.xpath(".//input[@checked]")));
    }

    public static boolean producerIsChecked(FictionBook page) {
        for(CheckBox iter : page.getProducers()) {
            if (iter.isChecked())
                return true;
        }
        return false;
    }
}
