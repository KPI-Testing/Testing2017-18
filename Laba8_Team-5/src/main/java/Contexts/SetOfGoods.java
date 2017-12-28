package Contexts;

import PageObjects.FictionBook;
import PageObjects.GoodPage;

public class SetOfGoods {
    public static GoodPage clickOnGood(FictionBook page, int index){
        page.click_on_result(index);
        return new GoodPage(page.driver);
    }
}
