package pages;

import elements.Button;
import elements.Html_Label;
import extensions.ChromeDriverEx;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class Delivery_Page extends Page {
    public Delivery_Page(ChromeDriverEx driver) {
        super(driver);
    }

    @FindBy(id = "total_checkout_amount")
    @CacheLookup
    public Html_Label price;

    @FindBy(id = "make-order")
    @CacheLookup
    public Button purchaseButton;

    public int get_Price(){
        String stringValue = price.getText();
        stringValue = stringValue.replaceAll(" ","");
        return Integer.parseInt(stringValue);
    }
}
