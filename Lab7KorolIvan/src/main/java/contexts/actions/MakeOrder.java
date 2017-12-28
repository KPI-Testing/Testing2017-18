package contexts.actions;

import extentions.NotValidDataExeption;
import helpers.PersonData;
import pages.CheckOut;
import pages.Finish;

public class MakeOrder {
    public static Finish initilizateBuy(CheckOut page, PersonData data)throws NotValidDataExeption{
        return page.initilization(data);
    }
}
