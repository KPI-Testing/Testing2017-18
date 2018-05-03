package pages;

import extensions.ChromeDriverEx;
import elements.Button;
import elements.CheckList;
import elements.TextField;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FridgesPage extends Page {
    public static final String ROZETKA_FRIDGES_URL = "https://rozetka.com.ua/knives/c87073/";

    public FridgesPage(ChromeDriverEx driver) {
        super(driver);
        open();
    }

    @FindBy(xpath = "//body/div[3]")
    @CacheLookup
    public WebElement progressBar;

    @FindBy(id = "price[min]")
    @CacheLookup
    public TextField minPrice;

    @FindBy(id = "price[max]")
    @CacheLookup
    public TextField maxPrice;

    @FindBy(id = "submitprice")
    @CacheLookup
    public Button submitPrice;

    @FindBy(xpath = "//form[@id=\"filter_parameters_form\"]/div[4]")
    @CacheLookup
    public CheckList countryFilter;

    @FindBy(css = ".g-i-tile-i.available")
    @CacheLookup
    public List<WebElement> resultSet;

    public FridgesPage open() {
        driver.get(ROZETKA_FRIDGES_URL);
        return this;
    }

    public FridgesPage setCountry(String country){
        countryFilter.selectFromCheckList(country);
        return this;
    }

    public FridgesPage setMinPrice(int price){
        minPrice.setValue(Integer.toString(price));
        return this;
    }

    public FridgesPage setMaxPrice(int price){
        maxPrice.setValue(Integer.toString(price));
        return this;
    }
}
