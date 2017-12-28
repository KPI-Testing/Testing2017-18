package Rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

class FictionBook {
    private WebDriver driver;
    FictionBook(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "price[min]")
    private WebElement min_price;

    @FindBy(css = "#submitprice")
    private WebElement submit_price_button;

    private List<WebElement> prices;

    List<Integer> prices(){
        prices = driver.findElements(new By.ByClassName("g-price-uah"));
        List<Integer> int_prices = new ArrayList<Integer>(prices.size());
        for (WebElement price: prices){
             String price_s = price.getText().replaceAll("[^0-9]*", "");
             int_prices.add(Integer.parseInt(price_s));
        }
        return int_prices;
    }


    void set_min_price(Integer price){
        min_price.sendKeys(price.toString());
    }


    void submit_filter_price(){
        submit_price_button.sendKeys(Keys.ENTER);
    }

    Integer get_min_price(){
        String MinPriceValue = min_price.getAttribute("value");
        if(MinPriceValue == null | MinPriceValue.equals("")) return null;
        else {
            return Integer.parseInt(MinPriceValue);
        }
    }
}
