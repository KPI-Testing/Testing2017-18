package contexts;

import org.testng.Assert;
import pages.*;
import waiters.Waiters;

public class CartContext {
    public static void addItem(CartPage page, int index, int times){
        for (int i = 0; i<times;++i) {
            page.plusButton.get(0).click();
            Waiters.waiterForCart(page.getDriver(), Waiters.WAIT_10);
        }
    }

    public static void minusItem(CartPage page, int index, int times){
        for (int i = 0; i<times;++i) {
            page.minusButton.get(0).click();
            Waiters.waiterForCart(page.getDriver(), Waiters.WAIT_10);
        }
    }

    public static void inputQuantity(CartPage page, int quantity) {
        page.quantity.get(0).setValue(String.valueOf(quantity));
        Waiters.waiterForCart(page.getDriver(), Waiters.WAIT_10);
        page.quantity.get(0).sendEnter();
        Waiters.waiterForCart(page.getDriver(), Waiters.WAIT_10);
    }

    public static CartPage clickBucket(SledgesPage page){
        page.buttonBucket.click();
        Waiters.waitForElement(page.getDriver(), "//div[@id=\"cart-popup\"]",Waiters.WAIT_10);
        return new CartPage(page.getDriver());
    }

    public static SledgesPage goToCatalogue(Page page){
        page.getDriver().get(SledgesPage.ROZETKA_SLEDGES_URL);
        return new SledgesPage(page.getDriver(), true);
    }

    public static ItemPage clickContinuePurchase(CartPage page){
        page.continuePurchaseButton.click();
        return new ItemPage(page.getDriver());
    }

    public static SledgesPage clickBackToCatalog(ItemPage page){
        page.backToCatalog.click();
        return new SledgesPage(page.getDriver(), true);
    }

    public static CartPage clickOnWithoutSaving(CartPage page,int numberToDelete) {
        try {Thread.sleep(1500);} catch (InterruptedException e) {e.printStackTrace();}
        page.getDeleteWithoutSaving().get(numberToDelete).click();
        return page;
    }

    public static CartPage clickOnCross(CartPage page,int numberToDelete) {
        try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
        page.getCrossButtons().get(numberToDelete).click();
        return page;
    }

    public static CartPage clearCartPage(CartPage page){
        for(int i = 0; i < page.getTitleNames().size(); i++ ){
            try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
            clickOnCross(page, i);
            clickOnWithoutSaving(page, i);
        }
        return page;
    }

    public static int getSize(CartPage page) {
        return page.getTitleNames().size();
    }

    public static void assertQuantity(CartPage page, int index, int quantity){
        assertTrueOrSendMessage("quantity at position "+index+" is incorrect", page.getQuantity(index) == quantity);
    }

    public static void assertName(CartPage page, int index, String name){
        assertTrueOrSendMessage("name at position "+index+" is incorrect. Expected is "+name+". Actual is "+page.getName(index), page.getName(index).equals(name));
    }

    public static void assertCalculations(CartPage page){
        int numberOfPositions = page.getNumberOfPositions();
        int totalSum = 0;
        for (int i = 0; i < numberOfPositions; ++i) {
            assertTrueOrSendMessage("price sum at position "+i+" is incorrect",page.getPriceOf(i) * page.getQuantity(i) == page.getSum(i));
            totalSum += page.getSum(i);
        }
        assertTrueOrSendMessage("price total sum is incorrect", page.getPrice() == totalSum);
    }

    private static void assertTrueOrSendMessage(String message, boolean statement){
        if (!statement){
            System.out.println(message);
            Assert.fail();
        }
    }
}
