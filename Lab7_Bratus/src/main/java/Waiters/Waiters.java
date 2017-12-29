package Waiters;

import Extensions.ChromeDriverEx;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Waiters {

    public static final int Wait_15_seconds = 15;
    public static void Wait_For_Element(ChromeDriverEx driver, String xpath, int Max_Time_Seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Max_Time_Seconds);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }
    public static void Wait_For_Loading(ChromeDriverEx driver, int time, WebElement Progress_Bar) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.invisibilityOf(Progress_Bar));
    }
    public static void Wait_For_Preloader(ChromeDriverEx driver, String xpath, int Max_Time_Seconds){
        WebDriverWait wait = new WebDriverWait(driver, Max_Time_Seconds);
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(By.xpath(xpath),"class","disabled")));
    }
    public static void Wait_Implicit(ChromeDriverEx driver, int time, TimeUnit timeUnit) {
        driver.manage().timeouts().implicitlyWait(time, timeUnit);
    }
}
