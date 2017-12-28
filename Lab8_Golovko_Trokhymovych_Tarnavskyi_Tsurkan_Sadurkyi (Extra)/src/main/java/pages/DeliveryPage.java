package pages;

import extensions.ChromeDriverEx;
import elements.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class DeliveryPage extends Page{
    public DeliveryPage(ChromeDriverEx driver) {
        super(driver);
    }

    @FindBy(id = "total_checkout_amount")
    @CacheLookup
    public Label price;

    @FindBy(id = "make-order")
    @CacheLookup
    public Button purchaseButton;

    public int getPrice(){
        String stringValue = price.getText();
        return Integer.parseInt(stringValue);
    }
}
