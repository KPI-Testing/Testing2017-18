package pages.frameworks;

import com.google.common.base.Predicate;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class RozetkaSearch {
    private ChromeDriverEx driver;
    public RozetkaSearch(ChromeDriverEx driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "price[min]")
    private WebElement min_price;
    @FindBy(id = "price[max]")
    private WebElement max_price;
    @FindBy(css = "#submitprice")
    private WebElement submit_price_button;

    private List<WebElement> Prices;

    public static int is_number(String input){
        String result = input.replaceAll("[^0-9]*", "");
        return Integer.parseInt(result.toString());
    }

    public static boolean check_diapason(List<Integer> Prices, int Min, int Max){
        for (int i=0; i<Prices.size(); i++){
            if(Prices.get(i)<Min || Prices.get(i)>Max){ return false; }
        }
        return true;
    }

    public RozetkaSearch set_min_price(Integer price){
        if(price == null) return this;
        min_price.sendKeys(price.toString());
        return this;
    }

    public RozetkaSearch set_max_price(Integer price){
        if(price == null) return this;
        for(int i=0; i<10; i++ ){ max_price.sendKeys(Keys.BACK_SPACE); }
        max_price.sendKeys(price.toString());
        return this;
    }

    public RozetkaSearch price_submit(){
        submit_price_button.sendKeys(Keys.ENTER);
        return this;
    }

    public void prices_on_the_page(List Item){
        final By by = new By.ByClassName("g-price-uah");
        new WebDriverWait(driver,25,10 )
                .ignoring(StaleElementReferenceException.class)
                .until(new Predicate<WebDriver>() {
                    public boolean apply(WebDriver driver) {
                        Prices = driver.findElements(by);
                        return true;
                    }
                });
        for (WebElement temp:Prices){ Item.add(temp.getText()); }
    }



}
