import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestCase {
    static WebDriver driver;
    static private String siteURL = "https://rozetka.com.ua/notebooks/c80004/filter/producer=apple/";


    @Before
    public void setUp(){
        String exePath = "/home/lena/chromedriver/chromedriver";
        System.setProperty("webdriver.chrome.driver", exePath);
        driver = new ChromeDriver();
        driver.get("https://www.google.com.ua/");
        driver.get(siteURL);
    }

   @Test
    public void filterNegative ( ) {
        NotebookPage notebooks = new NotebookPage(driver);
        int minNegative = -100;
        notebooks = notebooks.filterMin(minNegative);
        int siteMin =  notebooks.getFilteredMin();
        Assert.assertTrue( ( siteMin >=  0) && ( minNegative < 0) );
    }

   @Test
    public void filterPageTest ( ) {
        NotebookPage notebooks = new NotebookPage(driver);
        int userMin = 20000;
        notebooks = notebooks.filterMin(userMin);
        int siteMin = notebooks.getFilteredMin();
        boolean isf = notebooks.isFilteredMin(siteMin);

        //printing results
        if  ( siteMin == userMin ) {
            System.out.println( "You're lucky ! There are cheaper items in this category " );
            System.out.println(isf);
        }else {
            System.out.println(" Oh there isn't any cheaper items in this category. Let's compare  results with automin ");
            System.out.println(isf);
        }
    }

    @After
    public void tearDown ( ){
        driver.quit();
    }
}
