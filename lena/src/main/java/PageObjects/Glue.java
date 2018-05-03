package PageObjects;

import CustomElements.Button;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Glue extends PageObject {

    public Glue(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath="//*[@id=\"popup-checkout\"]")
    public Button submitBuy;
}
