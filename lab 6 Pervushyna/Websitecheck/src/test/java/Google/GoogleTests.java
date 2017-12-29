package Google;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;


@RunWith(value = Parameterized.class)
public class GoogleTests {
    private String Url = "https://www.google.com.ua/";
    private static ChromeDriver driver;
    private Gpage WebPage;
    private String Search;
    private String Goal;
    private String Name;

    public GoogleTests(String Name, String Goal, String Search){
        this.Search=Search;
        this.Goal=Goal;
        this.Name=Name;
       

    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
                {   "First Test","Sambass","нейрофанк"},
                {  "Second Test","Ghosthack","нейрофанк"},
                {  "Third Test","Gucci gang","нейрофанк"},
        };
        return Arrays.asList(data);
    }
    @BeforeClass
    public static void DriverPath() throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vperv\\IdeaProjects\\Websitecheck\\chromedriver.exe");
    }

    @Before
    public void Preparation() throws Exception {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        WebPage = new Gpage(driver, Url);
    }

    @Test
    public void Test (){

        WebPage.Search(Search);
        int k = 0;
        boolean flag = false;
        while ( !flag && WebPage.NotLast()  ) {
            k++;
            if ( WebPage.Presence(Goal)) {
                flag = true;
            }
            WebPage.Screenshot(Name,"Page"+k);

            WebPage = WebPage.Next();
        }
    }

    @After
    public void endTest() {
        driver.quit();
    }



}
