package PageObject;

import extensions.ChromeDriverEx;
import extensions.custom_decorator.CustomFieldDecorator;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class RozetcaResultPage {
    protected ChromeDriverEx driver;

    public RozetcaResultPage(ChromeDriverEx driver){
        this.driver = driver;
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }

    public ChromeDriverEx getDriver() {
        return driver;
    }
}
