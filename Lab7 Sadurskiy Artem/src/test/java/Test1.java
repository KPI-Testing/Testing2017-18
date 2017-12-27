import contexts.ProductActions;
import contexts.FiltrActions;
import contexts.OrderActions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static junit.framework.TestCase.assertTrue;

public class Test1 {
    private static WebDriver driver;
    public static String RURL = "https://rozetka.com.ua/ua/krepkie-napitki/c4594292/filter/sort=cheap/";
    @BeforeClass
    public static void Init()throws Exception{
        String exePath = "C:\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        driver = new ChromeDriver();
    }
    @AfterClass
    public static void Close(){
        driver.quit();
    }

    @Test
    public void test() {
        SearchPage filteringPage = new SearchPage(driver);
        filteringPage.start(RURL);

        int minPrice = 100;
        int maxPrice = 2000;
        String producer = "Україна";

        FiltrActions.setPrice(filteringPage, minPrice, maxPrice);
        ProductPage choosenProduct = FiltrActions.setProducer(filteringPage, producer);
        CheckOutPage checkOutPageProduct = ProductActions.buyAndSubmitProduct(choosenProduct);
        OrderActions.initilizateBuy(checkOutPageProduct, "АЧыаи ивчач", "0638955856", "lolol111@ukr.net");

        assertTrue(checkOutPageProduct.isCorrectOrder());
        
    }
}
