package PageObjects;

import Elements.*;
import Extensions.NotValidDataException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import Utillities.Waiters;

public class CheckOutPage extends BasePage{

    public CheckOutPage (WebDriver driver){
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
    
    public FinishPage clickOnButtonContinue()throws NotValidDataException
    {
        try {
            //Waiters.waitClickableAndDisplayed(getDriver(), buttonToContinue, 5000, 2000);
            Waiters.threadsleep(2000);
            buttonToContinue.click();
        }
        catch (Exception e){
            throw new NotValidDataException();
        }
        return new FinishPage(getDriver());
    }

    public FinishPage initialisation (String fullName, String phoneNum, String emailAdd){
        nameAndSurname.setValue(fullName);
        phone.setValue(phoneNum);
        email.setValue(emailAdd);
        Waiters.threadsleep(2000);
        buttonToContinue.click();
        return new FinishPage(getDriver());
    }
}