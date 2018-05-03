package Page_Objects;

import Elements.*;
import Extensions.ChromeDriverEx;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class Card_Page extends Screen_Page {

    public Card_Page(ChromeDriverEx driver) {
        super(driver);
    }

    @FindBy(id = "popup-checkout")
    @CacheLookup
    public Button validate;

    @FindBy(name = "cost")
    @CacheLookup
    public HTML_Label price;

    public int Get_Price(){
        String price_string = price.getText();
        price_string = price_string.replaceAll(" ","");
        return Integer.parseInt(price_string);
    }
}
