package Google_task_test;

import Google_task.Google;
import com.assertthat.selenium_shutterbug.core.PageSnapshot;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)

public class Google_test {
    static WebDriver driver;
    @Parameterized.Parameter(0)
    public String val1;
    @Parameterized.Parameter(1)
    public String val2;
    @Parameterized.Parameter(2)
    public String N;
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
       Object[][] param = new Object[][] { { "k-pop група exo в україні ", "ok.ru", "1"}, { "k-pop група exo в україні", "youtube", "2"},{"k-pop група exo в україні", "iasa", "3"}};
        return Arrays.asList(param);
    }
    @Before
    public void setUp (){
        System.setProperty("webdriver.chrome.driver", "D:\\Аня\\3-й курс\\тестування\\labs\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.google.com.ua/");
    }
    @Test
    public void Test (){
        Google search = new Google(driver );
        Google result_el =  search.search_el(val1);
        int i = 0;
        boolean flag = false;
       while ( !flag && result_el.Next_evaliable() ) {
            i++; System.out.println(val2);
            if ( result_el.cont_el(val2)) {
                flag = true;
            }
            PageSnapshot scr = result_el.getScreen();
            scr.withName( "Test"  + N + "_Page" + i).save("D:\\Аня\\3-й курс\\тестування\\Lab6_KorniichukA\\Screens");
            result_el = result_el.nextPage();
        }
    }
    @After
    public  void setDown(){
        driver.quit();
    }
}