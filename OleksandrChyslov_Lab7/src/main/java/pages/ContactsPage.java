package pages;

import extensions.ChromeDriverEx;
import elements.Button;
import elements.TextField;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ContactsPage extends Page{
    public ContactsPage(ChromeDriverEx driver) {
        super(driver);
    }

    @FindBy(id = "reciever_name")
    @CacheLookup
    public TextField name;

    @FindBy(id = "suggest_locality")
    @CacheLookup
    public TextField city;

    @FindBy(id = "reciever_phone")
    @CacheLookup
    public TextField phone;

    @FindBy(id = "reciever_email")
    @CacheLookup
    public TextField email;

    @FindBy(xpath = "//*[@id=\"step_contacts\"]/div/div[1]/div[2]/div/span/button")
    @CacheLookup
    public Button next;
}
