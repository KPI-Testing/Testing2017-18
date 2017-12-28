package contexts.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import pages.Basket;
import pages.SearchPage;
import utils.Waiters;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasketActions {

    public static Basket AddingGoodInBasket(SearchPage page, int index)
    {
         page.getButtonsAddToBasket().get(index).click();
         return new Basket(page.getDriver());
    }

    public static Basket AddingGoodInBasket(SearchPage page, int index, List<String> names) throws InterruptedException {
        By byName = new By.ByCssSelector(".g-i-tile-i-title.clearfix");
        names.add(page.getMiniPages().get(index).findElement(byName).getText());
        By byAdd = new By.ByName("buy_catalog_small");
        page.getMiniPages().get(index).findElement(byAdd).click();
        return new Basket(page.getDriver());
    }

    public static Basket PlusOneGood(Basket page) throws InterruptedException {
        page.plusOne();
        return page;
    }

    public static Basket MinusOneGood(Basket page) throws InterruptedException {
        page.minusOne();
        return page;
    }

    public static Basket openBasket(Basket page){
        page.getOpenBasket().click();
        return page;
    }

    public static void closeBasket(Basket page){
        page.getCloseBasket().click();
    }

    public static SearchPage closeAndReturnStart(Basket page) throws InterruptedException {
        Thread.sleep(2000);
        page.getDriver().navigate().to(SearchPage.RURL);
        Thread.sleep(2000);
        return new SearchPage(page.getDriver());
    }

    public static Basket clickOnCross(Basket page, int numberToDelete) throws InterruptedException {
        Thread.sleep(2000);
        page.getCrossButtons().get(numberToDelete).click();
        return page;
    }

    public static Basket clickOnWithoutSaving(Basket page) {
        Waiters.waitClickableAndDisplayed(page.getDriver(), page.getDeleteWithoutSaving(), 2);
        page.getDeleteWithoutSaving().click();
        return page;
    }

    public static Basket enterQuantity(Basket page, String value){
        Waiters.waitClickableAndDisplayed(page.getDriver(),page.getQuanity(), 5 );
        page.getQuanity().setValue(value);
        page.getQuanity().sendKeys(Keys.ENTER);
        return page;
    }

    public static int basketSize(Basket page)
    {
        return  page.getTitleNames().size();
    }

    public static int sumOfThePrice(Basket page, int index){
        Waiters.waitClickableAndDisplayed(page.getDriver(),page.getPriceOfTheGoods().get(index),2);
        return Integer.parseInt(page.getPriceOfTheGoods().get(index).getText().replaceAll("грн","").trim());
    }

    public static int calculateSumOfTheGood(Basket page) throws InterruptedException {
        int sumprice = 0;
        Thread.sleep(2000);
        for(int i=0; i <basketSize(page);i++) {
            sumprice += Integer.parseInt(page.getSumPrice().get(i).getText());
        }
        return sumprice;
    }


    public static boolean containsProduct(Basket page, String product){
        Waiters.waitList(page.getDriver(), page.getTitleNames(), 3);
        for (WebElement element:
             page.getTitleNames()) {
            if(element.getText().toLowerCase().contains(product.toLowerCase())) {
                return true; }
        }
        return false;
    }

    public static boolean containsProduct(Basket page,List<String> products){
        Waiters.waitList(page.getDriver(), page.getTitleNames(), 3);
        int n = page.getTitleNames().size();
        for (int i = 0; i < page.getTitleNames().size(); i++) {
            if(!page.getTitleNames().get(i).getText().equalsIgnoreCase(products.get(n - i - 1))){
                return false;
            }
        }
        return true;
    }




}
