package pages.frameworks;

import com.google.common.base.Predicate;
import com.sun.istack.internal.Nullable;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Rozetka {

    private WebDriver driver;
    private static long waitLimit;

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

    @FindBy(id = "submitprice")
    public WebElement filterByPrice;

    @FindBy(how = How.XPATH, using = "//*[@id=\"sort_view\"]/a")
    public WebElement sort;

    @FindBy(how = How.XPATH, using = "//*[@id=\"filter_sortcheap\"]/a")
    public WebElement sortCheap;

    @FindBy(how = How.XPATH, using = "//body/div[3]")
    public WebElement progressBar;

    private List<WebElement> Prices;


    public Rozetka setMinPrice(int price){
        MinPrice.clear();
        MinPrice.sendKeys(Integer.toString(price));
        return this;
    }

    public Rozetka submitPriceFilter(){
        filterByPrice.sendKeys(Keys.ENTER);
        return this;
    }

    public int getMinPrice(){
        String stringValue = MinPrice.getAttribute("value");
        return Integer.parseInt(stringValue);
    }

    public int getMaxPrice(){
        String stringValue = MaxPrice.getAttribute("value");
        return Integer.parseInt(stringValue);
    }

    public List<Integer> getActulSetOfPrices(){
        List<WebElement> prices = driver.findElements(By.className("g-price-uah"));
        List<Integer> intPrices = new LinkedList<Integer>();
        for (WebElement element: prices) {
            String stringPrice = element.getText().replaceAll(" грн", "").replaceAll(" ","");
            intPrices.add(Integer.parseInt(stringPrice));
        }
        return intPrices;
    }

    public Rozetka applySort(String howToSort) {
        if (howToSort.equals("cheap")){
            sort.click();
            sortCheap.click();
            return this;
        }
        else
            return null;
    }

    public Rozetka setWaitLimit(long value) {
        waitLimit = value * 1000;
        return this;
    }


    public Rozetka waitLoading() throws TimeoutException{
        boolean loading = !progressBar.getAttribute("class").contains("hidden");
        long start = System.currentTimeMillis();
        while(loading){
            loading = !progressBar.getAttribute("class").contains("hidden");
            if (start - System.currentTimeMillis() > waitLimit){
                throw new TimeoutException();
            }
        }
        return this;
    }


}
