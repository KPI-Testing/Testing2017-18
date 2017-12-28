import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class GooglePage
{
    private ChromeDriverEx driver;

    public GooglePage(ChromeDriverEx driver, String baseUrl){
        this.driver = driver;
        driver.get(baseUrl);
        PageFactory.initElements(this.driver, this);
    }

    //search input field
    @FindBy(how = How.ID, using = "lst-ib")
    public WebElement input;

    //"Next page" button
    @FindBy(how = How.ID, using = "pnnext")
    public WebElement nextPage;

    //list of search results
    @FindBy(how = How.CLASS_NAME, using = "rc")
    public List<WebElement> results;

    //top stuff
    @FindBy(how = How.ID, using = "topstuff")
    public WebElement topstuff;

    //navigation table at the bottom
    @FindBy(how = How.ID, using = "nav")
    public WebElement navigation;

    //inputs Text to find and click "Search"
    public GooglePage search(String searchQuery){
        input.clear();
        input.sendKeys(searchQuery);
        input.sendKeys(Keys.ENTER);
        return this;
    }

    //checks if there is any search result
    public boolean isResult(){
        String actualText = topstuff.getText(), noResultsText = "ничего не найдено.";
        return !actualText.contains(noResultsText);
    }

    //checks if this is the last page of search results (checks if the button of next page is NOT present on a current page)
    public boolean isEnd(){
        return !navigation.getText().contains("Следующая");
    }

    //goes to next page
    public GooglePage goToNextPage(){
        nextPage.click();
        return this;
    }

    //returns Strings of search results on current page
    public List<String> getResults(){
        List<String> texts = new LinkedList<String>();
        for (WebElement result: results)
            texts.add(result.getText());
        return texts;
    }

    //returns index of first result containing <name>
    //starts from 0
    //returns -1 if <name> wasn't found
    public int getIndexOf(String name){
        List<String> texts = new LinkedList<String>(getResults());
        for (int i = 0; i<texts.size(); i++){
            if(texts.get(i).contains(name))
                return i;
        }
        return -1;
    }

    //takes screenshot
    public GooglePage takeScreen(String testName, String resultName){
        try{
            File scrFile = driver.getFullScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("././././Screenshots/Google/" + System.currentTimeMillis() + "_" + testName + "_" + resultName + ".png"));
        }catch (Exception e){
            System.out.println("Exception while saving screenshot!");
        }
        return this;
    }
}