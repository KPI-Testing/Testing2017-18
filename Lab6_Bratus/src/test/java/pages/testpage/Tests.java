package pages.testpage;

import pages.frameworks.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;

public class Tests {
    private static ChromeDriverEx driver;
    private static String Google_Link = "https://www.google.com.ua/";
    public static String Rozetka_Link = "https://rozetka.com.ua/mobile-phones/c80003/preset=smartfon/";
    @BeforeClass
    public static void set_up()throws Exception{
        String exePath = "C:\\Users\\admin\\Desktop\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("disable-infobars");
        driver = new ChromeDriverEx(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @AfterClass
    public static void close(){
        driver.quit();
    }

    //@Ignore
    @Test
    public void Rozetka_test()throws InterruptedException{
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.get(Rozetka_Link);
        RozetkaSearch Current_Page = new RozetkaSearch(driver);
        int min_price = 1000;
        int max_price = 50000;
        Current_Page.set_min_price(min_price);
        Current_Page.set_max_price(min_price).price_submit();
        List<String> Prices = new ArrayList();
        List<Integer> Prices_Int = new ArrayList();
        Current_Page.prices_on_the_page(Prices);
        for (int i = 0; i < Prices.size(); i++){
            System.out.println(Prices.get(i));
            Prices_Int.add(RozetkaSearch.is_number(Prices.get(i)));
        }
        boolean b = (RozetkaSearch.check_diapason(Prices_Int, min_price, max_price));
        assertTrue(b == true);
    }

    //@Ignore
    @Test
    public void Test_1()throws Exception{
        String key = "Oskar";
        String ToFind = "Gulliver";
        String Path = "C:\\Users\\admin\\Desktop\\Lab6_Bratus\\Screenshots\\Test_1\\";
        GoogleSearch t1 = new GoogleSearch(driver);
        int count = t1.result_check(Google_Link, key, ToFind, Path, false, false, 2);
        assertTrue(count > 0);
    }

    //@Ignore
    @Test
    public void Test_2()throws Exception{
        String key = "Oskar kiev";
        String ToFind = "Gulliver";
        String Path = "C:\\Users\\admin\\Desktop\\Lab6_Bratus\\Screenshots\\Test_2\\";
        GoogleSearch t2 = new GoogleSearch(driver);
        int count =t2.result_check(Google_Link, key, ToFind, Path, true, false, 1);
        assertTrue(count > 0);
    }

    //@Ignore
    @Test
    public void Test_3() throws Exception{
        String key = "Oskar";
        String ToFind = "DiCaprio";
        String Path = "C:\\Users\\admin\\Desktop\\Lab6_Bratus\\Screenshots\\Test_3\\";
        GoogleSearch t3 = new GoogleSearch(driver);
        int count = t3.result_check(Google_Link, key, ToFind, Path, false, true, 1);
        System.out.println(count);
        assertTrue(count == 0);
    }
}
