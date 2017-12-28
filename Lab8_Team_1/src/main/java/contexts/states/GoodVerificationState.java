package contexts.states;

import contexts.actions.BasketActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.Basket;
import pages.CheckOut;
import utils.Waiters;

import java.util.List;

import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;
import static com.thoughtworks.selenium.SeleneseTestNgHelper.assertEquals;


public class GoodVerificationState {
    public static boolean VerifyMakeOrderIsDisplayed(CheckOut page)
    {
       return page.getMakeOrder().isDisplayed();
    }

    public static void VerifyPlusOneGood(Basket page, int value)
    {
        assertEquals(page.getvalue(), value);
    }

    public static void VerifyMinusOneGood(Basket page, int value)
    {
        assertEquals(page.getvalue(), value);
    }

    public static void basketSize(Basket page, int value) throws InterruptedException {
        Thread.sleep(2000);
        assertEquals(BasketActions.basketSize(page),value);
    }

    public static void basketIsOpened(Basket page) throws InterruptedException {
        Thread.sleep(2000);
        assertTrue(page.getAllPage().isDisplayed());
    }

    public static void basketIsClosed(Basket page) throws InterruptedException {
        Thread.sleep(1000);
        assertTrue(!page.getAllPage().isDisplayed());
    }

    public static void calculateSum(Basket page, int quantiny,int index) throws InterruptedException {

        assertEquals(BasketActions.sumOfThePrice(page,index)*quantiny, BasketActions.calculateSumOfTheGood(page));
    }

    public static void textFieldvalue(Basket page, String value)
    {
        assertEquals(page.getvalue(), value);
    }

    public static void wholePriceIsCorrect(Basket page) throws InterruptedException {
        Waiters.waitClickableAndDisplayed(page.getDriver(),page.getWholePrice(), 2000);
        assertEquals(Integer.parseInt(page.getWholePrice().getText()), BasketActions.calculateSumOfTheGood(page));
    }

    public static void productInBascket(Basket page, String name){
        assertTrue(BasketActions.containsProduct(page, name));
    }

    public static void checkOrderNames(Basket page, List<String> names){
        assertTrue(BasketActions.containsProduct(page, names));
    }
}
