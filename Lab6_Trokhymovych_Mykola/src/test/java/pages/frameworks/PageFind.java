package pages.frameworks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;


public class PageFind {
    private WebDriver driver;
    public PageFind(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBys({
            @FindBy(className = "rc")
    })
    private List<WebElement> T;


    @FindBy(css = "#pnnext")
    private WebElement Next;
    public boolean NextPage(){
        boolean b;
        By locator = new By.ByCssSelector("#pnnext");
        if (!Methods.Find(driver, locator)) {
            b = false;
        }
        else {
            Next.click();
            b = true;
        }
        return b;

    }
   public int PageElements(ArrayList Item, int i){
        for (WebElement temp:T){
            Item.add(temp.getText());
            i++;
        }
        return i;
   }

    public WebElement getElement(int i) {
        return T.get(i);
    }
}
