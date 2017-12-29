package Page_Objects;

import Elements.*;
import Extensions.ChromeDriverEx;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CheckOut_Page extends Screen_Page {

    public CheckOut_Page(ChromeDriverEx driver) {
        super(driver);
    }

    @FindBy(id = "reciever_name")
    @CacheLookup
    public Text_Field name;

    @FindBy(id = "suggest_locality")
    @CacheLookup
    public Text_Field city;

    @FindBy(id = "reciever_phone")
    @CacheLookup
    public Text_Field phone;

    @FindBy(id = "reciever_email")
    @CacheLookup
    public Text_Field email;

    @FindBy(xpath = "//*[@id=\"step_contacts\"]/div/div[1]/div[2]/div/span/button")
    @CacheLookup
    public Button continue_button;
}
