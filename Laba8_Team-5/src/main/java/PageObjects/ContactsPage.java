package PageObjects;

import Elements.Button;
import Elements.TextField;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


public class ContactsPage extends BasePage{

    public ContactsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "reciever_name")
    private TextField Name;

    @FindBy(id = "reciever_phone")
    private TextField PhoneNumber;

    @FindBy(id = "reciever_email")
    private TextField Email;

    @FindBy(css = ".check-f-i-field [name = \"next_step\"]")
    private Button buttonNext;

    public void inputName(String name){
        Name.setValue(name);
    }

    public void inputPhoneNumber(String number){
        if (number.trim().matches("\\+?(38)?-?\\d{3}-?\\d{3}-?\\d{2}-?\\d{2}"))
            PhoneNumber.setValue(number);
    }

    public void inputEmail(String email){
        if(email.trim().matches("[a-z._]+@[a-z]+\\.[a-z]+"))
            Email.setValue(email);
    }

    public void nextStepOfConfirm(){
        if(buttonNext.isEnabled()){
            buttonNext.click();
        }
    }

    public Button getButtonNext() {
        return buttonNext;
    }
}

