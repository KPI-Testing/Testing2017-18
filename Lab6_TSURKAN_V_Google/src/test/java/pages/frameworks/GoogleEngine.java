package pages.frameworks;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;


public class GoogleEngine {
    private ChromeDriverEx driver;
    public GoogleEngine(ChromeDriverEx driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(name = "btnK")
    private WebElement SubmitSearch;

    @FindBy(id = "lst-ib")
    private WebElement TextLine;

    @FindBy(id = "pnnext")
    private WebElement NextPage;

    @FindBy(id = "pnprev")
    private WebElement PreviousPage;



    public GoogleEngine Search(String request) {
        System.out.println("Search for \"" + request + "\"");
        SetSearch(request).SearchButtonPress();
        return this;
    }

    public GoogleEngine SetSearch(String request) {
        if (request == null) return this;
        TextLine.sendKeys(request);
        return this;
    }


    public GoogleEngine SearchButtonPress() {
        SubmitSearch.sendKeys(Keys.ENTER);
        return this;
    }

    public GoogleEngine GoToNext() {
        NextPage.sendKeys(Keys.ENTER);
        return this;
    }

    public GoogleEngine GoToPrevious() {
        PreviousPage.sendKeys(Keys.ENTER);
        return this;
    }


    public GoogleEngine PageLinkSearch(String link) throws Exception {
        int pageNumber = 1;


        if (!driver.findElement(By.id("pnnext")).getText().contains("Следующая")) {
            System.out.println("No pages or captcha");
            assert (false);
        }

        boolean notFinded = true;
        do {

            for (int f = 0; f < driver.findElements(By.className("_Rm")).size(); f++) {
                if (notFinded && driver.findElements(By.className("_Rm")).get(f).getText().contains(link)) {
                    System.out.println("Your link \"" + link + "\" on page: " + pageNumber);
                    System.out.println("On first page: " + ((pageNumber == 1) ? "True" : "False"));
                    notFinded = false;

                    Calendar calendar = new GregorianCalendar();
                    String s = new SimpleDateFormat("dd_MM_yyyy_HH_mm_SS").format(calendar.getTime());
                    System.out.println("page_number is " + pageNumber);
                    File file = driver.getFullScreenshotAs(OutputType.FILE);

                    GoogleEngine.get_screenshot( "YES"+link+s + ".",file);

                }
            }

            if (driver.findElements(By.className("navend")).get(1).getText().contains("Следующая")) {
                GoToNext();
                pageNumber++;
            }


        } while (notFinded && driver.findElements(By.className("navend")).get(1).getText().contains("Следующая"));


        if (notFinded) {
            System.out.println("\""+link + "\" was not found");
            for (int i = pageNumber; i>0;i--) {
                Calendar calendar = new GregorianCalendar();
                String s = new SimpleDateFormat("dd_MM_yyyy_HH_mm_SS").format(calendar.getTime());
                File file = driver.getFullScreenshotAs(OutputType.FILE);

                GoogleEngine.get_screenshot("NO" + i + link + s + ".", file);
                if (i!=1) {
                    GoToPrevious();
                }

            }
        }


        return this;
    }




    public static void get_screenshot(String name, File scrFile)throws Exception{
        try {
            FileUtils.copyFile(scrFile, new File(name + "png"));

        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

}
