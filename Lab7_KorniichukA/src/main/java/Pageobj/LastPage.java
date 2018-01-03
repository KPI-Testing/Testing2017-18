package Pageobj;

import org.openqa.selenium.WebDriver;

public class LastPage extends FirstPage {

    public LastPage(WebDriver driver) {
        super(driver);
    }
    private static final String result = "https://my.rozetka.com.ua/checkout/?#step=delivery";
    public boolean counter(){
        return getDriver().getCurrentUrl().equalsIgnoreCase(result);
    }
}