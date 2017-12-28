import contexts.*;
import extensions.ChromeDriverEx;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import waiters.Waiters;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class RozetkaTest {
    private static String driverPath = "c:\\chromedriver\\chromedriver.exe ";
    private static ChromeDriverEx driver;

    @BeforeClass
    public static void setDriverPath() throws IOException {
        System.setProperty("webdriver.chrome.driver", driverPath);
    }

    @Test
    public void test() throws Exception {
        driver = new ChromeDriverEx();
        Waiters.waitImplicit(driver, Waiters.WAIT_10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        SledgesPage sledgesPage = new SledgesPage(driver);
        int minPriceValueToSet = 100, maxPriceValueToSet = 2000;
        String country = "Украина";
        //filter goods by price and country; choose first item
        FilteringContext.filterByPriceRange(sledgesPage, minPriceValueToSet, maxPriceValueToSet);
        FilteringContext.filterByCountry(sledgesPage, country);
        ItemPage itemPage = ResultsSetContext.selectElement(sledgesPage, 0);
        //assert price of chosen item is correct
        int actualPrice = ItemVerificationContext.verifyItemPrice(itemPage, minPriceValueToSet, maxPriceValueToSet);
        //click "Buy"
        CartPage cartPage = ItemShoppingContext.buy(itemPage);
        //assert total price
        ItemVerificationContext.verifyTotalPrice(cartPage, actualPrice);
        //validate purchase
        ContactsPage contactsPage = ItemShoppingContext.validatePurchase(cartPage);
        //input contacts and delivery info
        String name = "Чубакка Петрович", city = "Киев", phone = "+380987654321", email = "chubakka_chui_petrovich@blokh.net";
        DeliveryPage deliveryPage = InputPersonalDataContext.inputContacts(contactsPage, name, city, phone, email);
        //assert sum is correct and purchase button is enabled
        ItemVerificationContext.verifySum(deliveryPage, actualPrice);
        ElementIsEnabledContext.verifyPurchaseButtonIsEnabled(deliveryPage);
        deliveryPage.takeScreenshot();
        driver.quit();
    }
}
