package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class Waiter {

    public static final int  WAIT_60 = 60;

    public static void waitForElement(WebDriver driver , WebElement element, int maxSeconds ){
        WebDriverWait wait = new WebDriverWait(driver, maxSeconds);
        wait.until(visibilityOf(element));
    }



    public static void waitImplicit (WebDriver driver , int time,  TimeUnit timeUnit){
        driver.manage().timeouts().implicitlyWait(time , timeUnit);
    }
}
