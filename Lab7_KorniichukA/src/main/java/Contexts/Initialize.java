package Contexts;

        import Pageobj.CheckOutPage;
        import Pageobj.LastPage;
        import Data_to_Insert.WrongDataExeption;
        import Data_to_Insert.Data;
        import Utills.Waiters;

public class Initialize {

    public static LastPage clickOncont(CheckOutPage page) {
        while(page.buttonContinue.isDisplayed()&& page.buttonContinue.isEnabled()) {
            page.buttonContinue.click();
            Waiters.thredsleep(5000);
        }
        return new LastPage(page.getDriver());
    }

    public static LastPage field_init(CheckOutPage page, Data person)throws WrongDataExeption {
        page.name.set_value(person.get_Name_Surname());
        page.locality.set_city("Київ");
        page.phone.set_value(person.getPhone());
        page.email.set_value(person.getEmail());

        Waiters.thredsleep(2000);
        return clickOncont(page);
    }
}