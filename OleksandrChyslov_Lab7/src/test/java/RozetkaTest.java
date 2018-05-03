import contexts.*;
import extensions.ChromeDriverEx;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import utilities.Waiters;
import utilities.screenshot;

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

        FridgesPage fridgesPage = new FridgesPage(driver);
        int minPriceValueToSet = 900, maxPriceValueToSet = 1100;
        String country = "Украина";
        //filter goods by price and country; choose first item
        FilteringContext.filterByPriceRange(fridgesPage, minPriceValueToSet, maxPriceValueToSet);
        FilteringContext.filterByCountry(fridgesPage, country);
        ItemPage itemPage = ResultsSetContext.selectElement(fridgesPage, 0);
        //assert price of chosen item is correct
        int actualPrice = ItemVerificationContext.verifyItemPrice(itemPage, minPriceValueToSet, maxPriceValueToSet);
        //click "Buy"
        CartPage cartPage = ItemShoppingContext.buy(itemPage);
        //assert total price
        ItemVerificationContext.verifyTotalPrice(cartPage, actualPrice);
        //validate purchase
        ContactsPage contactsPage = ItemShoppingContext.validatePurchase(cartPage);
        //input contacts and delivery info
        String name = "Розовая Улиточка", city = "Киев", phone = "+380982281335", email = "it_is_real_if_u_beleive@blokh.net";
        DeliveryPage deliveryPage = InputPersonalDataContext.inputContacts(contactsPage, name, city, phone, email);
        //assert sum is correct and purchase button is enabled
        ItemVerificationContext.verifySum(deliveryPage, actualPrice);
        ElementIsEnabledContext.verifyPurchaseButtonIsEnabled(deliveryPage);
        screenshot.takeScreenshot(driver);
        driver.quit();
    }
}
