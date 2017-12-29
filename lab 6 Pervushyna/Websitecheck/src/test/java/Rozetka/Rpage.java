package Rozetka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.Keys;


public class Rpage {
    private WebDriver driver;

    public Rpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "price[min]")
    private WebElement minval;


    public Rpage minPrice(int price) {
        minval.sendKeys(Integer.toString(price));
        return this;
    }

    @FindBy(id = "submitprice")
    private WebElement filter;


    public Rpage Filter() {
        filter.sendKeys(Keys.ENTER);
        return this;
    }

    public int getMinPrice() {
        return Integer.parseInt(minval.getAttribute("value"));
    }


}