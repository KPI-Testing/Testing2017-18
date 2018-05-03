package pages;

import elements.Button;
import extensions.ChromeDriverEx;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends Page{

    public BasketPage(ChromeDriverEx driver){
        super(driver);
    }

    @FindBy(id = "popup-checkout")
    private Button checkoutButton;

    public Button getCheckoutBtutton() {
        return checkoutButton;
    }
}
