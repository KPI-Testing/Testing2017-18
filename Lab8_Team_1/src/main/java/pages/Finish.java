package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import utils.Waiters;

import java.util.List;

public class Finish extends BasePage {

    public Finish(WebDriver driver) {
        super(driver);
    }
    private static final String result = "https://my.rozetka.com.ua/ua/checkout/?#step=delivery";
    public boolean counter(){
        return getDriver().getCurrentUrl().equalsIgnoreCase(result);
    }
}
