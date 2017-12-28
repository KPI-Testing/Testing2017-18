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

public class Magic_Tests {
    private static ChromeDriverEx driver;
    private static String URL_Google = "https://www.google.com.ua/";
    public static String URL_Rozetka = "https://rozetka.com.ua/notebooks/c80004/filter/";
    @BeforeClass
    public static void set_up()throws Exception{
        String exePath = "C:\\Users\\User\\Testing_Java\\lib_max\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("disable-infobars");
        driver = new ChromeDriverEx(options);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @AfterClass
    public static void close(){
        driver.quit();
    }


    //@Ignore
    @Test
    public void Test_for_min_price_shop_Rozetka()throws InterruptedException{
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.get(URL_Rozetka);
        All_for_Rozetka Current_Page = new All_for_Rozetka(driver);
        int min_price = 6000;

        Current_Page.set_min_price(min_price).submit_price();

        List<String> Prices = new ArrayList();
        List<Integer> Prices_Int = new ArrayList();

        Current_Page.find_prices_on_page(Prices);
        for (int i = 0; i < Prices.size(); i++){
            System.out.println(Prices.get(i));
            Prices_Int.add(All_for_Rozetka.is_number(Prices.get(i)));
        }
        boolean b = (All_for_Rozetka.check_diapason(Prices_Int, min_price));
        assertTrue(b == true);

    }

    //@Ignore
    @Test
    public void Test1()throws Exception{
        String key = "big data kiev";
        String ToFind = "Epam";
        String Path = "C:\\Users\\User\\Testing_Java\\Screens\\Test_1\\";
        All_for_Google t1 = new All_for_Google(driver);
        int count = t1.magic_check(URL_Google, key, ToFind, Path, false, false, 2);
        assertTrue(count > 0);
    }

    //@Ignore
    @Test
    public void Test2()throws Exception{

        String key = "Epam kiev";
        String ToFind = "Epam";
        String Path = "C:\\Users\\User\\Testing_Java\\Screens\\Test_2\\";
        All_for_Google t2 = new All_for_Google(driver);
        int count =t2.magic_check(URL_Google, key, ToFind, Path, true, false, 1);
        assertTrue(count > 0);
    }

    //@Ignore
    @Test
    public void Test3() throws Exception{

        String key = "the best it company kiev";
        String ToFind = "Maks is the best";
        String Path = "C:\\Users\\User\\Testing_Java\\Screens\\Test_3\\";
        All_for_Google t3 = new All_for_Google(driver);
        int count = t3.magic_check(URL_Google, key, ToFind, Path, false, true, 1);
        System.out.println(count);
        assertTrue(count == 0);
    }
}
