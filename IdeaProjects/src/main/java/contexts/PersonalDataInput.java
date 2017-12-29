package contexts;

import pages.Contacts;
import pages.Delivery;
import waiters.Waiters;

public class PersonalDataInput {
    public static Delivery inputContacts(Contacts page, String name, String city, String phone, String email){
        page.phone.setValue(phone);
        page.email.setValue(email);
        page.name.setValue(name);
        if (!page.city.getValue().equals(city))
            page.city.setValue(city);
        Waiters.waitForPreloader(page.getDriver(), "//*[@id=\"step_contacts\"]/div/div[1]/div[2]/div/span", Waiters.WAIT_10);
        page.next.click();
        return new Delivery(page.getDriver());
    }
}
