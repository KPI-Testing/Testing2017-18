import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

@RunWith(value = Parameterized.class)
public class Test_for_Google {
    private Page_Google page;
    private String search;
    private String testAim;
    private String testName;
    private static ChromeDriverEx driver;

    public Test_for_Google(String search, String testAim, String testName){
        this.search = search;
        this.testAim = testAim;
        this.testName = testName;
    }

    @BeforeClass
    public static void setDriverPath() throws IOException {
        System.setProperty("webdriver.chrome.driver", "F:\\3 курс\\Testing software\\lab 6\\chromedriver.exe");
    }

    @Before
    public void prepareForTest() throws Exception {
        driver = new ChromeDriverEx();
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        page = new Page_Google(driver, "https://www.google.com.ua/");
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
                {"электромобиль", "Tesla", "Test_#1"},
                {"электромобиль", "Lamborghini", "Test_#2"},
                {"электромобиль", "Bosch", "Test_#3"},
        };
        return Arrays.asList(data);
    }

    @Test
    public void testMethod(){
        page.search(search);
        int pageOfResult = 1;
        while(page.isResult()){
            page.takeScreen(testName,"Page_#"+pageOfResult);
            int index = page.getIndexOf(testAim);
            if (index>=0) {
                System.out.println("Page_#" + pageOfResult);
                Assert.assertTrue(testName.equals("Test_#3"));
                break;
            }
            else if (testName.equals("Test_#1")){
                Assert.fail("No matches on 1st page");
            }
            else if(page.isEnd()){
                System.out.println(testAim+" not found!");
                Assert.assertTrue(testName.equals("Test_#2"));
                break;
            }
            else
                page.goToNextPage();
            ++pageOfResult;
        }
        if(!page.isResult()){
            page.takeScreen(testName,"page"+pageOfResult);
            System.out.println("There is no result!");
            Assert.assertTrue("No search results!", pageOfResult == 1);
        }
    }

    @After
    public void endTest() throws Exception {
        driver.quit();
    }
}
