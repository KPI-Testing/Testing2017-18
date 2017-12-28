package Rozetka;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static junit.framework.TestCase.assertTrue;


public class UnitTest2 {

    protected WebDriver driver;
    private String _url = "https://rozetka.com.ua/hudojestvennaya-literatura/c4326593/";

    @Before
    public void openTheBrowser() {
        String exePath = "/Users/macbook/Documents/chromedriver";
        System.setProperty("webdriver.chrome.driver", exePath);
        driver = new ChromeDriver();
        driver.get(_url);
    }

    @After
    public void closeTheBrowser() {
        driver.quit();
    }

    @Test
    public void NegativeMinPriceShouldUpdatePriceToMinimalAvailable() {
        RozetkaPage page = new RozetkaPage(driver);

        int priceValueToSet = -1;

        page.SetMinimumPrice(priceValueToSet);
        page.submitPriceFilter();

        int actualValue = page.getMinPrice();
        assertTrue(actualValue - priceValueToSet > 0);
    }
}

