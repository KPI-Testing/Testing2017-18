package Google;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;

public class Gpage {

    private ChromeDriver driver;

    public Gpage(ChromeDriver driver, String Url1){
        this.driver = driver;
        driver.get(Url1);
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(how = How.ID, using = "lst-ib")
    public WebElement InputField;

    @FindBy(how = How.CLASS_NAME, using = "rc")
    public List<WebElement> ResultsL;

    @FindBy(how = How.ID, using = "pnnext")
    public WebElement NextPage;

    @FindBy(how = How.ID, using = "topstuff")
    public WebElement TopResults;

    @FindBy(how = How.ID, using = "nav")
    public WebElement NavigationBar;




    public Gpage Search(String SearchRequest){
        InputField.clear();
        InputField.sendKeys(SearchRequest);
        InputField.sendKeys(Keys.ENTER);
        return this;
    }

    public Gpage Next(){
        NextPage.click();
        return this;
    }


    public List<String> ResultList(){

        List<String> records = new LinkedList<String>();
        for(WebElement r : ResultsL)
            records.add(r.getText());

        return records;
    }

    public boolean Presence(String rec){

        List<WebElement> d = driver.findElements(By.className("g"));
        boolean f = false;
        for (WebElement r : d) {
            if (f == false){
                String k = r.getText();
                if (k.contains(rec)) {
                    f = true;
                }
            }
        }
        return f;
    }

    public boolean NotLast() {
        return driver.findElements(By.id("pnnext")).size() > 0;
    }

    public Gpage Screenshot(String Test, String Result){

        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        try {
            ImageIO.write(screenshot.getImage(),"PNG",new File("C:\\Users\\vperv\\IdeaProjects\\Websitecheck\\Google\\" + Test + "_" + Result + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }




}
