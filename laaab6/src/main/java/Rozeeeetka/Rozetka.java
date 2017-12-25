package Rozeeeetka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.Keys;

public class Rozetka {
    private WebDriver driver ;
    public Rozetka(WebDriver driver ) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id="price[min]")
    private WebElement min;
    public Rozetka minPrice(int price) {
        min.sendKeys(Integer.toString(price));
        return this;
    }
    @FindBy(id="submitprice")
    private WebElement filter;
    public Rozetka Filter() {
        filter.sendKeys(Keys.ENTER);
        return this;
    }
    public int getMinPrice() {
        return Integer.parseInt(min.getAttribute("value"));
    }
}
