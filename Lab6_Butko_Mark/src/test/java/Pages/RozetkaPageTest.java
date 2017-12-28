package Pages;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;
import static org.junit.Assert.*;

public class RozetkaPageTest {

    private WebDriver driver;

    private final String rozetkaURL = "https://bt.rozetka.com.ua/ua/squeezers/c80153/";

    @Before
    public void setUp() throws Exception {
        String exePath = "E:\\Study\\Java\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.get(rozetkaURL);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void checkMinPrice() throws Exception {
        RozetkaPage page = new RozetkaPage(driver);

        Integer minPrice = 4000;
        page.setMinPrice(minPrice);
        new File("ScreenShoots").mkdir();
        assertTrue(page.checkMinPrice(minPrice));
    }
}