package pages;

import elements.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import utill.Waiters;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class SearchPage extends BasePage {
    public static final By PAGE_LOADED = new By.ById("catalog_title_block");

    public SearchPage (WebDriver driver){
        super(driver);
    }

    public SearchPage start(String url){
        getDriver().get(url);
        return this;
    }

    @FindBy(id = "price[min]")
    private TextField minPrice;

    @FindBy(id = "price[max]")
    private TextField  maxPrice;

    @FindBy(id = "submitprice")
    private WebElement submitPriceButton;

    @FindBys(
            @FindBy(xpath = "//*[@id='sort_producer']/li/label")
    )
    List<HtmlLabel> myFirstLables;

    private HtmlLabel myFirstLable;

    private SearchPage yet(){
        By by = new By.ByCssSelector("#filter_parameters_form > div:nth-child(2) > div.pos-fix > a:nth-child(2)");
        Waiters.waitClickable(getDriver(), by, 5000, 5);
        WebElement clickYet = getDriver().findElement(by);
        Waiters.thredsleep(2000);
        clickYet.click();
        return this;
    }

    public SearchPage  setMinimumPrice(Integer price){
        if(price == null) return this;
        else {
            minPrice.setValue(price.toString());
            return this;
        }
    }

    public SearchPage  setMaximumPrice(Integer price){
        if(price == null) return this;
        else {
            maxPrice.setValue(price.toString());
            return this;
        }
    }

    public SearchPage  priceSumit(){
        submitPriceButton.sendKeys(Keys.ENTER);
        return this;
    }

    public ProductPage chooseProducer(String producer){
        yet();
        int current = -1;
        for (int i = 0; i < myFirstLables.size(); i++) {
            if (myFirstLables.get(i).getLableName().equalsIgnoreCase(producer.trim())){
                current = i;
                break;
            }
        }

        if(current == -1){

        }
        else {
            myFirstLable = myFirstLables.get(current);
            myFirstLable.click();
        }
        System.out.println(current);

        By linksXpath = new By.ByXPath("//*[@id='catalog_goods_block']/div/div/div/div/div/div/*[@class='g-i-tile-i-title clearfix']/a");
        Waiters.waitClickable(getDriver(), linksXpath, 5000, 5);
        List<WebElement> links = getDriver().findElements(linksXpath);
        links.get(0).click();
        Random rnd = new Random(System.currentTimeMillis());
        System.out.println(links.size());
        return new ProductPage(getDriver());
    }

}
