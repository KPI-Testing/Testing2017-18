package PageObjects;
import Elements.CustomFieldDecorator.CustomFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class BasePage {
    public WebDriver driver;

    BasePage(WebDriver driver_) {
        this.driver = driver_;
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }
    public WebDriver get_driver(){
        return driver;
    }
}
