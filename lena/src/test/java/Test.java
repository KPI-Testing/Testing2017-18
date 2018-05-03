import Contexts.Buy;
import Contexts.FilterContext;
import PageObjects.Glue;
import PageObjects.ResultsPageGlue;
import Waiter.Waiter;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Test {
    static WebDriver driver;
    static Waiter waiter;

    @Before
    public void setUp() {
        String exePath = "./src/main/java/Drivers/chromedriver";
        System.setProperty("webdriver.chrome.driver", exePath);
        driver = new ChromeDriver();
        waiter = new Waiter();
    }


    @org.junit.Test
    public void aTest() throws InterruptedException {

        String producerCountry = "Україна";
        ResultsPageGlue products = new ResultsPageGlue(driver);
        products.get();
        waiter.waitForLoad(driver);

        FilterContext.filterRange(products, 200, 1000);
        FilterContext.assertRangePrice(products, 200, 1000);


        FilterContext.filterProducer(products,producerCountry );
        Glue glue = Buy.buy(products, 0);


        waiter.waitForLoad(driver);
    }
    @After
    public void tearDown()  {
        driver.quit();
    }
}
