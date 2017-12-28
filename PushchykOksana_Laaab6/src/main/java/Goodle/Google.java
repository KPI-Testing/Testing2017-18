package Goodle;

import com.assertthat.selenium_shutterbug.core.PageSnapshot;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class Google {
    private WebDriver driver;
    public Google(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(name = "q")
    private WebElement search;
    public Google search(String s) {
        search.sendKeys(s);
        search.submit();
        return new Google(driver);
    }
    @FindBy(id = "pnnext")
    private WebElement nBut;
    public Google nextPage() {
        nBut.click();
        return new Google(driver);
    }
    public PageSnapshot getScr() {
        return Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS);
    }
    public boolean notLastResult() {
        return driver.findElements(By.id("pnnext")).size() > 0;
    }
    public boolean cont(String s) {
        List<WebElement> res = driver.findElements(By.className("g"));
        boolean flag = false;
        for (WebElement r : res) {
            if (flag == false){
                String f = r.getText();
                if (f.contains(s)) {
                    flag = true;
                }
            }
        }
        return flag;
    }
}
