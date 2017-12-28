package steps;

import contexts.actions.BasketActions;
import contexts.actions.BuyProduct;
import contexts.actions.Filtering;
import contexts.actions.MakeOrder;
import contexts.states.GoodVerificationState;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.PersonData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.ArrayList;
import java.util.List;

import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;

public class StepsDefinition {
    private static WebDriver driver;
    public static String RURL = "https://rozetka.com.ua/ua/vino/c4594285/filter/";
    public static List<String> productNames = new ArrayList<String>();
    Finish deliverProduct = null;

    @Given("^browser is opened$")
    public void browser_is_opened() throws Throwable {
        String exePath = "C:\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        driver = new ChromeDriver();
    }

    @Given("^Site \"([^\"]*)\" is opened$")
    public void site_is_opened(String arg1) throws Throwable {
        SearchPage filteringPage = new SearchPage(driver);
        filteringPage.start(RURL);
    }

    @Then("^browser is closed$")
    public void browser_is_closed() throws Throwable {
        driver.quit();
        productNames.clear();
    }

    @When("^I set price min (\\d+) and price max (\\d+)$")
    public void I_set_price_min_and_price_max(int arg1, int arg2) throws Throwable {
        SearchPage filteringPage = new SearchPage(driver);
        Filtering.setPrice(filteringPage, arg1, arg2);
    }

    @And("^I click on \"([^\"]*)\"$")
    public void I_click_on_producer(String arg1) throws Throwable {
        SearchPage filteringPage = new SearchPage(driver);
        Filtering.chooseProducer(filteringPage, arg1);

    }

    @And("^choose good of the customer \"([^\"]*)\"$")
    public void chooseGoodOfTheCustomer(String arg0) throws Throwable {
        SearchPage filteringPage = new SearchPage(driver);
        Filtering.setProduct(filteringPage, arg0);
    }

    @And("^click on button buy$")
    public void click_on_button_buy() throws Throwable {
        ProductPage choosenProduct = new ProductPage(driver);
        BuyProduct.buyProduct(choosenProduct);
    }

    @Then("^the button should be displayed$")
    public void the_button_should_be_displayed() throws Throwable {
        CheckOut checkOutProduct = new CheckOut(driver);
        deliverProduct = MakeOrder.initilizateBuy(checkOutProduct, new PersonData());
        assertTrue(GoodVerificationState.VerifyMakeOrderIsDisplayed(checkOutProduct));
        driver.quit();
    }

    @When("^I click on icon basket near price of the good$")
    public void I_click_on_icon_basket_near_price_of_the_good() throws Throwable {
        SearchPage chooseProduct = new SearchPage(driver);
        BasketActions.AddingGoodInBasket(chooseProduct,1, productNames);
    }


    @Given("^good is added to basket$")
    public void good_is_added_to_basket() throws Throwable {
        SearchPage chooseProduct = new SearchPage(driver);
        BasketActions.AddingGoodInBasket(chooseProduct,0);
    }

    @When("^click on \"([^\"]*)\"$")
    public void click_on_button(String arg1) throws Throwable {
        Basket basket = new Basket(driver);
        if(arg1.equals("+")) BasketActions.PlusOneGood(basket);
        if(arg1.equals("-")) BasketActions.MinusOneGood(basket);
    }

    @Then("^quantity of the goods should be added on (\\d+) count$")
    public void quantity_of_the_good_should_be_added_on_count(int arg1) throws Throwable {
        Basket basket = new Basket(driver);
        GoodVerificationState.VerifyPlusOneGood(basket,2);
    }

    @Then("^quantity of the goods should be \"([^\"]*)\" on (\\d+) count$")
    public void quantityOfTheGoodsShouldBeOnCount(String arg0, int arg1) throws Throwable {
        Basket basket = new Basket(driver);
        if(arg0.equals("added"))GoodVerificationState.VerifyPlusOneGood(basket,2);
        if(arg0.equals("deleted"))GoodVerificationState.VerifyMinusOneGood(basket,1);
    }

    @And("^two or more goods is added to basket$")
    public void twoOrMoreGoodsIsAddedToBasket() throws Throwable {
        SearchPage chooseProduct = new SearchPage(driver);
        BasketActions.AddingGoodInBasket(chooseProduct,0);
        Basket basket = new Basket(driver);
        BasketActions.PlusOneGood(basket);
    }


    @When("^user add (\\d+) good to the basket$")
    public void userAddGoodToTheBasket(int arg0) throws Throwable {
        SearchPage chooseProduct = new SearchPage(driver);
        BasketActions.AddingGoodInBasket(chooseProduct,arg0,productNames);
    }

    @And("^return to previous page$")
    public void returnToPreviousPage() throws Throwable {
       Basket basket = new Basket(driver);
       BasketActions.closeAndReturnStart(basket);
    }

    @Then("^quantity of the goods in the basket should be (\\d+)$")
    public void quantityOfTheGoodsInTheBasketShouldBe(int arg0) throws Throwable {
        Basket basket = new Basket(driver);
        GoodVerificationState.basketSize(basket,arg0);
    }

    @When("^click on button cross$")
    public void clickOnButtonCross() throws Throwable {
        Basket basket = new Basket(driver);
        BasketActions.clickOnCross(basket,0);
    }

    @When("^click on button basket$")
    public void clickOnButtonBasket() throws Throwable {
        Basket basket = new Basket(driver);
        BasketActions.openBasket(basket);
    }

    @Then("^the basket is opened$")
    public void basketIsOpened() throws Throwable {
        Basket basket = new Basket(driver);
        GoodVerificationState.basketIsOpened(basket);
    }

    @Then("^basket is closed$")
    public void basketIsClosed() throws Throwable {
        Basket basket = new Basket(driver);
        GoodVerificationState.basketIsClosed(basket);
    }

    @And("^user is on basket page$")
    public void userIsOnBasketPage() throws Throwable {
        Basket basket = new Basket(driver);
        BasketActions.openBasket(basket);
    }

    @When("^click on button close$")
    public void clickOnButtonClose() throws Throwable {
        Basket basket = new Basket(driver);
        BasketActions.closeBasket(basket);
    }

    @And("^click on delete without saving$")
    public void clickOnDeleteWithoutSaving() throws Throwable {
        Basket basket = new Basket(driver);
        BasketActions.clickOnWithoutSaving(basket);
    }

    @And("^good should be deleted from the basket$")
    public void goodShouldBeDeletedFromTheBasket() throws Throwable {
        Basket basket = new Basket(driver);
        GoodVerificationState.basketSize(basket,0);
    }
    
    @When("^user enter \"([^\"]*)\" in textfield$")
    public void userEnterInTextfield(String arg0) throws Throwable {
        Basket basket = new Basket(driver);
        BasketActions.enterQuantity(basket,arg0);
    }

    @Then("^price should be increased in (\\d+) times$")
    public void priceShouldBeIncreasedInTimes(int arg0) throws Throwable {
        Thread.sleep(2000);
        Basket basket = new Basket(driver);
        GoodVerificationState.calculateSum(basket,arg0,0);
    }

    @Then("^textfield should contain \"([^\"]*)\"$")
    public void textfieldShouldContain(String arg0) throws Throwable {
        Basket basket = new Basket(driver);
        GoodVerificationState.textFieldvalue(basket,arg0);
    }

    @Then("^whole price should be added correctly$")
    public void wholePriceShouldBeAddedCorrectly() throws Throwable {
        Basket basket = new Basket(driver);
        GoodVerificationState.wholePriceIsCorrect(basket);
    }

    @Then("^the good of \"([^\"]*)\" should be displayed in the basket$")
    public void the_good_of_should_be_displayed_in_the_basket(String arg1) throws Throwable {
        Basket basket = new Basket(driver);
        GoodVerificationState.productInBascket(basket, arg1);
    }

    @Then("^the good should be displayed in the basket$")public void the_good_should_be_displayed_in_the_basket() throws Throwable {
        Basket basket = new Basket(driver);
        GoodVerificationState.checkOrderNames(basket,productNames);
    }

}
