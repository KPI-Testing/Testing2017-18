package PageObjects;

import Elements.Button;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import static Waiter.Waiter.waitForClick;

public class GoodPage extends BasePage {
    public GoodPage(WebDriver driver){
        super(driver);
    }

    @FindBy(css = ".btn-link-i[name = \"topurchases\"]")
    private Button buyButton;

    public void buy_good(){
        waitForClick(driver, buyButton, 5);
        buyButton.click();
    }
}
