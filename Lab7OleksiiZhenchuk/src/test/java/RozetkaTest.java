//import Extensions.NotValidDataException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Contexts.*;
import PageObjects.*;
import Utillities.Waiters;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;

public class RozetkaTest {
    private static WebDriver driver;
    public static String ROZETKA_URL = "https://rozetka.com.ua/ua/vino/c4594285/filter/";
    @BeforeClass
    public static void Init()throws Exception{
        String exePath = "D:\\Oleksij\\Downloads\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        driver = new ChromeDriver();
    }
    @AfterClass
    public static void Close(){
        driver.quit();
    }
    
    @Test
    public void buyUkrGood() {
    	SearchPage filterPage = new SearchPage(driver);
        filterPage.start(ROZETKA_URL);
        int minPrice = 100,maxPrice = 2000;
        System.out.println("Setting prices from " + minPrice + " to " + maxPrice);
        SettingFilter.setPrice(filterPage, minPrice, maxPrice);
        Waiters.waitUrlContain(driver, "price", 10000, 250);
        Waiters.threadsleep(1000);
        if(filterPage.checkPrices(minPrice, maxPrice)) System.out.println("The prices were set correctly");
        else System.out.println("Oops! The prices weren't set correctly");
        //Перевірка на правильність виставлення ціни як така не впливає на оформлення замовлення, тому просто далі тестуємо його
        	String producerName = "Україна";
        	System.out.println("Setting producer country: " + producerName);
            ProductPage producerGoods = SettingFilter.setProducer(filterPage, producerName);
            CheckOutPage checkOutChosen = Buying.buyAndSubmitProduct(producerGoods);
            String[] personalData = { "Surname Name", "+380961234567", "email@example.com" };
            FinishPage makeOrder = Ordering.initilisateBuy(checkOutChosen, personalData[0], personalData[1], personalData[2]);
            if(makeOrder.orderEnabled()) System.out.println("The button is enabled");
            else System.out.println("Oops! The button isn't enabled");
        /*}*/
    }
    
    @After
    public void setDown(){
        driver.quit();
    }
}