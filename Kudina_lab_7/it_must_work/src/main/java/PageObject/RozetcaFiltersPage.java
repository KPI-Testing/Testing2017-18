package PageObject;

import Elements.Button;
import Elements.CheckBox;
import Elements.CheckList;
import Elements.TextField;
import extensions.ChromeDriverEx;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RozetcaFiltersPage extends RozetcaResultPage{

    public RozetcaFiltersPage(ChromeDriverEx driver){

        super(driver);
    }

    @FindBy(id = "price[min]")
    private TextField minPrice;

    @FindBy(id = "price[max]")
    private TextField maxPrice;

    @FindBy(xpath = "//form[@id=\"filter_parameters_form\"]/div[1]")
    private CheckList producers;

    @FindBy(id = "submitprice")
    private Button submitPriceButton;

    public RozetcaFiltersPage min_price_filter(String price) {
        minPrice.setValue(price);
        return this;
    }

    public RozetcaFiltersPage max_price_filter(String price) {
        maxPrice.setValue(price);
        return this;
    }

    public RozetcaFiltersPage set_Country(String country){
        producers.selectFromCheckList(country);
        return this;
    }

    public void submit_price_filter(){
        submitPriceButton.click();
    }

    public String getMaxPrice(){
        return maxPrice.getValue();
    }

    public String getMinPrice(){
        return minPrice.getValue();
    }

//    //public List<HtmlLabel> getProducers() {
//        return producers;
//    }
}
