import org.junit.*;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Test_for_Rozetka {
    private static ChromeDriverEx driver;
    private Page_Rozetka page;

    @BeforeClass
    public static void setDriverPath() throws IOException {
        System.setProperty("webdriver.chrome.driver", "F:\\3 курс\\Testing software\\lab 6\\chromedriver.exe");
    }

    @Before
    public void prepareForTest() throws Exception {
        driver = new ChromeDriverEx();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        page = new Page_Rozetka(driver, "https://rozetka.com.ua/bicycles/c83884/");
        page.setWaitLimit(30);
    }

    @Test
    public void test() throws Exception {
        int minPrice = 15000;
        page.waitLoading().setMinPrice(minPrice).submitPriceFilter().waitLoading();
        int actualMinPrice = page.getMinPrice(), actualMaxPrice = page.getMaxPrice();
        page.applySort("cheap").waitLoading();
        Assert.assertTrue("actualMinPrice != minPrice", actualMinPrice == minPrice);
        Assert.assertTrue("actualMaxPrice < actualMinPrice", actualMaxPrice >= actualMinPrice);
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
