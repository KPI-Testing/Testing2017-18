package pages.frameworks;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;

public class Rozetka {
    private static ChromeDriverEx driver;
    private static String URL_Rozetka = "https://rozetka.com.ua/notebooks/c80004/filter/preset=660/";


    @BeforeClass
    public static void set_up() throws Exception {
        String exePath = "c:\\chromedriver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("disable-infobars");
        driver = new ChromeDriverEx(options);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();


    }


    @AfterClass
    public static void close() {
        driver.quit();
    }


    @Test
    public void RozetkaFilter() throws Exception {
        RozetkaEngine StartPage = new RozetkaEngine(driver);
        driver.get(URL_Rozetka);
        StartPage.FilterCheck(10899);
    }

}

