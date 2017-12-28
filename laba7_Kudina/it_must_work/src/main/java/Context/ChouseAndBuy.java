package Context;

import PageObject.RozetcaBuyPage;
import PageObject.RozetcaSearchPage;

import javax.print.attribute.standard.MediaSize;

public class ChouseAndBuy {
    public static void chouse (RozetcaSearchPage page, int index){
        page.chouse_the_result(index);
    }

    public static void addToBasket(RozetcaBuyPage page){
        page.setAddToBasket();
    }

    public static void createCheckOut(RozetcaBuyPage page){
        page.setCreateCheckout();
    }

    public static void enterName(RozetcaBuyPage page, String Name){
        page.setName(Name);
    }

    public static void enterPhone(RozetcaBuyPage page, String Phone){
        page.setPhone(Phone);
    }

    public static void enterMail(RozetcaBuyPage page, String Mail){
        page.setMail(Mail);
    }

    public static void Ok(RozetcaBuyPage page){
        page.setOK();
    }

    public static boolean valid_make_order(RozetcaBuyPage page){
        return page.setMakeOrder();
    }
}
