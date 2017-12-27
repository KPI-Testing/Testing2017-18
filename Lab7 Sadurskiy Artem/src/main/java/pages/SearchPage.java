package pages;

import elements.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import utill.Waiters;

import java.util.List;


public class SearchPage extends BasePage {

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
            @FindBy(xpath = "//*[@id='sort_strana-krepkie-napitki']/li/label")
    )
    List<Label> Lables;

    private Label country;


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
    private SearchPage another(){
        By by = new By.ByXPath("//*[@id='filter_parameters_form']/div[4]/div[2]/a[1]");
        Waiters.threadSleep(1000);
        WebElement another = getDriver().findElement(by);
        Waiters.threadSleep(3000);
        another.click();
        //Waiters.threadSleep(1000);
        return this;
     }
    public ProductPage findCountry(String country) {
        another();
        int counter = -1;
        for (int i = 0; i < Lables.size(); i++) {
            if (Lables.get(i).getLableName().equalsIgnoreCase(country.trim())) {
                counter = i;
                break;
            }
        }
        Waiters.threadSleep(2000);
        this.country = Lables.get(counter);
        this.country.click();
        By linksXpath = new By.ByXPath("//*[@id='catalog_goods_block']/div/div/div/div/div/div/*[@class='g-i-tile-i-title clearfix']/a");
        Waiters.threadSleep(500);
        List<WebElement> links = getDriver().findElements(linksXpath);
        Waiters.threadSleep(500);
        links.get(1).click();
        return new ProductPage(getDriver());
    }

}
