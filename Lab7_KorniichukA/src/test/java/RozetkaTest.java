
import Contexts.Buy;
import Contexts.Filter;
import Contexts.Order;
import Pageobj.CheckOutPage;
import Pageobj.LastPage;
import Pageobj.ProductPage;
import Pageobj.SearchPage;
import Data_to_Insert.WrongDataExeption;
import Data_to_Insert.Data;
import Utills.Get_screenshot;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static junit.framework.TestCase.assertTrue;
import static Utills.Waiters.thredsleep;

public class RozetkaTest {

    private static WebDriver driver;
    public static String roz_page = "https://rozetka.com.ua/ua/literatura/c4005167/";

    @BeforeClass
    public static void SetUp() {
        String exePath = "D:\\Аня\\3-й курс\\тестування\\labs\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        driver = new ChromeDriver();
    }

    @Test
    public void Test() {

        SearchPage filteringPage = new SearchPage(driver);
        filteringPage.start(roz_page);

        int minPrice = 100;
        int maxPrice = 2000;

        Filter.set_price(filteringPage, minPrice, maxPrice);
        thredsleep(1000);

        ProductPage choosenProduct = Filter.set_country(filteringPage,"Україна");thredsleep(1000);System.out.println("all is ok");
        CheckOutPage checkOutProduct = Buy.Subm_buying_product(choosenProduct);

        LastPage delivery = null;
        try {
            delivery = Order.init_cart(checkOutProduct, new Data());
        }
        catch (WrongDataExeption e){
            e.getMessage();
        }
        assert delivery != null;

        try {
            Get_screenshot.getscreenshot(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
        thredsleep(1000);
       assertTrue(delivery.counter());
    }

    @AfterClass
    public static void SetDown(){ driver.quit(); }
}