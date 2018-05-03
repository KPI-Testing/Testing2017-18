package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
/*import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;*/
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.assertthat.selenium_shutterbug.core.PageSnapshot;
import pages.GoogleSearchPage;
import pages.GoogleStartPage;
import pages.ScreenShots;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Calendar;

@RunWith(Parameterized.class)
public class GoogleTest {

    static WebDriver driver;
    String screenPath = "D:\\Oleksij\\eclipse-workspace\\Lab6OleksiiZhenchuk\\Screens\\";


    @Parameterized.Parameter(0)
    public String keyword;
    @Parameterized.Parameter(1)
    public String company;
    @Parameterized.Parameter(2)
    public String toFindOn;
    @Parameterized.Parameters
    public static Collection<Object[]> inputdata() {
        Object[][] inputdata = new Object[][] { { "Найкращий супермаркет України", "Мегамаркет", "1"} , { "Найкращий супермаркет України", "Le Silpo", "2"},{"Несвіжі, прострочені продукти та неякісні товари", "Мегамаркет", "3"}};
        return Arrays.asList(inputdata);
    }


    @Before
    public void setUp (){
        String exePath = "D:\\Oleksij\\Downloads\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        driver = new ChromeDriver();
        driver.get("https://www.google.com.ua/");
    }

    /*@Ignore*/
    @Test
    public void FindCompany () throws InterruptedException, IOException {
        GoogleStartPage search = new GoogleStartPage(driver );
        GoogleSearchPage results =  search.search(keyword);
        //searching in Google for the company
        ArrayList <ScreenShots> screens = new ArrayList<ScreenShots>();
        boolean found = false;
        if (results.contains(company)) found = true;
        screens.add (new ScreenShots(results.getPageNumber(), results.getScreenshot()));
        while ( !found && results.isNotLast() && Integer.parseInt(toFindOn)!=2 ) {
           results = results.getNextPage();
           if (results.contains(company)) {
               found = true;
           }
           screens.add (new ScreenShots(results.getPageNumber(), results.getScreenshot()));
        }
        //outputting and processing the results
        int iToFindOn = Integer.parseInt(toFindOn),i=0;
        if (found){
        	if(iToFindOn<3) i = screens.size() - 1;
        	else i = 0;
        	while(i<screens.size()) {
        		ScreenShots pgScr = screens.get(i);
                Integer pagenum  = (Integer) pgScr.getPage();
                PageSnapshot scr = (PageSnapshot) pgScr.getScreen();
                scr.withName( "Test"  + toFindOn + "Page" + Integer.toString(/*i+1*/pagenum)/*+"_"+Integer.toString(Calendar.MONTH)+Integer.toString(Calendar.DAY_OF_MONTH)+"_"+Integer.toString(Calendar.HOUR)+Integer.toString(Calendar.MINUTE)*/).save(screenPath);
                i++;
        	}
        	System.out.println("Searching for \"" + keyword + "\"");
        	if(iToFindOn==3) System.out.print("Oops! ");
            System.out.println("The company name - " + company + " - appears on " + Integer.toString(i) + " screen");
        }else {
        	switch (iToFindOn) {
        	case 1: i = screens.size();
        	case 2: i = screens.size() - 1;
        	case 3: i = 0;
        	}
        	while(i<screens.size()) {
        		ScreenShots pgScr = screens.get(i/*screens.size() - 1*/);
        		Integer pagenum  = (Integer) pgScr.getPage();
                PageSnapshot scr = (PageSnapshot) pgScr.getScreen();
                scr.withName( "Test"  + toFindOn + "Page" + Integer.toString(pagenum)/*+"_"+Integer.toString(Calendar.MONTH)+Integer.toString(Calendar.DAY_OF_MONTH)+"_"+Integer.toString(Calendar.HOUR)+Integer.toString(Calendar.MINUTE)*/).save(screenPath);
                i++;
        	}
        	System.out.println("Searching for \"" + keyword + "\"");
        	if(iToFindOn!=2) System.out.println("The company name - " + company + " - does not appear at any screen, with existing screens from 1 to " + screens.size());
        	else System.out.println("The company name - " + company + " - does not appear at the first screen");
        }
    }

    @After
    public void setDown(){
        driver.quit();
    }
}