package pages;

import elements.Button;
import elements.Html_Label;
import extensions.ChromeDriverEx;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class Basket_Page extends Page {
    public Basket_Page(ChromeDriverEx driver) {
        super(driver);
    }

    @FindBy(id = "popup-checkout")
    @CacheLookup
    public Button validate;

    @FindBy(name = "cost")
    @CacheLookup
    public Html_Label price;

    public int get_Price(){
        String string_with_price = price.getText();
        string_with_price = string_with_price.replaceAll(" ","");
        return Integer.parseInt(string_with_price);
    }
}
