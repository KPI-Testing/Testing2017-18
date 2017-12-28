package Google;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UnitTest1 {
    protected WebDriver driver;
    private String _url = "http://google.co.in/";

    @Before
    public void openTheBrowser() {
        String exePath = "/Users/macbook/Documents/chromedriver";
        System.setProperty("webdriver.chrome.driver", exePath);
        driver = new ChromeDriver();
        driver.get(_url);
    }

    @After
    public void closeTheBrowser() {
        driver.quit();
    }

    @Test
    public void checkYourCompanyWebSiteIsInList() {
        GoogleSearchPage page = new GoogleSearchPage(driver);

//        // my company is on the first page
        page.searchFor("nike");
        page.searchMyCompany("https://www.nike.com/");

//        //my company is NOT on the first page
        page.searchFor("adidas");
        page.searchMyCompany("https://www.adidas.fi/");

        //my company is not in list
        // website is not real
        page.searchFor("new balance kiev");
        page.searchMyCompany("https://www.buynewbalance.com/");




    }
}
