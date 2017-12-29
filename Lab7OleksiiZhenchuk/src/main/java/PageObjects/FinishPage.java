package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import Utillities.Waiters;

import java.util.List;

public class FinishPage extends BasePage {

    public FinishPage(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(id = "make-order")
    private WebElement orderButton;
    
    public boolean orderEnabled() {
    	return orderButton.isEnabled();
    }
}