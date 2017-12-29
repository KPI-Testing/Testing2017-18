package pages;

import extensions.ChromeDriverEx;
import extensions.CustomFieldDecorator;
import org.openqa.selenium.support.PageFactory;


public class Page {
    protected ChromeDriverEx driver;

    public Page(ChromeDriverEx driver){
        this.driver = driver;
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }

    public ChromeDriverEx getDriver() {
        return driver;
    }

}
