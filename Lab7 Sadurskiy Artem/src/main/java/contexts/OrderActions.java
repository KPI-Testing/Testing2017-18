package contexts;

import pages.CheckOutPage;

public class OrderActions {
        public static CheckOutPage initilizateBuy(CheckOutPage page, String fio, String phoneNum, String myEmail){
            return page.initilization(fio, phoneNum, myEmail);
        }
}
