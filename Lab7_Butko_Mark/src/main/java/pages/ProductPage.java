package pages;

import elements.Button;
import extensions.ChromeDriverEx;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends Page{

    public ProductPage(ChromeDriverEx driver){
        super(driver);
    }

    @FindBy(name = "topurchases")
    private Button buyButton;

    public Button getBuyButton() {
        return buyButton;
    }
}
