package Lab7.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class Order {

    private static final By NAME = By.id("reciever_name");
    private static final By PHONE = By.id("reciever_phone");
    private static final By EMAIL = By.id("reciever_email");
    private static final By NEXT = By.xpath("(//button[@name='next_step'])[2]");

    private WebDriver driver;

    public Order(WebDriver driver) {

        this.driver = driver;
    }
    public CheckStatus submit_order(String Name, String Phone, String Email) throws InterruptedException {
        driver.findElement(NAME).sendKeys(Name);
        driver.findElement(PHONE).sendKeys(Phone);
        driver.findElement(EMAIL).sendKeys(Email);
        Thread.sleep(2000);
        driver.findElement(NEXT).click();

        return new CheckStatus(driver);
    }
}
