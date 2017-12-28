package contexts.actions;

import org.openqa.selenium.By;
import pages.CheckOut;
import pages.ProductPage;
import utils.Waiters;

public class BuyProduct {
    public static ProductPage buyProduct(ProductPage page) {
        page.getBuyButton().click();
        return page;

    }
    /*public static CheckOut submitOrder(ProductPage page){
        By by = new By.ByCssSelector("#popup-checkout");
        Waiters.thredsleep(2000);
        page.setSubmitButton(page.getDriver().findElement(by));
        page.getSubmitButton().click();
        return new CheckOut(page.getDriver());
    }*/
}
