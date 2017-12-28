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


public class All_for_Google {
    private ChromeDriverEx driver;
    public All_for_Google(ChromeDriverEx driver){
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
        private WebElement Google_start_field;

        public All_for_Google start_search(ChromeDriverEx driver, String search){
            All_for_Google temp = new All_for_Google(driver);
            Google_start_field.sendKeys(search);
            Google_start_field.sendKeys(Keys.ENTER);
            return temp;
        }
    }

    @FindBys({
            @FindBy(className = "rc")
    })
    private List<WebElement> T;


    @FindBy(css = "#pnnext")
    private WebElement Next;

    public boolean next_page(){
        boolean b;
        By locator = new By.ByCssSelector("#pnnext");
        if (!All_for_Google.find(driver, locator)) {
            b = false;
        }
        else {
            Next.click();
            b = true;
        }
        return b;

    }
   public int page_elements(ArrayList Item){
        int i =0;
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
            System.out.println("The end");
            return false;
        }
        else {
            return true;
        }
    }

    public  int magic_check(String URL, String key, String what_find, String path, boolean only_first_page, boolean screen_all_pages, int start_page) throws Exception{
        driver.get(URL);
        PageStart Now = new PageStart(driver);
        All_for_Google Then;
        Now.start_search(driver, key);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Calendar calendarDir = new GregorianCalendar();

        String directory = new SimpleDateFormat("dd_MM_yyyy_HH_mm").format(calendarDir.getTime());
        File dir = new File(path + directory);
        dir.mkdir();


        boolean next;
        int count = 0;
        int page_number = 1;
        while (page_number < start_page){
            page_number++;
            next = this.next_page();
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        }
        do {

            ArrayList<String> ListLinks = new ArrayList();
            int current_item = this.page_elements(ListLinks);
            int temp = count;
            for (int i = 0; i < current_item; i++) {
                if (All_for_Google.contains(ListLinks.get(i), what_find)) {
                    count++;
                    break;
                }
            }
            if ((count - temp > 0)||(screen_all_pages)) {
                All_for_Google.wait(driver, new By.ByCssSelector("#resultStats"), 50000, 250);
                Calendar calendar = new GregorianCalendar();
                String s = new SimpleDateFormat("dd_MM_yyyy_HH_mm_SS").format(calendar.getTime());
                System.out.println("page_number is " + page_number);
                File file = driver.getFullScreenshotAs(OutputType.FILE);
                All_for_Google.get_screenshot(path + directory + "\\" + s + ".",file);
            }
            if (only_first_page){
                break;
            }

            next = this.next_page();
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            page_number++;
            
        }while (next) ;
        return count;
    }

    public static void wait(WebDriver driver, By by, int T1, int T2){
        FluentWait wait = new FluentWait(driver);
        wait.withTimeout(T1, TimeUnit.MILLISECONDS);
        wait.pollingEvery(T2, TimeUnit.MILLISECONDS);
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static boolean contains(String Input, String Check){
        String[] massW = Input.split("[\\P{L}]+");
        for (int i = 0; i < massW.length; i ++) {
            if(massW[i].equalsIgnoreCase(Check)){
                return true;
            }
        }
        return false;
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
