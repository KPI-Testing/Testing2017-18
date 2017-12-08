package pages.testpage;
import org.junit.Ignore;
import org.openqa.selenium.*;
import pages.frameworks.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;
import static pages.frameworks.Methods.CheckPage;
import static pages.frameworks.Methods.MakeScreen;

public class Test1 {
    private static ChromeDriverEx driver;
    private static String Google_Link = "https://www.google.com.ua/";
    public static String Rozetka_Link = "https://rozetka.com.ua/ruchki/c2560757/";

    @BeforeClass
    public static void Init() throws Exception {
        String driverPath = "C:\\Users\\Trokhymovych\\IdeaProjects\\lib\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("disable-infobars");
        driver = new ChromeDriverEx(options);
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void Close() {
        driver.quit();
    }


    //@Ignore
    @Test
    public void Rozetka() throws InterruptedException {
        //launching page
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.get(Rozetka_Link);
        Rozetka ResultPage = new Rozetka(driver);
        //setting starting parametrs
        int MinPriceToSet = 200;
        ResultPage.setMinimumPrice(MinPriceToSet).PriceSubmit();
        ArrayList<String> PricesF = new ArrayList();
        ArrayList<Integer> PricesInt = new ArrayList();
        ResultPage.Convert(PricesF);
        //extracting prices as int
        for (int i = 0; i < PricesF.size(); i++) {
            PricesInt.add(Methods.isNumber(PricesF.get(i)));
            System.out.println(PricesInt.get(i));
        }
        //testing itself
        boolean b = (Methods.CheckRange(PricesInt, MinPriceToSet));
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        assertTrue(b == true);
    }


    //@Ignore
    @Test
    public void Test1() throws Exception {
        //google the word_to_googleword
        driver.get(Google_Link);
        PageStart Now = new PageStart(driver);
        PageFind Then;
        String word_to_google = "Кнопка";
        String word_to_find = "канцтовари";
        Then = Now.Google_request(driver, word_to_google);
        Methods.Wait(driver, new By.ByCssSelector("#resultStats"), 10000, 250);
        //For RobotChecker
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        //creating directory for screens
        Calendar calendarDir = new GregorianCalendar();
        String directory = new SimpleDateFormat("dd_MM_yyyy_HH_mm").format(calendarDir.getTime());
        String Path = "C:\\Users\\Trokhymovych\\IdeaProjects\\Lab6\\Test1\\";
        File dir = new File(Path + directory);
        dir.mkdir();

        //Looking from second page
        boolean Next;
        int count = 0;
        int NumPage = 1;
        do {
            // pass to second page
            Next = Then.NextPage();
            NumPage++;
            count+=CheckPage(true, false, driver, Then, word_to_find, Path, directory, NumPage, count);
        } while (Next);
        assertTrue(count > 0);
    }

    //@Ignore
    @Test
    public void Test2() throws Exception {
        // open google starting page
        driver.get(Google_Link);
        PageStart Now = new PageStart(driver);
        PageFind Then;
        String word_to_google = "Кнопка рівне";
        String word_to_find = "Канцтовари";
        //google the word_to_googleword and creating class element of the page
        Then = Now.Google_request(driver, word_to_google);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        // creating path for saving results
        Calendar calendarDir = new GregorianCalendar();
        String directory = new SimpleDateFormat("dd_MM_yyyy_HH_mm").format(calendarDir.getTime());
        String Path = "C:\\Users\\Trokhymovych\\IdeaProjects\\Lab6\\Test2\\";
        File dir = new File(Path + directory);
        dir.mkdir();

        int count = 0;
        int NumPage = 1;
        count+=CheckPage(true, true, driver, Then, word_to_find, Path, directory, NumPage, count);
        assertTrue(count > 0);
    }

    //@Ignore
    @Test
    public void Test3() throws Exception {
        //open google starting page
        driver.get(Google_Link);
        PageStart Now = new PageStart(driver);
        PageFind Then;
        String word_to_google = "Кнопка рівне";
        String word_to_find = "брак";
        //google requested word
        Then = Now.Google_request(driver, word_to_google);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Calendar calendarDir = new GregorianCalendar();
        String directory = new SimpleDateFormat("dd_MM_yyyy_HH_mm").format(calendarDir.getTime());
        String Path = "C:\\Users\\Trokhymovych\\IdeaProjects\\Lab6\\Test3\\";
        File dir = new File(Path + directory);
        dir.mkdir();

        boolean Next;
        int count = 0;
        int NumPage = 0;
        do {
            NumPage++;
            count+=CheckPage(false, true, driver, Then, word_to_find, Path, directory, NumPage, count);
            Next = Then.NextPage();
        } while (Next);
        assertTrue(count > 0);
    }
}
