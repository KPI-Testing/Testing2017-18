package Page_Objects;

import Extensions.ChromeDriverEx;
import Extensions.CustomFieldDecorator;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.PageFactory;

import java.io.*;

public class Screen_Page {

    protected ChromeDriverEx driver;
    public ChromeDriverEx getDriver() {
        return driver;
    }
    public Screen_Page(ChromeDriverEx driver){
        this.driver = driver;
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }
    public Screen_Page Get_Screenshot(String name) throws Exception {
        File scrFile = driver.getFullScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("././././Screenshots/"+ name + System.currentTimeMillis() + ".png"));
        } catch (IOException e){
            System.out.println("IOException while saving screenshot!");
        }
        return this;
    }
    public Screen_Page Get_Screenshot() throws Exception {
        return Get_Screenshot("");
    }
}
