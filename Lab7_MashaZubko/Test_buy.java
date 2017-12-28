package Lab7.test;

import Lab7.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.AfterClass;
import java.util.concurrent.TimeUnit;

public class Test_buy {

    private static WebDriver driver;
    private HomePage homePage;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDown() {
       // driver.quit();
    }

    @Test
    public void testAddingItemToCard() throws InterruptedException {
        homePage = new HomePage(driver).open();
        SearchResult searchResultsPage = homePage.Elements().searchFor("український виробник");
        searchResultsPage = searchResultsPage.getPrice("100","2000");
        Order order = searchResultsPage.clickFirstResult();
        CheckStatus status = order.submit_order("Maria", "0960000000","example_lab7test@gmail.com");
        status.checkStatus();
    }
}

