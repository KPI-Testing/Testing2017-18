package utill;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Methods {

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

}

