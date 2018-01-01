package Rozetka_task;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Rozetka {
    private WebDriver driver ;
    public Rozetka(WebDriver driver ) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "price[min]")
    private WebElement Min;

    @FindBy(id = "price[max]")
    private WebElement Max;

    public Rozetka maxPrice(int price) {
        Min.sendKeys(Integer.toString(price));
        return this;
    }

    public Rozetka minPrice(int price) {
        Min.sendKeys(Integer.toString(price));
        return this;
    }
    @FindBy(id="submitprice")
    private WebElement filter;
    public Rozetka Filter() {
        filter.click();
        return this;
    }
    public int getMinPrice() {
        return Integer.parseInt(Min.getAttribute("value"));
    }

}

