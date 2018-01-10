package pages;

import java.util.List;
import elements.*;
import extensions.ChromeDriverEx;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends Page{

    @FindBy(id = "price[min]")
    private TextField minPriceField;

    @FindBy(id = "price[max]")
    private TextField maxPriceField;

    @FindBy(id = "submitprice")
    private Button priceButton;

    @FindBy(className = "g-price-uah")
    private List<WebElement> priceList;

    @FindBy(xpath = "//*[@id=\"filter_parameters_form\"]/div[4]")
    private CheckList countryFilter;

    @FindAll({
            @FindBy(css = ".g-i-tile-i.available.g-i-large-tile-i-middle div.g-i-tile-i-title.clearfix a"),
            @FindBy(css = ".g-i-tile-i.limited.g-i-large-tile-i-middle div.g-i-tile-i-title.clearfix a")
    })
    private List<WebElement> productList;

    public SearchPage(ChromeDriverEx driver){
        super(driver);
    }

    public void setMinPrice(Integer min) {
        minPriceField.setValue(min.toString());
    }

    public void setMaxPrice(Integer max){
        maxPriceField.setValue(max.toString());
    }

    public Integer getMinPrice(){
        return Integer.parseInt(minPriceField.getValue());
    }

    public Integer getMaxPrice(){
        return Integer.parseInt(maxPriceField.getValue());
    }

    public Button getPriceButton(){return priceButton;}

    public void setCountry(String countryName) {
        countryFilter.select(countryName);
    }

    public List<WebElement> getProductList() {
        return productList;
    }
}
