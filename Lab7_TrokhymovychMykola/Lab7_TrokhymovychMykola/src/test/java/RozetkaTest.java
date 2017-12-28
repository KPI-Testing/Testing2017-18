import PageObjects.CheckOutPage;
import PageObjects.FinishPage;
import PageObjects.ProductPage;
import PageObjects.SearchPage;
import contexts.Buying;
import contexts.Filtering;
import contexts.Ordering;
import extentions.NotValidDataExeption;
import helpers.Data;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utillites.screenshot;

import static junit.framework.TestCase.assertTrue;
import static utillites.Waiters.thredsleep;

public class RozetkaTest {

    private static WebDriver driver;
    public static String RURL = "https://rozetka.com.ua/ua/ofisnye-kresla-i-stulya/c154072/";

    @BeforeClass
    public static void Init()throws Exception{
        String exePath = "C:\\Users\\Trokhymovych\\IdeaProjects\\lib\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        driver = new ChromeDriver();
    }

    @AfterClass
    public static void Close(){
        driver.quit();
    }

    @Test
    public void test() throws Exception {

        SearchPage filteringPage = new SearchPage(driver);
        filteringPage.start(RURL);

        //Set Parameters
        int minPrice = 100;
        int maxPrice = 2000;
        String country = "Україна";

        Filtering.setPrice(filteringPage, minPrice, maxPrice);
        thredsleep(1000);

        //Set country and go next
        ProductPage choosenProduct = Filtering.setCountry(filteringPage, country);
        CheckOutPage checkOutProduct = Buying.buyAndSubmitProduct(choosenProduct);


        FinishPage deliverProduct = null;
        try {
            deliverProduct = Ordering.initilizateBuy(checkOutProduct, new Data());
        }
        catch (NotValidDataExeption e){
            e.getMessage();
        }
        assert deliverProduct != null;
        System.out.println(deliverProduct.counter());

        screenshot.getscreenshot(driver);
        thredsleep(1000);
        assertTrue(deliverProduct.counter());
    }
}
