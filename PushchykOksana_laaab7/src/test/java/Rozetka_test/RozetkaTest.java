package Rozetka_test;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Rozetka.*;

public class RozetkaTest {
    private static WebDriver driver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "D:\\Завантаження\\111111111\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @After
    public  void setDown(){
        driver.quit();
    }
    @Test
    public void Test() {
        Rozetka_page page = new Rozetka_page(driver);
        page.SportButton();
        Price prod = new Price(driver);
        prod.UAclick();
        prod.SetMin("400");
        prod.SetMax("700");
        prod.PriceClick();
        prod.Buy(3);
        prod.clik();
        OrderList ord = new OrderList(driver);
        ord.Info();
        ord.Pass();
    }
}
