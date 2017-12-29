package pages.frameworks;
import pages.frameworks.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;

public class Google {
    private static ChromeDriverEx driver;
    private static String URL_Google = "https://www.google.com.ua/";


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
    public void Apple() throws Exception {
        GoogleEngine StartPage = new GoogleEngine(driver);
        driver.get(URL_Google);
        StartPage.Search("apple").PageLinkSearch("www.apple.com");
    }

    @Test
    public void Tesla() throws Exception {
        GoogleEngine StartPage = new GoogleEngine(driver);
        driver.get(URL_Google);
        StartPage.Search("tesla").PageLinkSearch("seekingalpha.com");
    }

    @Test
    public void Me() throws Exception {
        GoogleEngine StartPage = new GoogleEngine(driver);
        driver.get(URL_Google);
        StartPage.Search("Viacheslav").PageLinkSearch("viacheslav.com");
    }
}

