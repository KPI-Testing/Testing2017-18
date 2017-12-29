package Waiter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
public class Waiter {


    public static final int  WAIT_60 = 60;

    public static void waitForElement(WebDriver driver , WebElement element, int maxSeconds ){
        WebDriverWait wait = new WebDriverWait(driver, maxSeconds);
        wait.until(visibilityOf(element));
    }


    public void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }


    public static void waitImplicit (WebDriver driver , int time,  TimeUnit timeUnit){
        driver.manage().timeouts().implicitlyWait(time , timeUnit);
    }
}
