package Rozetka;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static java.lang.Integer.*;


public class RozetkaPage {
    protected WebDriver _driver;

    public RozetkaPage(WebDriver driver) {
        _driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="price[min]")
    private WebElement minPrice;

    @FindBy(id="price[max]")
    private WebElement maxPrice;

    @FindBy(id="submitprice")
    private WebElement filterByPrice;



    public RozetkaPage SetMinimumPrice(int price) {
        minPrice.sendKeys(Integer.toString(price));
        return this;
    }

    public RozetkaPage SetMaximumPrice(int price) {
        maxPrice.sendKeys(Integer.toString(price));
        return this;
    }

    public RozetkaPage submitPriceFilter() {
        filterByPrice.sendKeys(Keys.ENTER);
        return this;
    }


    public int getMinPrice() {
        return Integer.parseInt(minPrice.getAttribute("value"));
    }


    public int getMaxPrice() {
        return Integer.parseInt(maxPrice.getAttribute("value"));
    }


}
