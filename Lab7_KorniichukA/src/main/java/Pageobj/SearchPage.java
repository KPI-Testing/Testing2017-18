package Pageobj;

        import Custom_elements.*;
        import org.openqa.selenium.*;
        import org.openqa.selenium.support.FindBy;
        import Utills.Waiters;
        import java.util.List;


public class SearchPage extends FirstPage {

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

    @FindBy(xpath = "//*[@id=\"filter_copy_strana-proizvoditelj-tovara-103660_580d747cee3c5_661116\"]/label")
    private HtmlLabel ukr;

    public SearchPage set_min_price(Integer price){
        if(price == null) return this;
        else {
            minPrice.set_value(price.toString());
            return this;
        }
    }

    public SearchPage set_max_price(Integer price){
        if(price == null) return this;
        else {
            maxPrice.set_value(price.toString());
            return this;
        }
    }

    public SearchPage price_submit(){
        submitPriceButton.sendKeys(Keys.ENTER);
        return this;
    }

   public ProductPage choose_manufacturer(String producer){
       Waiters.thredsleep(400);
       ukr.click();
       System.out.println("cur "+ukr);
       By linkXpath = new By.ByXPath("//*[@id=\"catalog_goods_block\"]/div/div[4]/div[1]/div/div/div/div[4]/a");
       Waiters.waitClickable(getDriver(), linkXpath, 5000, 5);
       List<WebElement> links = getDriver().findElements(linkXpath);
       links.get(0).click();
       System.out.println("links size "+links.size());

        return new ProductPage(getDriver());
    }

}