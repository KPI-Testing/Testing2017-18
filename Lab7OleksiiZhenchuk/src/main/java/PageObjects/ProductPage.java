package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import Utillities.Waiters;


import java.util.concurrent.TimeUnit;

public class ProductPage extends BasePage{

    @FindBy(css = ".detail-buy-btn-container")
    private WebElement buyButton;

    private WebElement submitButton;

    public ProductPage (WebDriver driver){
        super(driver);
    }

    public CheckOutPage buyAndSubmit(){
        buyButton.click();
        Waiters.threadsleep(1000);

        By by = new By.ByCssSelector("#popup-checkout");
        Waiters.waitExpected(getDriver(), by, 5000, 50 );
        submitButton = getDriver().findElement(by);
        Waiters.waitClickableAndDisplayed(getDriver(), submitButton, 5000, 50 );
        submitButton.click();
        return new CheckOutPage(getDriver()) ;
    }
}
