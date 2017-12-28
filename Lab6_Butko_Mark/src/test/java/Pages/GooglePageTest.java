package Pages;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;
import static org.junit.Assert.*;

public class GooglePageTest {

    private WebDriver driver;

    private final String googleURL = "https://www.google.com.ua/";

    @Before
    public void setUp() throws Exception {
        String exePath = "E:\\Study\\Java\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-fullscreen", "--start-maximized");
        driver = new ChromeDriver(options);
        driver.get(googleURL);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void testSearchFor() throws Exception {
        GooglePage page = new GooglePage(driver);
        String  testData[][] = {
                {"laptop", "Lenovo"},
                {"laptop", "Acer"},
                {"main java framework 09990", "Zara"}};
        new File("ScreenShoots").mkdir();

        for(int k = 0; k < 3; k++){
            page.searchFor(testData[k][0]);
            int i = page.searchCompany(testData[k][1]);
            if (i>0)
                System.out.println("-----------------------------Your company " + testData[k][1]+ " on page " + i);
            else
                System.out.println("------------------------------Company " + testData[k][1] + " is not found");
            assertTrue(true);
        }
    }
}