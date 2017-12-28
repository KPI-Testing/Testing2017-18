package PageObjects;

import org.openqa.selenium.WebDriver;

public class FinishPage extends BasePage {

    public FinishPage(WebDriver driver) {
        super(driver);
    }
    private static final String result = "https://my.rozetka.com.ua/checkout/?#step=delivery";
    public boolean counter(){
        System.out.println(getDriver().getCurrentUrl());
        return getDriver().getCurrentUrl().equalsIgnoreCase(result);
    }
}
