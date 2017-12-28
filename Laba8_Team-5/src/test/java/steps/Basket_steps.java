package steps;

import Contexts.Basket;
import Driver.DriverSingleton;
import PageObjects.BasketPage;
import PageObjects.Rozetka;


import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static Contexts.Basket.*;
import static Contexts.RozetkaAct.buySomething;
import static Contexts.RozetkaAct.goToBasket;
import static Driver.DriverSingleton.driverClose;
import static Elements.Element.isExisting;
import static Waiter.Waiter.Wait;

public class Basket_steps {
    private WebDriver driver;
    @Given("^Browser \"([^\"]*)\" is opened$")
    public void browserIsOpened(String browser){
        driver = DriverSingleton.getInstance(browser);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Given("^Website \"([^\"]*)\" is opened$")
    public void websiteIsOpened(String url) {
        driver.get(url);
    }

    @When("^I click on \"([^\"]*)\"$")
    public void clickOn(String button){
        Rozetka page = new Rozetka(driver);
        if (button.equals("basket")){
            goToBasket(page);
        }
       else{
            buySomething(page, button);
        }
    }

    @Then("^The basket is \"([^\"]*)\"$")
    public void basketIs(String flag){
        BasketPage page = new BasketPage(driver);
        if (flag.equals("opened")){
            Assert.assertTrue(isExisting(page.getPage()));}
        if (flag.equals("closed")){
            Assert.assertFalse(isExisting(page.getPage()));
            Wait(1000);
        }
    }

    @Then("^Good \"([^\"]*)\" is in basket$")
    public void goodIsInBasket(String good){
        BasketPage page = new BasketPage(driver);
        Assert.assertTrue(isOnPage(page,good));
        Wait(5000);
    }

    @Then("^Good \"([^\"]*)\" not in basket$")
    public void goodNotInBasket(String good) throws Throwable {
        BasketPage page = new BasketPage(driver);
        Assert.assertFalse(isOnPage(page, good));
    }

    @Then("^Browser is closed$")
    public void browserIsClosed(){
        driverClose(driver);
    }


    @When("^I click plus to add one more$")
    public void clickPlusToAddOneMore() throws Throwable {
        BasketPage page = new BasketPage(driver);
        addOneMore(page);
    }

    @When("^I click minus to delete one copy$")
    public void clickMinusToDeleteOne() throws Throwable {
        BasketPage page = new BasketPage(driver);
        deleteOne(page);}

    @Then("^Number of items is (\\d+)$")
    public void numberOfItemsIs(int number) throws Throwable {
        BasketPage page = new BasketPage(driver);
        Assert.assertTrue(numberOfItem(page) == number);
    }

    @And("^I set number of goods (\\d+)$")
    public void setNumberOfGoods(int numberOfGoods) throws Throwable {
        BasketPage page = new BasketPage(driver);
        setNumberOfItem(page, Integer.toString(numberOfGoods) );
    }

    @And("^I close basket$")
    public void closeBasket() throws Throwable {
        BasketPage page = new BasketPage(driver);
        Basket.closeBasket(page);
        Wait(1000); }

    @Then("^Basket is empty$")
    public void basketIsEmpty(){
        BasketPage page = new BasketPage(driver);
        Assert.assertTrue(emptyBasket(page));
    }

    @And("^I delete \"([^\"]*)\"$")
    public void delete(String item) throws Throwable {
        BasketPage page = new BasketPage(driver);
        deleteItem(page, item);
    }

    @Then("^The price is (\\d+)$")
    public void priceIs(int number) throws Throwable {
        BasketPage page = new BasketPage(driver);
        Assert.assertTrue(priceIsCorrect(page, number));
    }
}
