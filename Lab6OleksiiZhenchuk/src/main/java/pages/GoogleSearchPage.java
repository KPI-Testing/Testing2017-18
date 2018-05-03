package pages;

import com.assertthat.selenium_shutterbug.core.PageSnapshot;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class GoogleSearchPage {
    private WebDriver driver;

    @FindBy(id = "pnnext")
    private WebElement nextButton;

    @FindBy(className = "srg")
    private WebElement searchResults;
    
    @FindBy(css = ".cur")
    private  WebElement tdPageNum;


    public GoogleSearchPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public int getPageNumber(){
    	String text = tdPageNum.getText().trim();
    	return Integer.parseInt(text);
    }
    
    public GoogleSearchPage getNextPage(){
        nextButton.click();
        return new GoogleSearchPage(driver);
    }

    public boolean contains(String keyword ){
        List<WebElement> results = driver.findElements(By.className("g"));
        boolean contain = false;
        for (WebElement result : results ) {
            String text = result.getText().toLowerCase();
            if (text.contains(keyword.toLowerCase())){
                contain = true;
                break;
            }
        }
        return contain;
    }

    public PageSnapshot getScreenshot ( ){
        return Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS) ;
    }

    public boolean isNotLast(){
        return driver.findElements(By.id("pnnext")).size() > 0;
    }

}