package Rozetochkaa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Rozeeeetka.Rozetka;

public class RozetochkaTest {
    protected WebDriver driver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "D:\\Завантаження\\111111111\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://rozetka.com.ua/notebooks/c80004/filter/preset=game/");
    }
    @Test
    public void Test2() {
        Rozetka price = new Rozetka(driver);
        int pr = 0;
        price.minPrice(pr);
        price.Filter();
        int real = price.getMinPrice();
        if (real == pr) {
            System.out.println("Min price");
        } else {
            System.out.println("Not min price");
        }
    }
    @After
    public  void setDown(){
        driver.quit();
    }
}
