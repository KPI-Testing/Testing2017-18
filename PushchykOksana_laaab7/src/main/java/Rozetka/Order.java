package Rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Order {
    private WebDriver driver;
    public Order(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 25), this);
    }
    @FindBy(xpath = ".//*[@id='make-order']")
    private WebElement a;
    public void Pass(){
        if (a.isDisplayed() && a.isEnabled()) {
            System.out.println("PASS");
        }
    }
}
