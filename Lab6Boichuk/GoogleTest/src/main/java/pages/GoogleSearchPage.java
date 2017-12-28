package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

import static pages.Waiter.waitImplicit;

public class GoogleSearchPage {
    public static final String GOOGLE_URL = "https://www.google.com.ua/";
    private WebDriver driver;

    @FindBy(name = "q")
    private WebElement searchBox;

    public GoogleSearchPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open (){
        driver.get(GOOGLE_URL);
        waitImplicit(driver, 10, TimeUnit.SECONDS);
    }

    public GoogleResultsPage search (String query) {
        searchBox.sendKeys(query);
        searchBox.submit();
        return new GoogleResultsPage(driver);
    }
}
