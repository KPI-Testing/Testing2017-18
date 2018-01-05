package pages;

import extensions.ChromeDriverEx;
import extensions.custom_decorator.CustomFieldDecorator;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class Page {
    protected ChromeDriverEx driver;

    public Page(ChromeDriverEx driver){
        this.driver = driver;
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }

    public ChromeDriverEx getDriver() {
        return driver;
    }

    public Page takeScreenshot(String name) throws Exception {
        File scrFile = driver.getFullScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("././././Screenshots/"+ name + System.currentTimeMillis() + ".png"));
        } catch (IOException e){
            System.out.println("IOException while saving screenshot!");
        }
        return this;
    }

    public Page takeScreenshot() throws Exception {
        return takeScreenshot("");
    }
}
