package pages.frameworks;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static junit.framework.TestCase.assertTrue;

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
        boolean b = false;
        for (int i = 0; i < massW.length; i ++) {
            if(massW[i].equalsIgnoreCase(Check)){
                b = true;
                break;
            }
        }
        return b;
    }

    public static String Intparser(char input){
        Pattern p = Pattern.compile("\\D");
        String tempS = input + "";
        Matcher m = p.matcher(tempS);
        if(!m.matches()) return tempS;
        else  return "";
    }

    public static int isNumber(String input){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++){
            result.append(Intparser(input.charAt(i)));
        }
        return Integer.parseInt(result.toString());
    }

    public static boolean CheckRange(ArrayList<Integer> Prices, int Min){
        for (int i = 0; i < Prices.size(); i++){
            if(Prices.get(i) < Min){
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
    public static void MakeScreen(ChromeDriverEx driver, boolean key, int PageNum, String directory, String Path) throws Exception {
        if (key) {
            System.out.println("Page: #" + PageNum);
            Calendar calendar = new GregorianCalendar();
            String s = new SimpleDateFormat("dd_MM_yyyy_HH_mm_SS").format(calendar.getTime());
            File file = driver.getFullScreenshotAs(OutputType.FILE);
            Methods.Screenshot(Path + directory + "\\" + s + ".",file);
        }
    }
    public static int CheckPage(boolean find, boolean always, ChromeDriverEx driver, PageFind Then, String target, String Path, String directory, int PageNum, int count) throws Exception {
        ArrayList<String> ListLinks = new ArrayList();
        int currentEll = Then.PageElements(ListLinks, 0);
        if (find==true){
        for (int i = currentEll - 1; i >= 0; i--) {
            if (Methods.Contains(ListLinks.get(i), target)) {
                count ++;
                MakeScreen(driver, count!=0|always, PageNum, directory, Path);
                break;
            }
        }}
        else{
            for (int i = currentEll - 1; i >= 0; i--) {
                if (!Methods.Contains(ListLinks.get(i), target)) {
                    count ++;
                    MakeScreen(driver, count!=0|always, PageNum, directory, Path);
                    break;
                }
            }}
        if (count>0) return 1;
        else return 0;
    }

}

