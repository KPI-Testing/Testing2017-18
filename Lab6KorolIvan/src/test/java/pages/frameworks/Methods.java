package pages.frameworks;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Methods {

    public static boolean Find(WebDriver driver, By by){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        List<WebElement> temp = driver.findElements(by);
        if (temp.size()==0) {
            System.out.println("The end");
            return false;
        }
        else {
            return true;
        }
    }
    public static void Wait(WebDriver driver, By by, int T1, int T2){
        FluentWait wait = new FluentWait(driver);

        wait.withTimeout(T1, TimeUnit.MILLISECONDS);

        wait.pollingEvery(T2, TimeUnit.MILLISECONDS);

        wait.ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.visibilityOfElementLocated(by));

    }

    public static boolean Contains(String Input, String Check){
        String[] massW = Input.split("[\\P{L}]+");
        for (int i = 0; i < massW.length; i ++) {
            if(massW[i].equalsIgnoreCase(Check)){
                return true;
            }
        }
        return false;
    }

    public static String isNum(char input){
        Pattern p = Pattern.compile("\\D");
        String tempS = input + "";
        Matcher m = p.matcher(tempS);
        if(!m.matches()) return tempS;
        else  return "";
    }

    public static int isNumber(String input){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++){
            result.append(isNum(input.charAt(i)));
        }
        return Integer.parseInt(result.toString());
    }

    public static boolean CheckDiapazon(List<Integer> Prices, int Min, int Max){
        for (int i = 0; i < Prices.size(); i++){
            if(Prices.get(i) < Min || Prices.get(i) > Max){
                return false;
            }
        }
        return true;
    }
    public static void Screenshot(String name, File scrFile)throws Exception{
        try {
            FileUtils.copyFile(scrFile, new File(name + "png"));
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

}

