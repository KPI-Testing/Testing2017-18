package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;

public class CheckList extends Element{

    private List<WebElement> checkList;

    public CheckList(WebElement webElement){
        super(webElement);
    }

    public void select(String filter){
        checkList = findElements(By.tagName("li"));
        showAll();
        for (WebElement webElement: checkList){
            if (webElement.getText().contains(filter)){
                CheckBox checkBox = new CheckBox(webElement);
                checkBox.select();
                break;
            }
        }
    }

    public void showAll(){
        if (findElement(By.cssSelector("#filter_parameters_form > div:nth-child(4) > div.pos-fix > a:nth-child(2)")).getText().contains("("))
            findElement(By.xpath("//*[@id=\"filter_parameters_form\"]/div[4]/div[2]/a[1]")).click();
        checkList = findElements(By.tagName("li"));
    }
}
