package PageObjects;

import Elements.Button;
import Elements.Html_label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static Waiter.Waiter.waitForClick;

public class Rozetka extends BasePage {
    public Rozetka(WebDriver driver){
        super(driver);
    }
    @FindBy(css = "btn-link-i")
    private List<Button> buy_buttons;

    public List<Button> getBuy_buttons() {
        return buy_buttons;
    }

    @FindBy(css = ".hub-i-link.hub-i-cart-link.sprite-side.whitelink")
    private Button bucket;

    public Button getBucket() {
        return bucket;
    }

    @FindBy(css = ".g-i-table > div:first-child> .g-i-td")
    private List<Html_label> allLabels;

    public List<Html_label> getAllLabels() {
        return allLabels;
    }

}
