package Contexts;

import Elements.Html_label;
import Elements.TextField;
import PageObjects.BasketPage;
import PageObjects.ContactsPage;
import org.openqa.selenium.Keys;

import java.util.List;

import static Waiter.Waiter.Wait;
import static Waiter.Waiter.waitForClick;

public class Basket {
    public static ContactsPage confirmOrder(BasketPage page){
        page.confirmOrder();
        return new ContactsPage(page.driver);
    }


    public static void addOneMore(BasketPage page){
        waitForClick(page.get_driver(), page.getButtonPlus(), 5);
        page.getButtonPlus().click();
    }

    public static Integer numberOfItem(BasketPage page) {
        return Integer.parseInt(page.getFirstNumberOfItem().getValue());
    }

    public static void deleteItem(BasketPage page, String name){
        int i = 0;
        while (i < page.getAllLabels().size()){
            Html_label iter = page.getAllLabels().get(i);
            if (iter.getText().contains(name)) {
                page.getButtonDeleteItem().get(i).click();
                waitForClick(page.get_driver(), page.getButtonDeleteWithoutSave().get(i), 50);
                page.getButtonDeleteWithoutSave().get(i).click();
                Wait(1000);
            }
            i++;
        }
    }

    public static void deleteOne(BasketPage page){
        waitForClick(page.get_driver(), page.getButtonMinus(), 5);
        page.getButtonMinus().click();
    }

    public static boolean isOnPage(BasketPage page, String name){
        for(Html_label iter: page.getAllLabels()){
            if (iter.getText().contains(name)) return true;
        }
        return false;
    }

    public static void setNumberOfItem(BasketPage page, String value){
        page.getFirstNumberOfItem().setValue(value);
        page.getFirstNumberOfItem().sendKeys(Keys.ENTER);
        Wait(5000);
    }

    public static void closeBasket(BasketPage page) {
        waitForClick(page.get_driver(), page.getButtonCloseBasket(), 1500);
        page.getButtonCloseBasket().click();
    }


    public static boolean emptyBasket(BasketPage page){
        return page.getEmptyBasket().getText().contains("пуста");
    }

    public static boolean priceIsCorrect(BasketPage page, Integer name){
        List<TextField> prices = page.getPrices(),
                numberOfItems = page.getNumberOfItem(),
                resultPrices = page.getResultPrices();
        for(int iter = 0;iter < prices.size(); iter ++){
            if(Integer.parseInt(prices.get(iter).getText().replaceAll("[^\\d]", "")) *
                    Integer.parseInt(numberOfItems.get(iter).getValue()) !=
                    Integer.parseInt(resultPrices.get(iter).getText().replaceAll("[^\\d]", "")))
                return false;
        }
        return true;
    }
}
