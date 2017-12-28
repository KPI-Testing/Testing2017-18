package pages.frameworks;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;


public class PageFind {
    private ChromeDriverEx driver;
    public PageFind(ChromeDriverEx driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBys({
            @FindBy(className = "rc")
    })
    private List<WebElement> T;


    @FindBy(css = "#pnnext")
    private WebElement Next;

    public boolean NexpPage(){
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
   public int Druk(ArrayList Item, int i, boolean b){
        for (WebElement temp:T){
            if(b)Item.add(temp.getText());
            i++;
        }
        return i;
   }

    public WebElement getElement(int i) {
        return T.get(i);
    }
    public  int testSirch(String myURL, String key, String ToFind, String Path, boolean whileMy, boolean allScrean, int PageStart) throws Exception{
        driver.get(myURL);
        PageStart Now = new PageStart(driver);
        PageFind Then;
        //String key = "Vano";
        //String ToFind = "ivano";
        Now.GoTo(driver, key);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Calendar calendarDir = new GregorianCalendar();
        String directory = new SimpleDateFormat("dd_MM_yyyy_HH_mm").format(calendarDir.getTime());
       //String Path = "D:\\Java\\Lab6\\Screens\\Test1\\";
        File dir = new File(Path + directory);
        dir.mkdir();


        boolean isNext;
        int count = 0;
        int PageNum = 1;
        while (PageNum < PageStart){
            PageNum++;
            isNext = this.NexpPage();
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        }
        do {

            ArrayList<String> ListLinks = new ArrayList();
            int currentEll = this.Druk(ListLinks, 0, true);
            int temp = count;
            for (int i = 0; i < currentEll; i++) {
                if (Methods.Contains(ListLinks.get(i), ToFind)) {
                    count++;
                    break;
                }
            }
            if ((count - temp > 0)||(allScrean)) {
                Methods.Wait(driver, new By.ByCssSelector("#resultStats"), 50000, 250);
                Calendar calendar = new GregorianCalendar();
                String s = new SimpleDateFormat("dd_MM_yyyy_HH_mm_SS").format(calendar.getTime());
                System.out.println("PageNum is " + PageNum);
                File file = driver.getFullScreenshotAs(OutputType.FILE);
                Methods.Screenshot(Path + directory + "\\" + s + ".",file);
            }

            isNext = this.NexpPage();
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            PageNum++;

            //isNext = this.NexpPage();
            if (whileMy){
                break;
            }

        }while (isNext) ;
        return count;
    }

}
