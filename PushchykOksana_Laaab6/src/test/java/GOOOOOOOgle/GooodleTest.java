package GOOOOOOOgle;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.assertthat.selenium_shutterbug.core.PageSnapshot;
import Goodle.Google;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)

public class GooodleTest {
    static WebDriver driver;
    String Path = "D:\\Тестування\\laaab6\\GoogleScreens";
    @Parameterized.Parameter(0)
    public String prod;
    @Parameterized.Parameter(1)
    public String comp;
    @Parameterized.Parameter(2)
    public String Num;
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] info = new Object[][] { { "Мой брат пингвин)) ", "Pikabu", "1"}, { "Мой брат пингвин))", "Mail.Ru", "2"},{"Мой брат пингвин))", "Privat24", "3"}};
        return Arrays.asList(info);
    }
    @Before
    public void setUp (){
        System.setProperty("webdriver.chrome.driver", "D:\\Завантаження\\111111111\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.google.com.ua/");
    }
    @Test
    public void Test1 (){
        Google search = new Google(driver );
        Google res =  search.search(prod);
        int k = 0;
        boolean flag = false;
        while ( !flag && res.notLastResult() ) {
            k++;
            if ( res.cont(comp)) {
                flag = true;
            }
            PageSnapshot scr = res.getScr();
            scr.withName( "Test"  + Num + "Page" + k).save(Path);
            res = res.nextPage();
        }
    }
    @After
    public  void setDown(){
        driver.quit();
    }
}
