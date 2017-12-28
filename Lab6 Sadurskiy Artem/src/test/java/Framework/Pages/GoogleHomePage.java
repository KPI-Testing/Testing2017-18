package Framework.Pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage {
    WebDriver driver;
    public GoogleHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "lst-ib")
    public WebElement InputField;

    @FindBy(css = "#pnnext > span:nth-child(2)")
    public WebElement ForwardWord;

    @FindBy(className = "cur")
    public WebElement CurWord;

    @FindBy(name = "btnK")
    public WebElement SearchWord;

    public GoogleHomePage SetWord(String word)
    {
        if (word == null) return this;
        InputField.sendKeys(word);
        return this;
    }

    public GoogleHomePage SubmitSearchWord()
    {
        SearchWord.sendKeys(Keys.ENTER);
        return this;
    }
}
