import Contexts.*;
import Extensions.ChromeDriverEx;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Page_Objects.*;
import Waiters.Waiters;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class Rozetka_Test {
    private static String driverPath = "C:\\Users\\admin\\Desktop\\chromedriver.exe";
    private static ChromeDriverEx driver;

    @BeforeClass
    public static void setDriverPath() throws IOException {
        System.setProperty("webdriver.chrome.driver", driverPath);
    }

    @org.testng.annotations.Test
    public void test() throws Exception {

        driver = new ChromeDriverEx();
        Waiters.Wait_Implicit(driver, Waiters.Wait_15_seconds, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        Search_Page search_Page = new Search_Page(driver);
        int min_Price = 100;
        int max_Price = 2000;
        String name = "Тестирование Тестировальное";
        String country = "Украина";
        String city = "Киев";
        String phone_number = "+380953458787";
        String email = "testing_for_testing@gmail.com";

        Context_Filter.Filter_By_Price(search_Page, min_Price, max_Price);
        Context_Filter.filter_by_country(search_Page, country);
        Item_Page item_Page = Context_Buy_Product.Select_Element(search_Page, 1);
        int current_Price = Context_Item_Verification.verify_item_price(item_Page, min_Price, max_Price);
        Card_Page basket_Page = Context_Buy_Product.Click_Element(item_Page);
        Context_Item_Verification.Verify_Total_Price(basket_Page, current_Price);
        CheckOut_Page contacts_Page = Context_Buy_Product.Buy_Element(basket_Page);
        Delivery_Page delivery_Page = Context_Input_Personal_Data.inputContacts(contacts_Page, name, city, phone_number, email);
        Context_Item_Verification.Verify_Total_Price(delivery_Page, current_Price);
        Context_Item_Verification.Verify_Purchase_Button_Is_Enabled(delivery_Page);

        delivery_Page.Get_Screenshot();
        driver.quit();
    }
}
