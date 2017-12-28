package Google;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class SearchPage {
    private ChromeDriverEx driver;
    SearchPage(ChromeDriverEx driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "lst-ib")
    private WebElement searchField;
    private List <WebElement> heads;


    List<String> getStringHeads(){
        heads = driver.findElements(new By.ByClassName("rc"));
        List<String> s_heads = new ArrayList<String>(heads.size());
        for (WebElement head: heads){
            s_heads.add(head.getText());
        }
        return s_heads;
    }


    void enterSearchData(String searchData){
        searchField.sendKeys(searchData);
        searchField.sendKeys(Keys.ENTER);
    }

    SearchPage next_page(){
        try {
            WebElement next_button = driver.findElement(By.cssSelector("#pnnext"));
            next_button.click();
            return new SearchPage(driver);}
            catch (NoSuchElementException e){
                return null;
            }
    }

    void get_screenshot(String path) throws Exception {
        File screenshot = driver.getFullScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
