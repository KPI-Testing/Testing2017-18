package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import org.openqa.selenium.WebDriver;


public class GooglePage extends  Page{

    @FindBy(id="lst-ib")
    private WebElement searchField;

    @FindBy(id="pnnext")
    private WebElement buttonNext;

    @FindBy(id="pnprev")
    private WebElement buttonPrev;

    @FindBy(how = How.CLASS_NAME, using ="rc")
    private List<WebElement> pageList;

    public void nextPage(){
        buttonNext.click();
    }

    public void prevPage(){
        buttonPrev.click();
    }

    public GooglePage(WebDriver driver){
        super(driver);
    }

    public void searchFor (String keyWord)throws Exception{
        searchField.clear();
        searchField.sendKeys(keyWord);
        searchField.submit();
        //Thread.sleep(15000);
    }

    public int searchCompany(String companyName)throws Exception{
        for(int pageCounter = 1;  ; pageCounter++, nextPage()) {
            for (WebElement pageContent : pageList) {
                String pageText = pageContent.getText().toLowerCase();
                if (pageText.contains(companyName.toLowerCase())) {
                    takeScreenShoot(companyName + "_" + pageCounter);
                    return pageCounter;
                }
            }
            try{
                WebElement temp = driver.findElement(By.id("pnnext"));
            }
            catch(NoSuchElementException ex){
                for(int pageCounterDec = pageCounter; ; pageCounterDec--, prevPage()){
                        takeScreenShoot(companyName + "_" + pageCounterDec);
                    try{
                        WebElement temp = driver.findElement(By.id("pnprev"));
                    }
                    catch(NoSuchElementException exeption){
                        return -1;//if not found
                    }
                }
            }
        }
    }
}
