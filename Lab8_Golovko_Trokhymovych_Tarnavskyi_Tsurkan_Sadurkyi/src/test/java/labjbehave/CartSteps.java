package labjbehave;

import contexts.*;
import extensions.ChromeDriverEx;
import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CartPage;
import pages.ItemPage;
import pages.SledgesPage;
import waiters.Waiters;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static contexts.CartContext.goToCatalogue;

public class CartSteps extends Steps {
    private int x;
    private static String driverPath = "C:\\chromedriver\\chromedriver.exe";
    private static ChromeDriverEx driver;
    private static SledgesPage sledgesPage;
    private static ItemPage itemPage;
    private static CartPage cartPage;
    private static ArrayList<String> itemName;

    @BeforeStory
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", driverPath);
    }

    @BeforeScenario
    public void beforeScenario() throws Exception {
        driver = new ChromeDriverEx();
        Waiters.waitImplicit(driver, Waiters.WAIT_10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        itemName = new ArrayList<String>();
    }

    @AfterScenario
    public void afterScenario(){
        driver.quit();
    }

    @Given("opened catalog with empty cart")
    public void openedSearchPageWithEmptyCart(){
        sledgesPage = new SledgesPage(driver);
    }

    @Given("opened catalog with cart fulfilled with quantity $quantity of first element from catalog")
    public void openedSearchPageWithCartFulfilled(@Named("quantity") int quantity){
        openedSearchPageWithEmptyCart();
        selectPosition(1);
        clickBuy();
        inputQuantity(quantity);
        whenopenedSearchPageWithBucketStatus();
    }

    @When("opened catalog with empty cart")
    public void whenopenedSearchPageWithBucketStatus(){
        sledgesPage = CartContext.goToCatalogue(cartPage);
    }

    @When("select item $number")
    public void selectPosition(@Named("number") int number){
        itemPage = ResultsSetContext.selectElement(sledgesPage, number-1);
    }

    @When("click \"Buy\"")
    public void clickBuy(){
        String currentItemName = ItemShoppingContext.getName(itemPage);
        if (!itemName.contains(currentItemName))
            itemName.add(currentItemName);
        cartPage = ItemShoppingContext.buy(itemPage);
    }

    @When("click on cart button on menu bar")
    public void clickCart(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cartPage = CartContext.clickBucket(sledgesPage);
    }

    @When("go to catalog")
    public void clickBackToCatalogButton(){
        sledgesPage = CartContext.clickBackToCatalog(itemPage);
    }

    @When("click $number times + button")
    public void clickPlusButton(@Named("number") int number){
        CartContext.addItem(cartPage, 0, number);
    }

    @When("click $number times - button")
    public void clickMinusButton(@Named("number") int number){
        CartContext.minusItem(cartPage, 0, number);
    }

    @When("input quantity $quantity")
    public void inputQuantity(@Named("quantity") int quantity) {
        CartContext.inputQuantity(cartPage,quantity);
    }

    @When("click on \"Continue purchase\" button")
    public void clickContinuePurchaseButton(){
        itemPage = CartContext.clickContinuePurchase(cartPage);
    }

    @When("click \"delete from cart\"")
    public void deleteAllElements(){
        cartPage = CartContext.clearCartPage(cartPage);
    }


    @Then("Cart displays \"Cart is empty\"")
    public void checkEmpyCart(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(CartContext.getSize(cartPage) == 0);
    }

    @Then("item at position $position has quantity $quantity")
    public void validateParameter(@Named("quantity") int quantity, @Named("position") int position){
        CartContext.assertQuantity(cartPage, position-1, quantity);
    }

    @Then("item name is the same as it was on the item's page")
    public void compareName(){
        int len = cartPage.getNumberOfPositions();
        for (int i=0; i<len; ++i){
            CartContext.assertName(cartPage, i, itemName.get(len-i-1));
        }
    }

    @Then("calculations are correct")
    public void checkCorectnessOfCalculations(){
        CartContext.assertCalculations(cartPage);
    }

    @When("click element`s $number \"cart button\"")
    public void clickElementCart(@Named("number") int number) {
        cartPage = ResultsSetContext.buyElement(sledgesPage, number-1);
    }
}