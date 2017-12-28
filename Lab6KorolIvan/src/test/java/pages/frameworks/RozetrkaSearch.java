package pages.frameworks;

import com.google.common.base.Predicate;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class RozetrkaSearch {

    private ChromeDriverEx driver;

    public RozetrkaSearch(ChromeDriverEx driver){
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


    public RozetrkaSearch setMinimumPrice(Integer price){
        if(price == null) return this;
        MinPrice.sendKeys(price.toString());
        return this;
    }

    public RozetrkaSearch setMaximumPrice(Integer price){
        if(price == null) return this;

        for(int i = 0; i < 10; i++ ){
            MaxPrice.sendKeys(Keys.BACK_SPACE);
        }
        MaxPrice.sendKeys(price.toString());
        return this;
    }

    public RozetrkaSearch PriceSumit(){
        SubmitPriceButton.sendKeys(Keys.ENTER);
        return this;
    }

    public Integer GetMinPrice(){
        String MinPriceValue = MinPrice.getAttribute("value");
        if(MinPriceValue == null | MinPriceValue == "") return null;
        else {
            return Integer.parseInt(MinPriceValue);
        }
    }
    public Integer GetMaxPrice(){
        String MaxPriceValue = MaxPrice.getAttribute("value");
        if(MaxPriceValue == null | MaxPriceValue == "") return null;
        else {
            return Integer.parseInt(MaxPriceValue);
        }
    }

    public boolean hasNext(){
        By locator = new By.ByCssSelector("#catalog_goods_block > div > div.g-i-tile.g-i-tile-catalog.preloader-trigger > a > span");
        if(Methods.Find(driver,locator)){
            return true;
        }
        else return false;
    }
    public void Druk(List Item){
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
