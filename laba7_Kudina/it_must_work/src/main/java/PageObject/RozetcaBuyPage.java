package PageObject;

import Elements.*;
import extensions.ChromeDriverEx;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class RozetcaBuyPage extends RozetcaResultPage{

    public RozetcaBuyPage(ChromeDriverEx driver){
        super(driver);
    }

    @FindBy(id = "popup-checkout")
    private Button createCheckout;

    @FindBy(xpath = ".//*[@id='detail_buy_label']/div[3]/div[1]/div/form/span/span/button")
    private Button addToBasket;

    @FindBy(xpath = ".//*[@id='reciever_name']")
    private TextField Name;

    @FindBy(xpath = ".//*[@id='reciever_phone']")
    private TextField Phone;

    @FindBy(xpath = ".//*[@id='reciever_email']")
    private TextField Mail;

    @FindBy(id = "continue_button")
    private Button OK;

    @FindBy(xpath = ".//*[@id='make-order']")
    private Button makeOrder;

    public void setCreateCheckout(){
        createCheckout.click();
    }

    public void setAddToBasket(){
        addToBasket.click();
    }

    public void setName(String name){
        Name.setValue(name);
    }

    public void setPhone(String phone){
        Phone.setValue(phone);
    }

    public void setMail(String mail){
        Mail.setValue(mail);
    }

    public void setOK(){
        OK.click();
    }

    public boolean setMakeOrder(){
        if(makeOrder.isEnabled())
            return true;
        else
            return false;
    }

}
