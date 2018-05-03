package pages;

import contexts.ContactsContext;
import contexts.FilterContext;
import contexts.ShopContext;
import extensions.ChromeDriverEx;
import helpers.Contacts;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.File;
import static org.junit.Assert.*;

public class RozetkaTest {

    private ChromeDriverEx driver;

    private final String URL = "https://rozetka.com.ua/ua/krepkie-napitki/c4594292/filter/vid-napitka-69821=vodka/";

    @Before
    public void setUp() throws Exception {
        String exePath = "E:\\Study\\Java\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        driver = new ChromeDriverEx();
        driver.get(URL);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void isConfirmButtonEnabled() throws Exception {
        SearchPage searchPage = new SearchPage(driver);

        Integer minPrice = 200;
        Integer maxPrice = 2000;
        String country = "Україна";

        FilterContext.setPriceRange(searchPage, minPrice, maxPrice);
        FilterContext.setCountry(searchPage, country);
        assertTrue(((searchPage.getMinPrice() >= minPrice)) && ((searchPage.getMaxPrice() <= maxPrice)));

        ProductPage productPage = ShopContext.getProductPage(searchPage, 3);

        BasketPage basketPage = ShopContext.clickBuyButton(productPage);

        ContactsPage contactsPage = ShopContext.makeOrder(basketPage);
        ContactsContext.setAllContacts(contactsPage, new Contacts());

        ConfirmPage confirmPage = ContactsContext.next(contactsPage);
        assertTrue(confirmPage.getConfirmButton().isEnabled());
        new File("ScreenShoots").mkdir();
        confirmPage.takeScreenShoot("ConfirmPage");
    }
}