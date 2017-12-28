package waiters;
import elements.Label;
import extensions.ChromeDriverEx;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Waiters {
    public static final int WAIT_10 = 10;

    public static void waitForPreloader(ChromeDriverEx driver, String xpath, int maxTimeSeconds){
        WebDriverWait wait = new WebDriverWait(driver, maxTimeSeconds);
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(By.xpath(xpath),"class","disabled")));
    }

    public static void waitForElement(ChromeDriverEx driver, String xpath, int maxTimeSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, maxTimeSeconds);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    public static void waitForDataSending(ChromeDriverEx driver, int maxTimeSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, maxTimeSeconds);
        wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@alt=\"Отправка данных\"]"))));
    }

    public static void waitForElementInNotPresent(ChromeDriverEx driver, String xpath, int maxTimeSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, maxTimeSeconds);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
    }

    public static void waiterForCart(ChromeDriverEx driver, int maxTimeSeconds){
        WebDriverWait wait = new WebDriverWait(driver, maxTimeSeconds);
        try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
        wait.until(ExpectedConditions.attributeToBe(By.xpath("//*[@id=\"cart_payment_info\"]/div[1]"), "class", "cart-total-sum"));
    }

    public static void waitForLoading(ChromeDriverEx driver, int time, WebElement progressBar){
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.invisibilityOf(progressBar));
    }

    public static void waitImplicit(ChromeDriverEx driver, int time, TimeUnit timeUnit) {
        driver.manage().timeouts().implicitlyWait(time, timeUnit);
    }
}
