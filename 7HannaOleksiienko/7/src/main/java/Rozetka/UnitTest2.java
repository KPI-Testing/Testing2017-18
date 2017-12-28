package Rozetka;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;


public class UnitTest2 {

    protected WebDriver driver;
    //private String _url = "https://rozetka.com.ua/2514852/c2514852/59867=182887/#search_text=%D0%B1%D0%BB%D0%BE%D0%BA%D0%BD%D0%BE%D1%82";
    private String _url = "https://rozetka.com.ua/";


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
    public void checkYouCanBuyItem() {
        RozetkaPage page = new RozetkaPage(driver);

        page.searchItem("Блокноты");
//        page.SetMinimumPrice(100);
//        page.SetMaximumPrice(2000);
//        page.submitPriceFilter();
//
//        page.SetManufacturer();
        PurchaseContext buyPage = new PurchaseContext(driver);
        buyPage.fillContactInfo();
        assertTrue(buyPage.purchaseItem());

//
//        int actualValue = page.getMinPrice();
//        assertTrue(actualValue - priceValueToSet > 0);
    }
}

