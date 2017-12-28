package pages.frameworks;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageStart{
    WebDriver driver;
    public PageStart(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#lst-ib")
    private WebElement GoogleStartField;

    public PageFind GoTo(ChromeDriverEx driver,String search){
        PageFind temp = new PageFind(driver);
        GoogleStartField.sendKeys(search);
        GoogleStartField.sendKeys(Keys.ENTER);
        return temp;
    }
}
