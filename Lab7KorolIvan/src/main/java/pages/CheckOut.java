package pages;

import elements.TextField;
import elements.customdecorator.CustomFieldDecorator;
import extentions.NotValidDataExeption;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import helpers.*;
import org.openqa.selenium.support.ui.Wait;
import utill.Waiters;

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


    public Finish clickOnButtonContinue()throws NotValidDataExeption
    {
        try {
            //Waiters.waitClickableAndDisplayed(getDriver(), buttonToContinue, 5000, 2000);
            Waiters.thredsleep(2000);
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
}
