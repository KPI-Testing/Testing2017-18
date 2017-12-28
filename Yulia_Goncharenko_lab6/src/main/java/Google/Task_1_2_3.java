package Google;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RunWith(value = Parameterized.class)
public class Task_1_2_3 {
    private static ChromeDriverEx driver;
    private final static String url = "https://www.google.com.ua";
    private String search;
    private String key;
    private boolean contains;

    public Task_1_2_3(String key, String search, boolean contains) {
        this.key = key;
        this.search = search;
        this.contains = contains;
    }

    private void write_results(String path, int page_number, int res_number, boolean contains){
        try {
            FileWriter writer = new FileWriter(path, true);
                writer.write("We have found your key: " + key+"\n");
                writer.write(String.format("Page number: %d \n ", page_number));
                writer.write(String.format("That was in result number %d \n", res_number));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeClass
    public static void setUp() throws Exception {
        String exePath = "chromedriver";
        System.setProperty("webdriver.chrome.driver", exePath);
        driver = new ChromeDriverEx();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }


    @Test
    public void test_contains() throws Exception {
        driver.get(url);
        int page_number = 1;
        SearchPage result = new SearchPage(driver);
        result.enterSearchData(search);
        boolean flag = false;
        while (!flag){
            List<String> heads = result.getStringHeads();
            for (int i = 0; i < heads.size(); i++) {
                if (heads.get(i).contains(key) == contains) {
                    if (contains){
                        flag = true;
                        write_results("task_1_2_result.txt", page_number,i+1, contains);}
                    result.get_screenshot(String.format("task_%s_%s_%d.png",search, key, page_number));
                    
                }
            }
            result = result.next_page();
            if (result == null){
                flag = true;
                System.out.println("No more results for your request, we haven't found your key: "+ key);
            }

            page_number += 1;
        }
    }

    @AfterClass
    public static void close() {
        driver.quit();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{{"Garne", "свитер", true}, {"Vandastyle", "свитер", true}, {"Colgate", "свитер",false}};
        return Arrays.asList(data);
    }
}
