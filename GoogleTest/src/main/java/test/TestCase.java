package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.assertthat.selenium_shutterbug.core.PageSnapshot;
import pages.GoogleResultsPage;
import pages.GoogleSearchPage;
import pages.Pair;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestCase {

    static WebDriver driver;
    String screenPath = "/home/lena/SCHOOL/Testing/tests/helpforgit/GoogleTest/";


    @Parameterized.Parameter(0)
    public String product;
    @Parameterized.Parameter(1)
    public String company;
    @Parameterized.Parameter(2)
    public String taskNo;
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] { { "зубна паста з кальцієм і фтором від  безкоштовно  ", "COLGATE", "1"} , { "зубна паста з кальцієм і фтором від  безкоштовно  ", "Прополіс", "2"},{"зубна паста з кальцієм і фтором від  Colgate безкоштовно  ", "Privat24", "3"}};
        return Arrays.asList(data);
    }


    @Before
    public void setUp (){
        String exePath = "/home/lena/chromedriver/chromedriver";
        System.setProperty("webdriver.chrome.driver", exePath);
        driver = new ChromeDriver();
        driver.get("https://www.google.com.ua/");
    }

    @Test
    public void FindCompany () throws InterruptedException, IOException {
        GoogleSearchPage search = new GoogleSearchPage(driver );
        GoogleResultsPage results =  search.search(product);

        //searching for a company
        ArrayList <Pair> screens = new ArrayList<Pair>();
        boolean found = false;
        if ( results.contains(company)) {
            found = true;
        }
        screens.add ( new Pair(results.getPageNumber(), results.getScreenshot()));
        while ( !found && results.isNotLast() ) {
           results = results.getNextPage();
           if ( results.contains(company)) {
               found = true;
           }
           screens.add ( new Pair(results.getPageNumber(), results.getScreenshot()));
        }


        //printing results
        if (found){
            Pair pgScr = screens.get( screens.size() - 1);
            String page  = Integer.toString( (Integer) pgScr.getPage() ) ;
            PageSnapshot scr = (PageSnapshot) pgScr.getScreen();
            scr.withName( "Test"  +taskNo + "Page" + page  ).save(screenPath);
            System.out.println("Your company name appears on " + page + " Page");
        }else {
            for (Pair pgScr : screens){
                String page  = Integer.toString( (Integer) pgScr.getPage() ) ;
                PageSnapshot scr = (PageSnapshot) pgScr.getScreen();
                scr.withName( "Test"  +taskNo + "Page" + page  ).save(screenPath);
            }
           System.out.println( "You should think about your PR company");
           System.out.println( "Total number of pages without your company brand  : " + screens.get( screens.size() - 1).getPage() ) ;
        }
    }

    @After
    public  void tearDown(){
        driver.quit();
    }
}
