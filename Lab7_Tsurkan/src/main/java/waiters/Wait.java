package waiters;
import extensions.ChromeDriverEx;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Wait {
    public static final int WAIT_Amount_of_Seconds = 10;

    public static void wait_for_Preloader(ChromeDriverEx driver, String xpath, int maxTimeSeconds){
        WebDriverWait wait = new WebDriverWait(driver, maxTimeSeconds);
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(By.xpath(xpath),"class","disabled")));
    }

    public static void wait_for_Element(ChromeDriverEx driver, String xpath, int maxTimeSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, maxTimeSeconds);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    public static void wait_for_Loading(ChromeDriverEx driver, int time, WebElement progressBar){
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.invisibilityOf(progressBar));
    }

    public static void wait_Implicit(ChromeDriverEx driver, int time, TimeUnit timeUnit) {
        driver.manage().timeouts().implicitlyWait(time, timeUnit);
    }
}
