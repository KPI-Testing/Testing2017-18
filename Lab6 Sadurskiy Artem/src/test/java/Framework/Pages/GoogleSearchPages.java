package Framework.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.*;



public class GoogleSearchPages {
    private ChromeDriverEx driver;
    public GoogleSearchPages(ChromeDriverEx driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBys({
            @FindBy(className = "rc")
    })
    private List<WebElement> T;


    @FindBy(css = "#pnnext")
    private WebElement Next;


    @FindBy(name = "btnK")
    public WebElement SearchWord;

    @FindBy(className = "r")
    public List<WebElement> GoogleLinks;

    @FindBy(className = "st")
    public List<WebElement> GoogleLinksDescription;


        public boolean ListPages(){
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

    public boolean FindWord(String word)
    {

        StringBuilder links = new StringBuilder();
        StringBuilder description = new StringBuilder();
        for (WebElement element : GoogleLinks)
        {
            links.append(element.getText() + "\n");
        }
        for (WebElement element : GoogleLinksDescription)
        {
            description.append(element.getText() + "\n");
        }
        if(links.toString().contains(word) || description.toString().contains(word))
        {
            System.out.println(links.toString());
            System.out.println(description.toString());
            return true;
        }
        else
            return false;
    }



}
