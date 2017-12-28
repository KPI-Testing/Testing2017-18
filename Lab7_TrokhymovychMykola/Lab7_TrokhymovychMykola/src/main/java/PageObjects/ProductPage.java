package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utillites.Waiters;

public class ProductPage extends BasePage{

    private static final By PAGE_LOADED = new By.ByCssSelector(".card-title");
    @FindBy(css = ".detail-buy-btn-container")
    private WebElement buyButton;

    private WebElement submitButton;

    public ProductPage (WebDriver driver){
        super(driver);
    }

    public CheckOutPage buyAndSubmit(){
        buyButton.click();
        //getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        Waiters.thredsleep(2000);
        By by = new By.ByCssSelector("#popup-checkout");
        submitButton = getDriver().findElement(by);
        submitButton.click();
        return new CheckOutPage(getDriver()) ;
    }
}

