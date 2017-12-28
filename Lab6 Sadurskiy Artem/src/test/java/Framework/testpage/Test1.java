package Framework.testpage;
import org.junit.Ignore;
import Framework.Pages.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;

public class Test1 {
    private static ChromeDriverEx driver;
    private static String LURL = "https://www.google.com";
    public static String RURL = "https://rozetka.com.ua/hudojestvennaya-literatura/c4326593/";
    @BeforeClass
    public static void Init()throws Exception{
        String exePath = "C:\\chromedriver.exe";
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



    @Test
    public void Test1()throws Exception{
        GoogleHomePage ResultsPage = new GoogleHomePage(driver);
        String word = "Кнопка";
        String word1 = "канцтовари";
        boolean isCorrect1;
        boolean isCorrect2=true;
        int count = 2;

        GoogleSearchPages Res = new GoogleSearchPages(driver);


        driver.get(LURL);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        ResultsPage.SetWord(word).SubmitSearchWord();
        do
        {
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            isCorrect1 = Res.ListPages();
            if(isCorrect1) isCorrect2 = Res.FindWord(word1);
            if (isCorrect2)
            {
                System.out.println("Number of Page - " + count);

                File file = driver.getFullScreenshotAs(OutputType.FILE);
                String path = "D:\\Lab6 Sadurskiy Artem\\Screens\\Test1\\screen";
                Methods.Screenshot(path + ".",file);
            }

            count++;
        } while (isCorrect1 && !isCorrect2);


        assertTrue(isCorrect2);
    }


    @Ignore
    @Test
    public void Test2()throws Exception{
        GoogleHomePage ResultsPage = new GoogleHomePage(driver);
        String word = "хостинг";
        String word1 = "HostPro";
        GoogleSearchPages Res = new GoogleSearchPages(driver);


        driver.get(LURL);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        ResultsPage.SetWord(word).SubmitSearchWord();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        boolean result = Res.FindWord(word1);
        if (result)
        {
            File file = driver.getFullScreenshotAs(OutputType.FILE);
            String path = "D:\\Lab6 Sadurskiy Artem\\Screens\\Test2\\screen";
            Methods.Screenshot(path + ".",file);
            System.out.println("Number of Page - 1");
        }

        assertTrue(result);
    }

    @Ignore
    @Test
    public void Test3() throws Exception{
        GoogleHomePage ResultsPage = new GoogleHomePage(driver);
        String word = "анальгін";
        String word1 = "bayer";
        boolean isCorrect1=true;
        boolean isCorrect2;
        int count = 2;
        GoogleSearchPages Res = new GoogleSearchPages(driver);


        driver.get(LURL);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        ResultsPage.SetWord(word).SubmitSearchWord();
        do
        {
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            isCorrect2 = Res.FindWord(word1);
            if (!isCorrect2)
            {
                File file = driver.getFullScreenshotAs(OutputType.FILE);
                String path = "D:\\Lab6 Sadurskiy Artem\\Screens\\Test3\\screen_";
                Methods.Screenshot(path + (count-1) + ".",file);
                isCorrect1 = Res.ListPages();
            }
            count++;
        } while (isCorrect1 && !isCorrect2);

        assertTrue(!isCorrect2);
    }

    @Ignore
    @Test
    public void Rozetka()throws InterruptedException{
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.get(RURL);
        RozetkaSearchPage ResutPage = new RozetkaSearchPage(driver);
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
        boolean b = (Methods.CheckDiapazon(PricesInt, MinPriceToSet));
        assertTrue(b == true);

    }
}
