package pages;

import elements.HtmlLabel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import utils.Waiters;


import java.util.List;
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
        By by = new By.ByCssSelector("#popup-checkout");
        submitButton = getDriver().findElement(by);
        submitButton.click();
        return new CheckOut(getDriver()) ;
    }

    public WebElement getBuyButton() {
        return buyButton;
    }

    public ProductPage setBuyButton(WebElement buyButton) {
        this.buyButton = buyButton;
        return this;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public ProductPage setSubmitButton(WebElement submitButton) {
        this.submitButton = submitButton;
        return this;
    }
}

