package utill;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Waiters {


    public static void thredsleep(int time){
        try {
            Thread.sleep(time);
        }
        catch (InterruptedException e){

        }
    }

    public static void waitClickable(final WebDriver driver, final By by, int t1, int t2){

        Wait waiter =  new FluentWait(driver)
        .withTimeout(t1, TimeUnit.MILLISECONDS)
                .pollingEvery(t2, TimeUnit.MILLISECONDS)
                .ignoring(StaleElementReferenceException.class, NoSuchElementException.class);

        waiter.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void waitClickableAndDisplayed(final WebDriver driver, WebElement element, int t1, int t2){

        Wait waiter =  new FluentWait(driver)
                .withTimeout(t1, TimeUnit.MILLISECONDS)
                .pollingEvery(t2, TimeUnit.MILLISECONDS)
                .ignoring(StaleElementReferenceException.class, NoSuchElementException.class);

        waiter.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(element),ExpectedConditions.visibilityOf(element)));
    }

    public static void waitUrlContain(final WebDriver driver, String contains, int t1, int t2){

        Wait waiter =  new FluentWait(driver)
                .withTimeout(t1, TimeUnit.MILLISECONDS)
                .pollingEvery(t2, TimeUnit.MILLISECONDS)
                .ignoring(StaleElementReferenceException.class, NoSuchElementException.class);

        waiter.until(ExpectedConditions.urlContains(contains.toLowerCase()));
    }

    public static void waitExpected(final WebDriver driver, By by, int t1, int t2){

        Wait waiter =  new FluentWait(driver)
                .withTimeout(t1, TimeUnit.MILLISECONDS)
                .pollingEvery(t2, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);

        waiter.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(by),ExpectedConditions.visibilityOfElementLocated(by)));
    }


}
