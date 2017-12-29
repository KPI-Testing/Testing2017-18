package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class RozetkaPage {

    private WebDriver driver;

    public RozetkaPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "price[min]")
    private WebElement MinPrice;

    @FindBy(id = "price[max]")
    private WebElement MaxPrice;

    @FindBy(css = "#submitprice")
    private WebElement SubmitPriceButton;
    
    @FindBy(className="g-price-uah")
    private List<WebElement> goodPrices;

    private List<WebElement> Prices;

    public RozetkaPage setMinimumPrice(Integer price){
        if(price == null) return this;
        MinPrice.sendKeys(price.toString());
        return this;
    }

    public RozetkaPage setMaximumPrice(Integer price){
        if(price == null) return this;

        for(int i = 0; i < 10; i++ ){
            MaxPrice.sendKeys(Keys.BACK_SPACE);
        }
        MaxPrice.sendKeys(price.toString());
        return this;
    }

    public RozetkaPage priceSubmit(){
        SubmitPriceButton.sendKeys(Keys.ENTER);
        return this;
    }

    public Integer getMinPrice(){
        String MinPriceValue = MinPrice.getAttribute("value");
        if(MinPriceValue == null | MinPriceValue == "") return null;
        else {
            return Integer.parseInt(MinPriceValue);
        }
    }
    
    public Integer getMaxPrice(){
        String MaxPriceValue = MaxPrice.getAttribute("value");
        if(MaxPriceValue == null | MaxPriceValue == "") return null;
        else {
            return Integer.parseInt(MaxPriceValue);
        }
    }
    
    public boolean setCheck(Integer minPrice) {
    	boolean notSmaller = true;
    	for (WebElement realPrice : goodPrices){
    		if (Integer.parseInt(realPrice.getText().replaceAll("\\D", "").trim())<minPrice) notSmaller = false;
    	}
    	return notSmaller;
    }
    
    public void getGoodPricesTo(List<String> result) {
    	result.clear();
    	for (WebElement realPrice : goodPrices) {
    		result.add(realPrice.getText().replaceAll("\\D", "").trim());
    	}
    }
}