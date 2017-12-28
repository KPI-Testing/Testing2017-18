package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utill.Waiters;


import java.util.concurrent.TimeUnit;

public class ProductPage extends BasePage{

    @FindBy(css = ".detail-buy-btn-container")
    private WebElement buyButton;

    private WebElement submitButton;

    public ProductPage (WebDriver driver){
        super(driver);
    }

    public CheckOut buyAndSubmit(){
        buyButton.click();
        //Waiters.thredsleep(2000);

        By by = new By.ByCssSelector("#popup-checkout");
        Waiters.waitExpected(getDriver(), by, 5000, 50 );
        submitButton = getDriver().findElement(by);
        Waiters.waitClickableAndDisplayed(getDriver(), submitButton, 5000, 50 );
        submitButton.click();
        return new CheckOut(getDriver()) ;
    }
}

