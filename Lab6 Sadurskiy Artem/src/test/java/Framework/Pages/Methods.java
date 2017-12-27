package Framework.Pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.util.List;
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

    public static boolean CheckDiapazon(List<Integer> Prices, int Min){
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

}

