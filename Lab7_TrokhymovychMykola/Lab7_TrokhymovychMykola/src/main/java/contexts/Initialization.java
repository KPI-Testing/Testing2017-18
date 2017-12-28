package contexts;

import PageObjects.CheckOutPage;
import PageObjects.FinishPage;
import extentions.NotValidDataExeption;
import helpers.Data;
import utillites.Waiters;

public class Initialization {

    public static FinishPage clickOnButtonContinue(CheckOutPage page)
    {
        while(page.buttonToContinue.isDisplayed()&& page.buttonToContinue.isEnabled())
        {
            page.buttonToContinue.click();
            Waiters.thredsleep(5000);
        }
        return new FinishPage(page.getDriver());
    }

    public static FinishPage initilization(CheckOutPage page, Data person)throws NotValidDataExeption {
        page.nameAndSurname.setValue(person.getNameAndSurname());
        page.phone.setValue(person.getPhone());
        page.email.setValue(person.getEmail());
        Waiters.thredsleep(2000);
        return clickOnButtonContinue(page);
    }
}
