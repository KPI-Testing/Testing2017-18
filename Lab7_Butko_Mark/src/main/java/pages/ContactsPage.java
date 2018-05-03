package pages;

import elements.Button;
import elements.TextField;
import extensions.ChromeDriverEx;
import org.openqa.selenium.support.FindBy;

public class ContactsPage extends Page{

    public ContactsPage(ChromeDriverEx driver){
        super(driver);
    }

    @FindBy(id = "reciever_name")
    private TextField nameField;

    @FindBy(id = "suggest_locality")
    private TextField townField;

    @FindBy(id = "reciever_phone")
    private TextField phoneField;

    @FindBy(id = "reciever_email")
    private TextField emailField;

    @FindBy(id = "continue_button")
    private Button continueButton;

    public TextField getNameField() {
        return nameField;
    }

    public TextField getTownField() {
        return townField;
    }

    public TextField getPhoneField() {
        return phoneField;
    }

    public TextField getEmailField() {
        return emailField;
    }

    public Button getContinueButton() {
        return continueButton;
    }
}
