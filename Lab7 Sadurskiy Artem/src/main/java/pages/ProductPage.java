package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utill.Waiters;

public class ProductPage extends BasePage{

    @FindBy(css = ".detail-buy-btn-container")
    private WebElement buyButton;

    private WebElement submitButton;

    public ProductPage (WebDriver driver){
        super(driver);
    }

    public CheckOutPage buyAndSubmit(){
        buyButton.click();
        By by = new By.ByCssSelector("#popup-checkout");
        Waiters.threadSleep(500);
        submitButton = getDriver().findElement(by);
        submitButton.click();
        return new CheckOutPage(getDriver()) ;
    }
}

