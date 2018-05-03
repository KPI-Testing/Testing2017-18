package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestPageObject extends PageObject {
    public TestPageObject(WebDriver driver){
        super(driver);
    }

    public static final String URL_PRODUCTS_GLUE = "https://rozetka.com.ua/ua/kley/c2560862/";
    public TestPageObject get (){
        driver.get(URL_PRODUCTS_GLUE);

        return this;
    }

    @FindBy(id = "price[min]")
    public WebElement minPrice;

    @FindBy(id = "price[max]")
    public WebElement maxPrice;

    @FindBy(id = "submitprice")
    public WebElement submitPrice;

}
