package PageObjects;

import elements.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import utillites.Waiters;

import java.util.List;
import java.util.Random;


public class SearchPage extends BasePage {

    public SearchPage (WebDriver driver){
        super(driver);
    }

    public SearchPage start(String url){
        getDriver().get(url);
        return this;
    }
    @FindBy(xpath = "//body/div[3]")
    @CacheLookup
    public WebElement progressBar;

    @FindBy(id = "price[min]")
    private TextField minPrice;

    @FindBy(id = "price[max]")
    private TextField  maxPrice;

    @FindBy(id = "submitprice")
    private WebElement submitPriceButton;

    @FindBys(@FindBy(xpath = "//*[@id='sort_strana-proizvoditelj-tovara-103660_']/li/label"))
    List<HtmlLabel> List;
    private HtmlLabel First;


   /* private SearchPage more(){
        By by = new By.ByCssSelector("#filter_parameters_form > div:nth-child(2) > div.pos-fix > a:nth-child(2)");
        Waiters.waitClickable(getDriver(), by, 5000, 5);
        WebElement clickYet = getDriver().findElement(by);
        clickYet.click();
        return this;
    }*/

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
        int current = -1;
        for (int i = 0; i < List.size(); i++) {
            if (List.get(i).getLableName().equalsIgnoreCase(producer.trim())){
                current = i;
                break;
            }
        }
        First = List.get(current);
        First.click();
        System.out.println(current);

        By linksXpath = new By.ByXPath("//*[@id='catalog_goods_block']/div/div/div/div/div/div/*[@class='g-i-tile-i-title clearfix']/a");
        Waiters.waitClickable(getDriver(), linksXpath, 5000, 5);
        List<WebElement> links = getDriver().findElements(linksXpath);
        links.get(0).click();
        System.out.println(links.size());
        return new ProductPage(getDriver());
    }

}
