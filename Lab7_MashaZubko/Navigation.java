package Lab7.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Navigation {

    private static final By SEARCH_UA = By.name("text");

    private WebDriver driver;

    public Navigation(WebDriver driver) {
        this.driver = driver;
    }

    public SearchResult searchFor(String category){
        driver.findElement(SEARCH_UA).sendKeys(category, Keys.ENTER);

        return new SearchResult(driver);
    }
}
