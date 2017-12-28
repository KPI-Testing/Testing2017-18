package Rozetka;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class OrderList {
    private WebDriver driver;
    public OrderList(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 25), this);
    }
    @FindBy(xpath = ".//*[@id='reciever_name']")
    private WebElement Name;
    @FindBy(xpath = ".//*[@id='reciever_phone']")
    private WebElement Phone;
    @FindBy(xpath = ".//*[@id='reciever_email']")
    private WebElement Email;
    @FindBy(xpath = ".//*[@id='suggest_locality']")
    private WebElement Location;
    @FindBy(xpath = "//*[@id=\"step_contacts\"]/div/div[1]/div[2]/div/span/button")
    private WebElement Next;
    public void Info(){
        Name.sendKeys("Gvmjhv Kytgv");
        Location.click();
        Location.sendKeys(Keys.ARROW_DOWN);
        Location.sendKeys(Keys.ENTER);
        Phone.sendKeys("0505056768");
        Email.sendKeys("bfghfhg@i.ua");
        if (Next.isDisplayed() && Next.isEnabled()) {
            Next.click();
        }
    }
    @FindBy(xpath = ".//*[@id='make-order']")
    private WebElement a;
    public void Pass(){
        if (a.isDisplayed() && a.isEnabled()) {
            System.out.println("PASS");
        }
    }
}
