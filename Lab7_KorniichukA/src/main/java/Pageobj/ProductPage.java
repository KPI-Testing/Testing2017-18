package Pageobj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import Utills.Waiters;

public class ProductPage extends FirstPage {

    @FindBy(css = ".detail-buy-btn-container")
    private WebElement buyButton;

    public ProductPage (WebDriver driver){
        super(driver);
    }

    public CheckOutPage Submit_buying(){
        buyButton.click();
        Waiters.thredsleep(1000);
        By fnd = new By.ByCssSelector("#popup-checkout");
        getDriver().findElement(fnd).click();
        return new CheckOutPage(getDriver()) ;
    }
}