package Rozetka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class AndOneElse {
    private WebDriver driver;
    @FindBy(xpath = ".//*[@id='popup-checkout']")
    private WebElement a;
    public AndOneElse (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 25), this);
    }
    public void clikCheckout(){
        a.click();
    }
}
