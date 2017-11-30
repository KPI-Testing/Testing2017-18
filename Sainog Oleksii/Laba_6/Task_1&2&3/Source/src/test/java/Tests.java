import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class Tests {
    private static WebDriver driver;
    private final static String start_url = "https://www.google.com.ua";
    private String company;
    private String request;

    private static void search(String request, String company, int start, int end){
    }

    public Tests(String company_, String request_){
        company = company_;
        request = request_;
    }

    @FindBy(id = "pnnext")
    private WebElement NextPageButton;

    @FindBy(css = "#rso > div > div > div")
    private ArrayList<WebElement> paragraphs;

    @BeforeClass
    public static void begin(){
        String exePath = "c:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void Test1(){
        try {
            driver.get(start_url);
        }
        catch (Exception ex){
            System.out.println("erdgf");
        }
    }

    @AfterClass
    public static void end(){
        driver.quit();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        String request1 = "осцилограф";
        String company1 = "vis";

        String request2 = "насяння";
        String company2 = "lenovo";
        Object[][] data = new Object[][]{
                {company1, request1},
                {company2, request2}
        };
        return Arrays.asList(data);
    }
}
