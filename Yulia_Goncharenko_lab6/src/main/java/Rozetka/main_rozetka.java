package Rozetka;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class main_rozetka {
    private static WebDriver driver;
    private final static int price_to_set = 300;
    private final String url = "https://rozetka.com.ua/hudojestvennaya-literatura/c4326593/";

    @BeforeClass
    public static void setUp(){
        String exePath = "chromedriver";
        System.setProperty("webdriver.chrome.driver", exePath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void check_min_price(){
        driver.get(url);
        FictionBook result = new FictionBook(driver);
        result.set_min_price(price_to_set);
        result.submit_filter_price();
        int min_price = result.get_min_price();
        Assert.assertTrue(min_price == price_to_set);
        List<Integer> prices = result.prices();
        System.out.println(prices);
        for (int price: prices){
            Assert.assertTrue(price >= min_price);
        }
    }

    @AfterClass
    public static void Close(){
        driver.quit();
    }

}
