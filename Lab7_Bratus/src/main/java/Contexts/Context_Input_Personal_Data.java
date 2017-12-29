package Contexts;

import Page_Objects.CheckOut_Page;
import Page_Objects.Delivery_Page;
import Waiters.Waiters;

public class Context_Input_Personal_Data {
    public static Delivery_Page inputContacts(CheckOut_Page page, String name, String city, String phone, String email){
        page.name.setValue(name);
        if (!page.city.getValue().equals(city)) page.city.setValue(city);
        page.phone.setValue(phone);
        page.email.setValue(email);
        Waiters.Wait_For_Preloader(page.getDriver(), "//*[@id=\"step_contacts\"]/div/div[1]/div[2]/div/span", Waiters.Wait_15_seconds);
        page.continue_button.click();
        return new Delivery_Page(page.getDriver());
    }
}
