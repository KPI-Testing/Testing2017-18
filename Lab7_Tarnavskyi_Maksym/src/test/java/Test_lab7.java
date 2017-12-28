import contexts.*;
import extensions.ChromeDriverEx;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import waiters.Wait;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class Test_lab7 {
    private static String driverPath = "C:\\Users\\User\\Testing_Java\\lib_max\\chromedriver.exe";
    private static ChromeDriverEx driver;

    @BeforeClass
    public static void setDriverPath() throws IOException {
        System.setProperty("webdriver.chrome.driver", driverPath);
    }

    @Test
    public void test() throws Exception {

        driver = new ChromeDriverEx();
        Wait.wait_Implicit(driver, Wait.WAIT_Amount_of_Seconds, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        Search_Page search_Page = new Search_Page(driver);
        int min_Price = 100;
        int max_Price = 2000;
        String country = "Украина";
        String name = "Функан Функанович";
        String city = "Киев";
        String phone_number = "+380987654323";
        String email = "funckan_one_love@ukr.net";


        Context_Filtering.filter_by_Price(search_Page, min_Price, max_Price);
        Context_Filtering.filter_by_Country(search_Page, country);


        Item_Page item_Page = Context_Buying_Item.selectElement(search_Page, 0);
        int current_Price = Context_Item_Verification.verify_Item_Price(item_Page, min_Price, max_Price);

        Basket_Page basket_Page = Context_Buying_Item.buy(item_Page);
        Context_Item_Verification.verify_Total_Price(basket_Page, current_Price);
        Contacts_Page contacts_Page = Context_Buying_Item.validate_Purchase(basket_Page);

        Delivery_Page delivery_Page = Context_Input_User_Data.inputContacts(contacts_Page, name, city, phone_number, email);
        Context_Item_Verification.verify_Total_Price(delivery_Page, current_Price);
        Context_Item_Verification.verify_Purchase_Button_Is_Enabled(delivery_Page);

        delivery_Page.takeScreenshot();
        driver.quit();
    }
}
