package pages;

import com.assertthat.selenium_shutterbug.core.PageSnapshot;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;
public class GoogleResultsPage {
    private WebDriver driver;

    @FindBy(id = "pnnext")
    private WebElement nextButtom;

    @FindBy(className = "srg")
    private WebElement searchResults;

    @FindBy(id = "resultStats")
    private WebElement resultStatus;

    @FindBy( className = "g")
    private  WebElement result;


    public GoogleResultsPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    public int getPageNumber(){
        String text = resultStatus.getText();
        Pattern pattern = Pattern.compile("(?<=Сторінка ).*?(?=\\s)");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            int pageNumber = parseInt(matcher.group(0));
            return pageNumber;
        }else {
            return 1;
        }
    }
    public GoogleResultsPage  getNextPage(){
        nextButtom.click();
        return new GoogleResultsPage(driver);
    }

    public boolean contains(String keyword ){
        List<WebElement> results = driver.findElements(By.className("g"));
        boolean contain = false;
        for (WebElement result : results ) {
            String text = result.getText();
            if (text.contains(keyword)){
                this.screenElement(result, keyword);
                contain = true;
                break;
            }
        }
        return contain;
    }

    public void  screenElement (WebElement element, String keyword ){
        String screenPath = "/home/lena/SCHOOL/Testing/tests/helpforgit//GoogleTest/";
        Shutterbug.shootElement(driver, element).withName(keyword).save(screenPath);
    }

    public PageSnapshot getScreenshot ( ){
        return Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS) ;
    }

    public boolean isNotLast(){
        return driver.findElements(By.id("pnnext")).size() > 0;
    }

}
