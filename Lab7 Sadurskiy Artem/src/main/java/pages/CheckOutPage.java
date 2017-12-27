package pages;

import elements.TextField;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import utill.Waiters;

public class CheckOutPage extends BasePage{

    public CheckOutPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "reciever_name")
    private TextField nameAndSurname;

    @FindBy(id = "suggest_locality")
    private TextField locality;

    @FindBy(id = "reciever_phone")
    private TextField phone;

    @FindBy(id = "reciever_email")
    private TextField email;

    @FindBy(css = ".btn-link.btn-link-green.check-step-btn-link.opaque>button")
    private WebElement buttonToContinue;

    @FindBy(id = "make-order")
    private WebElement makeOrder;


    public CheckOutPage clickOnButtonContinue()
    {
        Waiters.threadSleep(2000);
        buttonToContinue.click();
        return this;
    }

    public CheckOutPage initilization (String fio, String phoneNum, String myEmail){
        nameAndSurname.setValue(fio);
        phone.setValue(phoneNum);
        email.setValue(myEmail);
        Waiters.threadSleep(2000);
        buttonToContinue.click();
        return this;
    }

    public boolean isCorrectOrder(){
        return makeOrder.isDisplayed();
    }
}
