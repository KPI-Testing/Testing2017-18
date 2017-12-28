package pages.testpage;
import pages.frameworks.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;

public class Test1 {
    private static ChromeDriverEx driver;
    private static String LURL = "https://www.google.com.ua/";
    public static String RURL = "https://rozetka.com.ua/hudojestvennaya-literatura/c4326593/";
    @BeforeClass
    public static void Init()throws Exception{
        String exePath = "C:\\Users\\Ivan\\Desktop\\Java_Selenium\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("disable-infobars");
        driver = new ChromeDriverEx(options);
    }
    @AfterClass
    public static void Close(){
        driver.quit();
    }


    //@Ignore
    @Test
    public void Rozetka()throws InterruptedException{
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.get(RURL);
        RozetrkaSearch ResutPage = new RozetrkaSearch(driver);
        int MinPriceToSet = 50;
        int MaxPriceToSet = 5000;
        ResutPage.setMinimumPrice(MinPriceToSet);
        ResutPage.setMaximumPrice(MaxPriceToSet).PriceSumit();

        List<String> Prices = new ArrayList();
        List<Integer> PricesInt = new ArrayList();

        ResutPage.Druk(Prices);
        for (int i = 0; i < Prices.size(); i++){
            System.out.println(Prices.get(i));
            PricesInt.add(Methods.isNumber(Prices.get(i)));
            System.out.println(PricesInt.get(i));
        }
        boolean b = (Methods.CheckDiapazon(PricesInt, MinPriceToSet,MaxPriceToSet));
        assertTrue(b == true);

    }

    //@Ignore
    @Test
    public void Test1()throws Exception{
        /*driver.get(LURL);
        PageStart Now = new PageStart(driver);
        PageFind Then;
        String key = "Vano";
        String ToFind = "ivano";
        Then = Now.GoTo(driver, key);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Calendar calendarDir = new GregorianCalendar();
        String directory = new SimpleDateFormat("dd_MM_yyyy_HH_mm").format(calendarDir.getTime());
        String Path = "D:\\Java\\Lab6\\Screens\\Test1\\";
        File dir = new File(Path + directory);
        dir.mkdir();


        boolean isNext;
        int count = 0;
        int PageNum = 2;
        do {
            isNext = Then.NexpPage();
            ArrayList<String> ListLinks = new ArrayList();
            int currentEll = Then.Druk(ListLinks, 0, true);
            int temp = count;
            for (int i = 0; i < currentEll; i++) {
                if (Methods.Contains(ListLinks.get(i), ToFind)) {
                    count++;
                    break;
                }
            }
                if (count - temp > 0) {
                    Methods.Wait(driver, new By.ByCssSelector("#resultStats"), 50000, 250);
                    Calendar calendar = new GregorianCalendar();
                    String s = new SimpleDateFormat("dd_MM_yyyy_HH_mm_SS").format(calendar.getTime());
                    System.out.println("PageNum is " + PageNum);
                    File file = driver.getFullScreenshotAs(OutputType.FILE);
                    Methods.Screenshot(Path + directory + "\\" + s + ".",file);
                }
                PageNum++;

            }while (isNext) ;*/
        String key = "Vano";
        String ToFind = "ivano";
        String Path = "D:\\Java\\Lab6KorolIvan\\Screens\\Test1\\";
        PageFind t1 = new PageFind(driver);
        int count = t1.testSirch(LURL, key, ToFind, Path, false, false, 2);
        assertTrue(count > 0);
    }

    //@Ignore
    @Test
    public void Test2()throws Exception{
        /*driver.get(LURL);
        PageStart Now = new PageStart(driver);
        PageFind Then;
        String key = "Vano";
        String ToFind = "ivano";
        Then = Now.GoTo(driver, key);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Calendar calendarDir = new GregorianCalendar();
        String directory = new SimpleDateFormat("dd_MM_yyyy__mm").format(calendarDir.getTime());
        String Path = "D:\\Java\\Lab6\\Screens\\Test2\\";
        File dir = new File(Path + directory);
        dir.mkdir();

        int count = 0;
        ArrayList<String> ListLinks = new ArrayList();
        int currentEll = Then.Druk(ListLinks, 0, true);
        for (int i = currentEll - 1; i >= 0; i--) {
            if (Methods.Contains(ListLinks.get(i), ToFind)) {
                count ++;
                System.out.println(count);
                Calendar calendar = new GregorianCalendar();
                String s = new SimpleDateFormat("dd_MM_yyyy_HH_mm_SS").format(calendar.getTime());
                File file = driver.getFullScreenshotAs(OutputType.FILE);
                Methods.Screenshot(Path + directory + "\\" + s + ".",file);
                break;
            }
        }*/
        String key = "Vano";
        String ToFind = "ivano";
        String Path = "D:\\Java\\Lab6KorolIvan\\Screens\\Test2\\";
        PageFind t2 = new PageFind(driver);
        int count =t2.testSirch(LURL, key, ToFind, Path, true, false, 1);
        assertTrue(count > 0);
    }

    //@Ignore
    @Test
    public void Test3() throws Exception{
        /*driver.get(LURL);
        PageStart Now = new PageStart(driver);
        PageFind Then;
        String key = "Vano";
        String ToFind = "ivanov";
        Then = Now.GoTo(driver, key);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Calendar calendarDir = new GregorianCalendar();
        String directory = new SimpleDateFormat("dd_MM_yyyy_mm_MM").format(calendarDir.getTime());
        String Path = "D:\\Java\\Lab6\\Screens\\Test3\\";
        File dir = new File(Path + directory);
        dir.mkdir();

        boolean isNext;
        int count = 0;
        int PageNum = 1;
        do {
            ArrayList<String> ListLinks = new ArrayList();
            int currentEll = Then.Druk(ListLinks, 0, true);
            int temp = count;

            for (int i = currentEll - 1; i >= 0; i--) {
                if (!Methods.Contains(ListLinks.get(i), ToFind)) {
                    count ++;
                    Calendar calendar = new GregorianCalendar();
                    String s = new SimpleDateFormat("dd_MM_yyyy_HH_mm_SS").format(calendar.getTime());
                    File file = driver.getFullScreenshotAs(OutputType.FILE);
                    Methods.Screenshot(Path + directory + "\\" + s + ".",file);
                    break;
                }
            }
            isNext = Then.NexpPage();
        }while (isNext) ;
        assertTrue(count > 0);*/
        String key = "Vano";
        String ToFind = "ivanovich";
        String Path = "D:\\Java\\Lab6KorolIvan\\Screens\\Test3\\";
        PageFind t3 = new PageFind(driver);
        int count = t3.testSirch(LURL, key, ToFind, Path, false, true, 1);
        System.out.println(count);
        assertTrue(count == 0);
    }
}
