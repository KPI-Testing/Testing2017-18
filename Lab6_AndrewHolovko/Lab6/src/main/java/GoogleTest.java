import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

@RunWith(value = Parameterized.class)
public class GoogleTest {
    private String baseUrl = "https://www.google.com.ua/";
    private static String driverPath = "c:\\chromedriver\\chromedriver.exe ";
    private static ChromeDriverEx driver;
    private GooglePage page;
    private String search;
    private String testAim;
    private String testName;

    public GoogleTest(String search,String testAim, String testName){
        this.search = search;
        this.testAim = testAim;
        this.testName = testName;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
                {"осциллограф", "OWON", "test1"},//on 1st page
                {"осциллограф", "МФТИ", "test2"},//on n-th page
                {"осциллограф", "Apple Inc.", "test3"},//not present in results
        };
        return Arrays.asList(data);
    }

    @BeforeClass
    public static void setDriverPath() throws IOException {
        System.setProperty("webdriver.chrome.driver", driverPath);
    }

    @Before
    public void prepareForTest() throws Exception {
        driver = new ChromeDriverEx();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        page = new GooglePage(driver, baseUrl);
    }

    @Test
    public void testMethod(){
        page.search(search);
        int pageOfResult = 1;
        while(page.isResult()){
            page.takeScreen(testName,"page"+pageOfResult);
            int index = page.getIndexOf(testAim);
            if (index>=0) {
                System.out.println("page " + pageOfResult);
                Assert.assertFalse(testName.equals("test3"));
                break;
            }
            else if(testName.equals("test1")){
                Assert.fail("No matches on 1st page");
            }
            else if(page.isEnd()){
                System.out.println(testAim+" not found!");
                Assert.assertFalse(testName.equals("test2"));
                break;
            }
            else
                page.goToNextPage();
            ++pageOfResult;
        }
        if(!page.isResult()){
            page.takeScreen(testName,"page"+pageOfResult);
            System.out.println("No result!");
            Assert.assertTrue("No search results!", pageOfResult == 1);
        }
    }

    @After
    public void endTest() throws Exception {
        driver.quit();
    }
}
