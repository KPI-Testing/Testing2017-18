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

        Sledges sledges = new Sledges(driver);

        int minPriceValueToSet = 100, maxPriceValueToSet = 2000;
        String country = "Украина";


        Filtering.filterByPriceRange(sledges, minPriceValueToSet, maxPriceValueToSet);
        Filtering.filterByCountry(sledges, country);
        Item item = SetResults.selectElement(sledges, 0);


        int actualPrice = Verification.verifyItemPrice(item, minPriceValueToSet, maxPriceValueToSet);

        Cart cartPage = Purchase.buy(item);

        Verification.verifyTotalPrice(cartPage, actualPrice);

        Contacts contactsPage = Purchase.validatePurchase(cartPage);

        String name = "Анна Ярославна", city = "Киев", phone = "+380987987621", email = "yaroslavna@lokh.net";
        Delivery delivery = PersonalDataInput.inputContacts(contactsPage, name, city, phone, email);

        Verification.verifySum(delivery, actualPrice);
        ElementIsEnabled.verifyPurchaseButtonIsEnabled(delivery);
        delivery.takeScreenshot();
        driver.quit();
    }
}
