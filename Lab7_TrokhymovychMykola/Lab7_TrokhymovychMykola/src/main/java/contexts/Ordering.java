package contexts;

import extentions.NotValidDataExeption;
import helpers.Data;
import PageObjects.CheckOutPage;
import PageObjects.FinishPage;

import static contexts.Initialization.initilization;

public class Ordering {
    public static FinishPage initilizateBuy(CheckOutPage page, Data data)throws NotValidDataExeption{
        return initilization(page,data);
    }
}
