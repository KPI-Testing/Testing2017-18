import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

public class Page_Google
{
    private ChromeDriverEx driver;

    public Page_Google(ChromeDriverEx driver, String baseUrl){
        this.driver = driver;
        driver.get(baseUrl);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(how = How.ID, using = "lst-ib") public WebElement input;
    @FindBy(how = How.ID, using = "pnnext") public WebElement nextPage;
    @FindBy(how = How.CLASS_NAME, using = "rc") public List<WebElement> results;
    @FindBy(how = How.ID, using = "topstuff") public WebElement topstuff;
    @FindBy(how = How.ID, using = "nav") public WebElement navigation;

    public Page_Google search(String searchQuery){
        input.clear();
        input.sendKeys(searchQuery);
        input.sendKeys(Keys.ENTER);
        return this;
    }

    public boolean isResult(){
        String actualText = topstuff.getText(), noResultsText = "ничего не найдено.";
        return !actualText.contains(noResultsText);
    }

    public boolean isEnd(){
        return !navigation.getText().contains("Следующая");
    }

    public Page_Google goToNextPage(){ nextPage.click(); return this; }

    public List<String> getResults(){
        List<String> texts = new LinkedList<String>();
        for (WebElement result: results)
            texts.add(result.getText());
        return texts;
    }

    public int getIndexOf(String name){
        List<String> texts = new LinkedList<String>(getResults());
        for (int i = 0; i<texts.size(); i++){
            if(texts.get(i).contains(name))
                return i;
        }
        return -1;
    }


    public Page_Google takeScreen(String testName, String resultName){
        try{
            Calendar calendar = new GregorianCalendar();
            String s = new SimpleDateFormat("dd_MM_YY").format(calendar.getTime());
            File scrFile = driver.getFullScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("././././Google_Screenshots/Google__" + testName + "__" + resultName + "__" + s + ".png"));
        }catch (Exception e){
            System.out.println("Oops, something wrong with saving screenshot!");
        }
        return this;
    }
}