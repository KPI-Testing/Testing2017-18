package pages.frameworks;

import com.google.common.base.Predicate;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class All_for_Rozetka {

    private ChromeDriverEx driver;

    public All_for_Rozetka(ChromeDriverEx driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "price[min]")
    private WebElement Min_price;

    @FindBy(css = "#submitprice")
    private WebElement Submit_price_button;

    private List<WebElement> Prices;

    public static int is_number(String input){

        String result = input.replaceAll("[^0-9]*", "");
        return Integer.parseInt(result.toString());
    }

    public static boolean check_diapason(List<Integer> Prices, int Min){
        for (int i = 0; i < Prices.size(); i++){
            if(Prices.get(i) < Min ){
                return false;
            }
        }
        return true;
    }

    public All_for_Rozetka set_min_price(Integer price){
        if(price == null) return this;
        Min_price.sendKeys(price.toString());
        return this;
    }

    public All_for_Rozetka submit_price(){
        Submit_price_button.sendKeys(Keys.ENTER);
        return this;
    }

    public void find_prices_on_page(List Item){
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
