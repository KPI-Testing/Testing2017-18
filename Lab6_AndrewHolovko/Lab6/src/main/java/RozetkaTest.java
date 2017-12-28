import org.junit.*;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class RozetkaTest {
    private String baseUrl = "https://rozetka.com.ua/hudojestvennaya-literatura/c4326593/";
    private static String driverPath = "c:\\chromedriver\\chromedriver.exe ";
    private static ChromeDriverEx driver;
    private RozetkaPage page;


    @BeforeClass
    public static void setDriverPath() throws IOException {
        System.setProperty("webdriver.chrome.driver", driverPath);
    }

    @Before
    public void prepareForTest() throws Exception {
        driver = new ChromeDriverEx();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        page = new RozetkaPage(driver, baseUrl);
        page.setWaitLimit(30);
    }

    @Test
    public void test() throws Exception {
        int minPrice = 10000;
        page.waitLoading().setMinPrice(minPrice).submitPriceFilter().waitLoading();
        int actualMinPrice = page.getMinPrice(), actualMaxPrice = page.getMaxPrice();
        page.applySort("cheap").waitLoading();
        //checks if minPrice == actualMinPrice <= actualMaxPrice
        Assert.assertTrue("actualMinPrice != minPrice", actualMinPrice == minPrice);
        Assert.assertTrue("actualMaxPrice < actualMinPrice", actualMaxPrice >= actualMinPrice);
        //checks if results of filtering > minPrice
        List<Integer> actualSetOfPrices = page.getActulSetOfPrices();
        for (int actualPrice: actualSetOfPrices)
            Assert.assertTrue("Filter is not applied!",actualPrice >= minPrice);
    }

    @After
    public void endTest() throws Exception {
        page.takeScreen();
        driver.quit();
    }
}
