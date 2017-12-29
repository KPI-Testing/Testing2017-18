package pages.testpage;
import org.junit.*;
import org.openqa.selenium.*;
import pages.frameworks.*;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;
import static pages.frameworks.Methods.CheckPage;

public class Test1 {
    private static ChromeDriverEx driver;
    private static String Google_Link = "https://www.google.com.ua/";
    public static String Rozetka_Link = "https://bt.rozetka.com.ua/refrigerators/c80125/filter/";

    @BeforeClass
    public static void Init() throws Exception {
        String driverPath = "C:\\chromedriver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("disable-infobars");
        driver = new ChromeDriverEx(options);
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void Close() {
        driver.quit();
    }


    @Test
    public void Rozetka() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.get(Rozetka_Link);
        Rozetka ResultPage = new Rozetka(driver);
        int minPrice = 10000;
        ResultPage.waitLoading().setMinPrice(minPrice).submitPriceFilter().waitLoading();
        int actualMinPrice = ResultPage.getMinPrice(), actualMaxPrice = ResultPage.getMaxPrice();
        ResultPage.applySort("cheap").waitLoading();
        Assert.assertTrue("actualMinPrice != minPrice", actualMinPrice == minPrice);
        Assert.assertTrue("actualMaxPrice < actualMinPrice", actualMaxPrice >= actualMinPrice);
        List<Integer> actualSetOfPrices = ResultPage.getActulSetOfPrices();
        for (int actualPrice: actualSetOfPrices)
            Assert.assertTrue("Filter is not applied!",actualPrice >= minPrice);

    }


    @Test
    public void Test1() throws Exception {
        //google the query
        driver.get(Google_Link);
        PageStart Now = new PageStart(driver);
        PageFind Then;
        String query = "sneakers";
        String target = "Australia";
        Then = Now.Google_request(driver, query);
        Methods.Wait(driver, new By.ByCssSelector("#resultStats"), 10000, 250);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        String directory = "Test1";
        String Path = "././././Screenshots/Google/";
        File dir = new File(Path + directory);
        dir.mkdir();

        //Looking in the second page
        boolean Next;
        int count = 0;
        int NumPage = 1;
            Next = Then.NextPage();
            NumPage++;
            count+=CheckPage(true, false, driver, Then, target, Path, directory, NumPage, count);
        assertTrue(count > 0);
    }

    @Test
    public void Test2() throws Exception {
        driver.get(Google_Link);
        PageStart Now = new PageStart(driver);
        PageFind Then;
        String query = "батончик";
        String target = "Nestle";
        //google the query
        Then = Now.Google_request(driver, query);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        String directory = "Test2";
        String Path = "././././Screenshots/Google/";
        File dir = new File(Path + directory);
        dir.mkdir();

        int count = 0;
        int NumPage = 1;
        count+=CheckPage(true, true, driver, Then, target, Path, directory, NumPage, count);
        assertTrue(count > 0);
    }

    @Test
    public void Test3() throws Exception {
        driver.get(Google_Link);
        PageStart Now = new PageStart(driver);
        PageFind Then;
        String query = "батончик";
        String target = "зрада";
        //google the query
        Then = Now.Google_request(driver, query);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        String directory = "Test3";
        String Path = "././././Screenshots/Google/";
        File dir = new File(Path + directory);
        dir.mkdir();

        boolean Next;
        int count = 0;
        int NumPage = 0;
        do {
            NumPage++;
            count+=CheckPage(false, true, driver, Then, target, Path, directory, NumPage, count);
            Next = Then.NextPage();
        } while (Next);
        assertTrue(count > 0);
    }
}
