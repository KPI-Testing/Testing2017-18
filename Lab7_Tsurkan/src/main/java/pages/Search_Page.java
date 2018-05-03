package pages;

import elements.Button;
import elements.Check_List;
import elements.Text_Field;
import extensions.ChromeDriverEx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Search_Page extends Page {
    public static final String ROZETKA_URL = "https://bt.rozetka.com.ua/refrigerators/c80125/filter/36629=49499/";

    public Search_Page(ChromeDriverEx driver) {
        super(driver);
        open();
    }

    @FindBy(xpath = "//body/div[3]")
    @CacheLookup
    public WebElement progress_Bar;

    @FindBy(id = "price[min]")
    @CacheLookup
    public Text_Field min_Price;

    @FindBy(id = "price[max]")
    @CacheLookup
    public Text_Field max_Price;

    @FindBy(id = "submitprice")
    @CacheLookup
    public Button submit_Price;

    @FindBy(xpath = "//form[@id=\"filter_parameters_form\"]/div[10]")
    @CacheLookup
    public Check_List country_Filter;

    @FindBy(css = ".g-i-tile-i.available")
    @CacheLookup
    public List<WebElement> set_of_Results;

    public Search_Page open() {
        driver.get(ROZETKA_URL);
        return this;
    }

    public Search_Page set_Country(String country){
        country_Filter.selectFromCheckList(country);
        return this;
    }

    public Search_Page set_Min_Price(int price){
        min_Price.setValue(Integer.toString(price));
        return this;
    }

    public Search_Page set_Max_Price(int price){
        max_Price.setValue(Integer.toString(price));
        return this;
    }
}
