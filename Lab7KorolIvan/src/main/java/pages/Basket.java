package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Basket extends BasePage{
    public Basket(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "hub-i-link.hub-i-cart-link.sprite-side.whitelink")
    private WebElement myB
}
