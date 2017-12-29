package Page_Objects;

import Elements.*;
import Extensions.ChromeDriverEx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Search_Page extends Screen_Page {

    public static final String Rozetka_Link = "https://rozetka.com.ua/ganteli-diski-grify-zamki/c146633/";

    public Search_Page(ChromeDriverEx driver) {
        super(driver);
        open();
    }

    @FindBy(xpath = "//body/div[3]")
    @CacheLookup
    public WebElement Progress_Bar;

    @FindBy(id = "price[min]")
    @CacheLookup
    public Text_Field Min_Price;

    @FindBy(id = "price[max]")
    @CacheLookup
    public Text_Field Max_Price;

    @FindBy(id = "submitprice")
    @CacheLookup
    public Button Submit_Price;

    @FindBy(xpath = "//form[@id=\"filter_parameters_form\"]/div[7]")
    @CacheLookup
    public Check_List Filter_Country;

    @FindBy(css = ".g-i-tile-i.available")
    @CacheLookup
    public List<WebElement> Results;

    public Search_Page open() {
        driver.get(Rozetka_Link);
        return this;
    }

    public Search_Page Set_Country(String country){
        Filter_Country.select_from_check_list(country);
        return this;
    }

    public Search_Page Set_Min_Price(int price){
        Min_Price.setValue(Integer.toString(price));
        return this;
    }

    public Search_Page Set_Max_Price(int price){
        Max_Price.setValue(Integer.toString(price));
        return this;
    }
}
