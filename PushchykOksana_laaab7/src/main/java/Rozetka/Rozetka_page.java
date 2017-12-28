package Rozetka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Rozetka_page {
    private WebDriver driver;
    @FindBy(xpath = "//*[@id=\"m-main-ul\"]/li[17]/a")
    private WebElement Page1;
    @FindBy(xpath = "//*[@id=\"10515\"]/div/div/ul[4]/li[83]/a")
    private WebElement Page2;
    public Rozetka_page(WebDriver driver){
        this.driver = driver;
        driver.get("https://rozetka.com.ua");
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 25), this);
    }
    public void SportButton(){
        Page1.click();
        Page2.click();
    }
}
