package pages;

import elements.TextField;
import elements.customdecorator.CustomFieldDecorator;
import extentions.NotValidDataExeption;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import helpers.*;
import org.openqa.selenium.support.ui.Wait;
import utils.Waiters;

import java.util.concurrent.TimeUnit;

public class CheckOut extends BasePage{

    public CheckOut (WebDriver driver){
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
    private WebElement MakeOrder;


    public Finish clickOnButtonContinue()throws NotValidDataExeption
    {
        try {
            //Waiters.waitClickableAndDisplayed(getDriver(), buttonToContinue, 5000, 2000);
            buttonToContinue.click();

        }
        catch (Exception e){
            throw new NotValidDataExeption();
        }


        return new Finish(getDriver());
    }

    public Finish initilization (PersonData person)throws NotValidDataExeption{
        nameAndSurname.setValue(person.getNameAndSurname());
        phone.setValue(person.getPhone());
        email.setValue(person.getEmail());
        return clickOnButtonContinue();
    }


    public WebElement getMakeOrder() {
        return MakeOrder;
    }

    public TextField getNameAndSurname() {
        return nameAndSurname;
    }

    public CheckOut setNameAndSurname(TextField nameAndSurname) {
        this.nameAndSurname = nameAndSurname;
        return this;
    }

    public TextField getLocality() {
        return locality;
    }

    public CheckOut setLocality(TextField locality) {
        this.locality = locality;
        return this;
    }

    public TextField getPhone() {
        return phone;
    }

    public CheckOut setPhone(TextField phone) {
        this.phone = phone;
        return this;
    }

    public TextField getEmail() {
        return email;
    }

    public CheckOut setEmail(TextField email) {
        this.email = email;
        return this;
    }

    public WebElement getButtonToContinue() {
        return buttonToContinue;
    }

    public CheckOut setButtonToContinue(WebElement buttonToContinue) {
        this.buttonToContinue = buttonToContinue;
        return this;
    }
}
