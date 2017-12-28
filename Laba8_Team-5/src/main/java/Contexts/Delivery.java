package Contexts;

import Elements.RadioButton;
import PageObjects.DeliveryPage;
import Waiter.Waiter;


import java.util.List;

public class Delivery {
    private static void CheckPoint(List<RadioButton> box, String name){
        for(RadioButton iter: box)
            if(iter.getText().contains(name)) {
                iter.Checked();
                Waiter.Wait(3000);
                break;
            }
    }

    private static void inputDeliveryType(DeliveryPage page, String type){
        CheckPoint(page.getDelivery(), type);
    }

    private static void inputPaymentType(DeliveryPage page, String type){
        CheckPoint(page.getPayment(), type);
    }

    public static void inputDeliveryData(DeliveryPage page, String type1, String type2){
        inputDeliveryType(page, type1);
        inputPaymentType(page, type2);
    }

    public static boolean makeOrderButtonIsEnable(DeliveryPage page){
        return page.getMakeOrder().isEnabled();
    }
}

