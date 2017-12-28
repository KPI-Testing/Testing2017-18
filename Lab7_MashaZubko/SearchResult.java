package Lab7.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SearchResult {

    private static final By SEARCH_MIN = By.id("price[min]");
    private static final By SEARCH_MAX = By.id("price[max]");
    private static final By SUBMIT_PRICE = By.id("submitprice");
    private static final By CHOOSE_FIRST_ELEMENT = By.name("topurchases");
    private static final By SUBMIT_CHOOSE = By.id("popup-checkout");

    private WebDriver driver;

    public SearchResult(WebDriver driver) {
        this.driver = driver;
    }

    public SearchResult getPrice(String min, String max) {
        driver.findElement(SEARCH_MIN).sendKeys(Keys.CONTROL, "ф",Keys.BACK_SPACE);
        driver.findElement(SEARCH_MIN).sendKeys(min);
        driver.findElement(SEARCH_MAX).sendKeys(Keys.CONTROL, "ф",Keys.BACK_SPACE);
        driver.findElement(SEARCH_MAX).sendKeys(max);
        driver.findElement(SUBMIT_PRICE).click();
        return new SearchResult(driver);
    }


    public Order clickFirstResult() throws InterruptedException {

        driver.findElement(CHOOSE_FIRST_ELEMENT).click();
        Thread.sleep(2000);
        driver.findElement(SUBMIT_CHOOSE).click();
        return new Order(driver);
    }
}
