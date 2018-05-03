package Rozetka_task_test;

import Rozetka_task.Rozetka;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Rozetka_test {
    protected WebDriver driver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "D:\\Аня\\3-й курс\\тестування\\labs\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://rozetka.com.ua/ua/hudojestvennaya-literatura/c4326593/razdel-70312=ujasy-274655/");
    }
    @Test
    public void Test() {
        Rozetka price = new Rozetka(driver);
        int pr = 10;
        price.minPrice(pr);
        price.Filter();
        int real_min_pr = price.getMinPrice();
        if (real_min_pr == pr) System.out.println("Min price: "+pr);
       else System.out.println("It's not min price. Min price :"+real_min_pr);
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
    }
    @After
    public  void setDown(){
        driver.findElement(By.cssSelector("#reset_filterprice > a")).isDisplayed();
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("Rozetka_test.png"));
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

        driver.quit();
    }
}

