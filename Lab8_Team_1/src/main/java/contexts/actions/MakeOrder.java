package contexts.actions;

import extentions.NotValidDataExeption;
import helpers.PersonData;
import pages.CheckOut;
import pages.Finish;
import utils.Waiters;

public class MakeOrder {
    private static Finish clickOnButtonContinue(CheckOut page)throws NotValidDataExeption {
        try {
            //Waiters.waitClickableAndDisplayed(getDriver(), buttonToContinue, 5000, 2000);
           //Waiters.thredsleep(2000);
            page.getButtonToContinue().click();

        } catch (Exception e) {
            throw new NotValidDataExeption();
        }
        return new Finish(page.getDriver());

    }
    public static Finish initilizateBuy(CheckOut page, PersonData person)throws NotValidDataExeption{

        page.getNameAndSurname().setValue(person.getNameAndSurname());
        page.getPhone().setValue(person.getPhone());
        page.getEmail().setValue(person.getEmail());
        return clickOnButtonContinue(page);
    }
}
