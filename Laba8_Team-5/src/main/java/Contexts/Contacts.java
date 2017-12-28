package Contexts;

import PageObjects.ContactsPage;
import PageObjects.DeliveryPage;
import Waiter.Waiter;

public class Contacts {
     public static void inputContatData(ContactsPage page, String name, String phone, String email){
        page = inputContatData(page, name, phone);
        page.inputEmail(email);
        Waiter.Wait(1000);
    }

    private static ContactsPage inputContatData(ContactsPage page, String name, String phone){
        page.inputName(name);
        page.inputPhoneNumber(phone);
        Waiter.Wait(1000);
        return page;
    }

    public static DeliveryPage chooseDeliveryType(ContactsPage page){
        page.nextStepOfConfirm();
        return new DeliveryPage(page.driver);
    }

    public static boolean ButtonNextIsClickable(ContactsPage page){
        return page.getButtonNext().isEnabled();
    }
}
