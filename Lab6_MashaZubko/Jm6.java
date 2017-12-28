import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Jm6 {

    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Masha1\\Downloads\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void First_task_search() throws IOException, InterruptedException {
        driver.get("https://www.google.com.ua");
        WebElement loginField = driver.findElement(By.id("lst-ib"));
        loginField.sendKeys("интернет магазин");
        WebElement findclick = driver.findElement(By.name("btnK"));
        findclick.click();
        WebElement skip_first_page = driver.findElement(By.linkText("Следующая"));
        skip_first_page.click();

        int page = 2;
        int break_count = 0;
        try {
            while (driver.findElement(By.linkText("Следующая")).isDisplayed() && break_count==0) {

                java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
                for (int i = 0; i < links.size(); i++) {
                    if (links.get(i).getText().toLowerCase().contains("glem")) {
                        JavascriptExecutor je = (JavascriptExecutor) driver;
                        WebElement element = driver.findElement(By.partialLinkText("Glem"));
                        je.executeScript("arguments[0].scrollIntoView(true);", element);
                        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                        FileUtils.copyFile(screenshot, new File("task1_screen_page_number_" + page + ".png"));
                        break_count += 1;
                        break;
                    }
                }
                if(break_count==0) {
                    WebElement next = driver.findElement(By.linkText("Следующая"));
                    next.click();
                    page += 1;
                }
            }
        }catch (NoSuchElementException e) {
            System.out.println("Element not found.");
        }
    }

    @Test
    public void Second_task_search() throws IOException {
        driver.get("https://www.google.com.ua");
        WebElement loginField = driver.findElement(By.id("lst-ib"));
        loginField.sendKeys("интернет магазин");
        WebElement findclick = driver.findElement(By.name("btnK"));
        int page = 0;
        findclick.click();
        page += 1;
        java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
        for (int i = 0; i < links.size(); i++) {
            if (links.get(i).getText().toLowerCase().contains("rozetka")) {
                JavascriptExecutor je = (JavascriptExecutor) driver;
                WebElement element = driver.findElement(By.partialLinkText("Rozetka"));
                je.executeScript("arguments[0].scrollIntoView(true);", element);
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(screenshot, new File("task2_screen_page_number_" + page + ".png"));
                break;
            }
        }
        driver.quit();
    }

    @Test
    public void Third_task_search() throws IOException {
        driver.get("https://www.google.com.ua");
        WebElement loginField = driver.findElement(By.id("lst-ib"));
        loginField.sendKeys("анальгин");
        WebElement findclick = driver.findElement(By.name("btnK"));
        findclick.click();

        int page = 1;
        int found_associates = 0;

        try {
            while (driver.findElement(By.linkText("Следующая")).isDisplayed()) {

                java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
                for (int i = 0; i < links.size(); i++) {
                    if (links.get(i).getText().toLowerCase().contains("bayer")) {
                        found_associates+=1;
                        System.out.println("Your firm associates with input word.");
                    }
                }
                File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(scrFile, new File("C:\\6Lab_Screenshots_task3\\task3_screen_page_number_" + page + ".png"));
                WebElement next = driver.findElement(By.linkText("Следующая"));
                next.click();
                page += 1;
            }
        } catch (NoSuchElementException e) {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("C:\\6Lab_Screenshots_task3\\task3_screen_page_number_" + page + ".png"));
            System.out.println("Pages is over.");
        }
        System.out.println("Found "+ found_associates + " associations.");

    }

    @Test
    public void Rozetka_task() throws IOException {
        String price = "200";
        driver.get("https://rozetka.com.ua/search/?text=%D1%82%D1%8E%D0%BB%D0%B5%D0%BD%D0%B8");
        WebElement min_price = driver.findElement(By.id("price[min]"));
        min_price.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE + price);
        WebElement clicl_sort = driver.findElement(By.id("submitprice"));
        clicl_sort.click();
        WebElement max_price = driver.findElement(By.id("price[max]"));

        ArrayList<String> prices_convert = new ArrayList<String>();
        java.util.List<WebElement> prices = driver.findElements(By.name("price"));
        for (int i = 0; i < prices.size()-1; i++) {
            prices_convert.add(prices.get(i).getText());
        }
        ArrayList<String> prices_convert_int = new ArrayList<String>();

        for(int i=0; i<prices_convert.size();i++){
            prices_convert_int.add(prices_convert.get(i).substring(0,prices_convert.get(i).length()-4));
        }

        for(int i=0; i<prices_convert_int.size();i++){
            if(Integer.valueOf(prices_convert_int.get(i))<Integer.valueOf(price)|| Integer.valueOf(prices_convert_int.get(i))>Integer.valueOf(max_price.getAttribute("value"))){
                System.out.println("Price is out of range.");
            }
        }
        driver.quit();
    }
}