package pages;

import contexts.ItemShoppingContext;
import contexts.ResultsSetContext;
import extensions.ChromeDriverEx;
import waiters.Waiters;

import java.util.concurrent.TimeUnit;

public class Cart extends Page{
    CartPage cartPage;

    public Cart(ChromeDriverEx driver) {
        super(driver);
        Waiters.waitImplicit(driver, Waiters.WAIT_10, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();

        SledgesPage sledgesPage = new SledgesPage(driver);
        ItemPage itemPage = ResultsSetContext.selectElement(sledgesPage, 0);
        cartPage = ItemShoppingContext.buy(itemPage);
    }

    public void setAmount(int numberOfItem, int quantity){

    }

    public int getPrice(int numberOfItem){
        return 100;
    }

    public int getSum(){
        return 100;
    }
}
