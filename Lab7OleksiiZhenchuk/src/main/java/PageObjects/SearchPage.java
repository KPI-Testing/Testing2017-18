package PageObjects;

import Elements.*;
import org.openqa.selenium.*;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import Utillities.Waiters;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;


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
    
    @FindBy(className="g-price-uah")
    private List<WebElement> goodPrices;

    @FindBys(
            @FindBy(xpath = "//*[@id='sort_strana-vino']/li/label")
    		//@FindBy(xpath = "//*[@id='sort_strana-proizvoditelj-tovara-103660_']/li/label")
    )
    List<HtmlLabel> filterLables;

    private HtmlLabel filterLable;

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
    
    public boolean checkPrices(Integer inMinPrice, Integer inMaxPrice) {
    	/*boolean inRange = true;
    	int i=0;
    	for (WebElement realPrice : goodPrices){
    		i=Integer.parseInt(realPrice.getText().replaceAll("\\D", "").trim());
    		if (i<inMinPrice || i>inMaxPrice) inRange = false;
    	}*/
    	return (Integer.parseInt(minPrice.getAttribute("value"))==inMinPrice && Integer.parseInt(maxPrice.getAttribute("value"))==inMaxPrice);
    }

    public SearchPage priceSumit(){
        submitPriceButton.sendKeys(Keys.ENTER);
        return this;
    }

    public ProductPage chooseProduser(String producer) {
    	//System.out.println("Button1");
        int current = -1;
        //System.out.println("Button2");
        Waiters.threadsleep(1000);
        for (int i = 0; i < filterLables.size(); i++) {
            if (filterLables.get(i).getLableName().equalsIgnoreCase(producer.trim())){
                current = i;
                break;
            }
        }
        //System.out.println("Button4");
        if(current == -1){
        	System.out.println("It seems to be no producer country option you called!");
        }
        else {
        	//System.out.println("Button3");
            filterLable = filterLables.get(current);
            WebElement prodBox = filterLable.findElement(By.tagName("a"));
            Waiters.threadsleep(1000);
            prodBox.click();
        }
        System.out.println("Button");
        Waiters.waitUrlContain(getDriver(), "strana", 10000, 250);
        if(getDriver().findElement(By.cssSelector(".filter-parametrs-i-l-i-text.filter-parametrs-i-l-i-checkbox-active.sprite-side > i")).getText().trim().equalsIgnoreCase(producer))
        	System.out.println("The producer was set correctly");
        else
        	System.out.println("Oops! The producer wasn't set correctly");
        By linksXpath = new By.ByXPath("//*[@id='catalog_goods_block']/div/div/div/div/div/div/*[@class='g-i-tile-i-title clearfix']/a");
        List<WebElement> links = getDriver().findElements(linksXpath);
        Random rnd = new Random(System.currentTimeMillis());
        int pageNum = rnd.nextInt(links.size());
        System.out.println("We are randomly going to the product No " + pageNum);
        System.out.println("That is: " + links.get(pageNum).getText().trim());
        Waiters.waitClickableAndDisplayed(getDriver(), links.get(pageNum), 10000, 250);
        links.get(pageNum).click();
        
        return new ProductPage(getDriver());
    }

}