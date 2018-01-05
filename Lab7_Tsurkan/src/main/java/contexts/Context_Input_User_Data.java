package contexts;

import pages.Contacts_Page;
import pages.Delivery_Page;
import waiters.Wait;

public class Context_Input_User_Data {
    public static Delivery_Page inputContacts(Contacts_Page page, String name, String city, String phone, String email){
        page.phone.setValue(phone);
        page.email.setValue(email);
        page.name.setValue(name);
        if (!page.city.getValue().equals(city))
            page.city.setValue(city);
        Wait.wait_for_Preloader(page.getDriver(), "//*[@id=\"step_contacts\"]/div/div[1]/div[2]/div/span", Wait.WAIT_Amount_of_Seconds);
        page.next_button.click();
        return new Delivery_Page(page.getDriver());
    }
}
