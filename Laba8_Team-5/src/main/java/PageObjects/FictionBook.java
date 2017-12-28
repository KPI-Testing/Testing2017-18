package PageObjects;
import Elements.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static Waiter.Waiter.waitForClick;

public class FictionBook extends BasePage{
    public FictionBook(WebDriver driver_){
        super(driver_);
    }

    @FindBy(id = "price[min]")
    private TextField minPrice;

    @FindBy(id = "price[max]")
    private TextField maxPrice;

    @FindBy(xpath = "//*[@param = \"49445\"]//label")
    private List<CheckBox> producers;

    @FindBy(id = "submitprice")
    private Button submitPriceButton;

    @FindBy(css =".over-wraper .g-i-tile-i-box-desc >div:first-child > div>a")
    private List<WebElement> results;

    public WebElement get_first(){
        return results.get(0);
    }

    public void set_min_price(Integer price){
        minPrice.setValue(price.toString());
    }

    public void set_max_price(Integer price) {
        maxPrice.setValue(price.toString());
    }

    public void submit_filter_price(){
        submitPriceButton.click();
    }

    public void click_on_result(int index){
        results.get(index).click();
    }

    public String getMaxPrice(){
        return maxPrice.getValue();
    }

    public String getMinPrice(){
        return minPrice.getValue();
    }

    public List<CheckBox> getProducers() {
        return producers;
    }
}
