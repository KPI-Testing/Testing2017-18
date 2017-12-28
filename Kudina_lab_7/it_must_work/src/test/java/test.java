import Context.ChouseAndBuy;
import Context.Filtering;
import PageObject.RozetcaBuyPage;
import PageObject.RozetcaFiltersPage;
import PageObject.RozetcaSearchPage;
import extensions.ChromeDriverEx;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.print.attribute.standard.Fidelity;
import java.io.IOException;

import static Weiters.Weiters.Wait;

public class test {

    private static ChromeDriverEx driver;

    public static final String Search_page_rozetka = "https://rozetka.com.ua/beskarkasnaya-mebel/c154006/";

    @Before
    public void setUp() throws IOException {
        String exePath = "/home/nina/chromedriver";
        System.setProperty("webdriver.chrome.driver", exePath);

    }
    @Test()
    public void aTest() throws Exception {
        driver = new ChromeDriverEx();
        final String MinPrice = "200";
        final String MaxPrice = "1000";
        final String Country = "Украина";
        final String Name = "Tomas Edison";
        final String Phone = "0688141231";
        final String Mail = "kursuch.proga@gmail.com";

        driver.get(Search_page_rozetka);
        RozetcaFiltersPage filtersPage = new RozetcaFiltersPage(driver);

        Filtering.filter_by_Price(filtersPage, MinPrice, MaxPrice);
        Wait(2000);
        Filtering.filter_by_Country(filtersPage, Country);
        Wait(2000);

        RozetcaSearchPage searchPage = new RozetcaSearchPage(driver);

        ChouseAndBuy.chouse(searchPage,0);
        Wait(5000);

        RozetcaBuyPage buyPage = new RozetcaBuyPage(driver);

        ChouseAndBuy.addToBasket(buyPage);
        Wait(2000);
        ChouseAndBuy.createCheckOut(buyPage);
        Wait(2000);
        ChouseAndBuy.enterName(buyPage, Name);
        Wait(2000);
        ChouseAndBuy.enterMail(buyPage, Mail);

        ChouseAndBuy.enterPhone(buyPage, Phone);
        ChouseAndBuy.Ok(buyPage);
        Wait(2000);
        Assert.assertTrue(ChouseAndBuy.valid_make_order(buyPage));
        Wait(4000);



    }

    @After
    public void tearDown()  {
        driver.quit();
    }
}
