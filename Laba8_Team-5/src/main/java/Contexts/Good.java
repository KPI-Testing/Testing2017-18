package Contexts;

import PageObjects.BasketPage;
import PageObjects.GoodPage;
import Waiter.Waiter;

public class Good {
    public static BasketPage buyGood(GoodPage page){
        page.buy_good();
        Waiter.Wait(1000);
        return new BasketPage(page.driver);
    }
}
