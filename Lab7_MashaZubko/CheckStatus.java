package Lab7.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckStatus {

    private static final By CHECK_BUTTON = By.id("make-order");

    private WebDriver driver;

    public CheckStatus(WebDriver driver) {
        this.driver = driver;
    }
    public CheckStatus checkStatus(){
        System.out.println("Status button: "+driver.findElement(CHECK_BUTTON).isEnabled());
        return this;
    }
}
