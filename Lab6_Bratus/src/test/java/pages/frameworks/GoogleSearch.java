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

public class GoogleSearch {
    private ChromeDriverEx driver;
    public GoogleSearch(ChromeDriverEx driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public class PageStart{
        WebDriver driver;
        public PageStart(WebDriver driver){
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }
        @FindBy(css = "#lst-ib")
        private WebElement Google_Start;
        public GoogleSearch SearchStarting(ChromeDriverEx driver, String search){
            GoogleSearch temp = new GoogleSearch(driver);
            Google_Start.sendKeys(search);
            Google_Start.sendKeys(Keys.ENTER);
            return temp;
        }
    }

    @FindBys({ @FindBy(className = "rc") })
    private List<WebElement> T;
    @FindBy(css = "#pnnext")
    private WebElement Next;

    public boolean next_page(){
        boolean b;
        By locator = new By.ByCssSelector("#pnnext");
        if (!GoogleSearch.find(driver, locator)) { b = false; }
        else {
            Next.click();
            b = true;
        }
        return b;
    }

    public static void wait(WebDriver driver, By by, int z1, int z2){
        FluentWait wait = new FluentWait(driver);
        wait.withTimeout(z1, TimeUnit.MILLISECONDS);
        wait.pollingEvery(z2, TimeUnit.MILLISECONDS);
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static boolean contains(String Input, String Check){
        String[] cont = Input.split("[\\P{L}]+");
        for (int i=0; i<cont.length; i ++) { if(cont[i].equalsIgnoreCase(Check)){ return true; } }
        return false;
    }
    public static void screenshot(String name, File scrFile)throws Exception{
        try { FileUtils.copyFile(scrFile, new File(name + "png")); }
        catch (IOException e) { System.out.println(e.getMessage()); }
    }
   public int look_for_page_elements(ArrayList Item){
        int i = 0;
        for (WebElement temp:T){
            Item.add(temp.getText());
            i++;
        }
        return i;
   }

    public static boolean find(WebDriver driver, By by){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        List<WebElement> temp = driver.findElements(by);
        if (temp.size()==0) {
            System.out.println("The End");
            return false;
        }
        else { return true; }
    }

    public int result_check(String URL, String key, String look_for, String path, boolean page_1, boolean screen_all, int start_page) throws Exception{
        driver.get(URL);
        PageStart Now = new PageStart(driver);
        GoogleSearch Then;
        Now.SearchStarting(driver, key);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Calendar calendarDir = new GregorianCalendar();
        String directory = new SimpleDateFormat("dd_MM_yyyy_HH_mm").format(calendarDir.getTime());
        File dir = new File(path + directory);
        dir.mkdir();

        boolean next;
        int total_num = 0;
        int page_num = 1;
        while (page_num < start_page){
            page_num++;
            next = this.next_page();
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        }
        do {
            ArrayList<String> ListLinks = new ArrayList();
            int current_el = this.look_for_page_elements(ListLinks);
            int temp = total_num;
            for (int i=0; i<current_el; i++) {
                if (GoogleSearch.contains(ListLinks.get(i), look_for)) {
                    total_num++;
                    break;
                }
            }
            if ((total_num-temp>0)||(screen_all)) {
                GoogleSearch.wait(driver, new By.ByCssSelector("#resultStats"), 50000, 250);
                Calendar calendar = new GregorianCalendar();
                String s = new SimpleDateFormat("dd_MM_yyyy_HH_mm_SS").format(calendar.getTime());
                System.out.println("page_num is " + page_num);
                File file = driver.getFullScreenshotAs(OutputType.FILE);
                GoogleSearch.screenshot(path + directory + "\\" + s + ".",file);
            }
            if (page_1){ break; }
            next = this.next_page();
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            page_num++;
        }while (next) ;
        return total_num;
    }
}
