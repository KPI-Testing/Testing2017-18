package pages;

import extensions.ChromeDriverEx;
import extensions.CustomFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class Page {

    protected ChromeDriverEx driver;

    public Page(ChromeDriverEx d){
        driver = d;
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }

    public void takeScreenShoot(String Name) throws Exception{
        driver.takeScreenShoot("ScreenShoots\\" + Name + ".png");
    }

    public ChromeDriverEx getDriver() {
        return driver;
    }
}
