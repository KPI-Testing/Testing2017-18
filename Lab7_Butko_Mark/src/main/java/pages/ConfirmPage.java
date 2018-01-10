package pages;

import elements.Button;
import extensions.ChromeDriverEx;
import org.openqa.selenium.support.FindBy;

public class ConfirmPage extends Page{

    public ConfirmPage(ChromeDriverEx driver){
        super(driver);
    }

    @FindBy(id = "make-order")
    private Button confirmButton;

    public Button getConfirmButton() {
        return confirmButton;
    }
}
