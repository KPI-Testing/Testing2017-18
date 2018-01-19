package contexts;

import helpers.Contacts;
import pages.ContactsPage;
import pages.ConfirmPage;
import util.Waiters;

public class ContactsContext {

    public static void setName(ContactsPage contactsPage, String name){
        contactsPage.getNameField().setValue(name);
    }

    public static void setTown(ContactsPage contactsPage, String town){
        if (! contactsPage.getTownField().getValue().equals(town) ) {
            contactsPage.getTownField().setValue(town);
            contactsPage.getDriver().findElementByCssSelector("ul.suggestions > li[text=\"" + town + "\"]").click();
        }
    }

    public static void setPhoneNumber(ContactsPage contactsPage, String phone){
        contactsPage.getPhoneField().setValue(phone);
    }

    public static void setEmail(ContactsPage contactsPage, String email){
        contactsPage.getEmailField().setValue(email);
    }

    public static void setAllContacts(ContactsPage contactsPage, Contacts contacts){
        setName(contactsPage, contacts.name);
        setTown(contactsPage, contacts.town);
        setPhoneNumber(contactsPage, contacts.phone);
        setEmail(contactsPage, contacts.email);
    }

    public static ConfirmPage next(ContactsPage contactsPage){
        Waiters.waitForVisibilityById(contactsPage.getDriver(),"continue_button");
        contactsPage.getContinueButton().click();
        return new ConfirmPage(contactsPage.getDriver());
    }
}
