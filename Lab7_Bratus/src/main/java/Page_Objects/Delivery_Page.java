package Page_Objects;

import Elements.*;
import Extensions.ChromeDriverEx;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class Delivery_Page extends Screen_Page {
    public Delivery_Page(ChromeDriverEx driver) {
        super(driver);
    }

    @FindBy(id = "total_checkout_amount")
    @CacheLookup
    public HTML_Label price;

    @FindBy(id = "make-order")
    @CacheLookup
    public Button purchaseButton;

    public int Get_Price(){
        String price_string = price.getText();
        price_string = price_string.replaceAll(" ","");
        return Integer.parseInt(price_string);
    }
}
