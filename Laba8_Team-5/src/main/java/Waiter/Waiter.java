package Waiter;



import org.junit.rules.Timeout;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.rules.Timeout.*;



public class Waiter {


    public static void waitForClick(final WebDriver driver, WebElement element, int time){
        Wait waiter = new WebDriverWait(driver,time);
        waiter.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(element),ExpectedConditions.visibilityOf(element)));
    }

    public static void waitForClick(final WebDriver driver, By locator, int time){
        Wait waiter = new WebDriverWait(driver,time);
        waiter.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(locator),ExpectedConditions.visibilityOfElementLocated(locator)));
    }

    public static void Wait(int time){
        try{
            Thread.sleep(time);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }

}
