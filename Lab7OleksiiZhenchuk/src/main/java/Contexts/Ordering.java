package Contexts;

import PageObjects.CheckOutPage;
import PageObjects.FinishPage;

public class Ordering {
	public static FinishPage initilisateBuy(CheckOutPage page, String fullName, String phoneNum, String email){
        return page.initialisation(fullName, phoneNum, email);
    }
}