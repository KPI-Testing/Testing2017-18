package pages.frameworks;

import com.google.common.base.Predicate;
import com.sun.istack.internal.Nullable;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Rozetka {

    private WebDriver driver;

    public Rozetka(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "price[min]")
    private WebElement MinPrice;

    @FindBy(id = "price[max]")
    private WebElement MaxPrice;

    @FindBy(css = "#submitprice")
    private WebElement SubmitPriceButton;

    @FindBy(css = "#catalog_goods_block > div > div.g-i-tile.g-i-tile-catalog.preloader-trigger > a")
    private WebElement Next;

    private List<WebElement> Prices;


    public Rozetka setMinimumPrice(Integer price){
        if(price == null) return this;
        MinPrice.sendKeys(price.toString());
        return this;
    }

    public Rozetka PriceSubmit(){
        SubmitPriceButton.sendKeys(Keys.ENTER);
        return this;
    }

    public void Convert(ArrayList Item){
        final By by = new By.ByClassName("g-price-uah");
        new WebDriverWait(driver,25,10 )
                .ignoring(StaleElementReferenceException.class)
                .until(new Predicate<WebDriver>() {
                    public boolean apply(WebDriver driver) {
                        Prices = driver.findElements(by);
                        return true;
                    }
                });
        for (WebElement temp:Prices){
            Item.add(temp.getText());
        }
    }


}
