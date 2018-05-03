package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Check_List extends Element {
    public Check_List(WebElement checkList) {
        /* must be found by //div[@name="filter_parameters_block"] */
        super(checkList);
    }

    public Check_List selectFromCheckList(String name) {
        openCheckList();
        selectCheckBox(name);
        return this;
    }

    private Check_List openCheckList() {
        if(getAttribute("class").contains("hidden"))
            findElement(By.tagName("span")).click();
        return this;
    }

    private Check_List selectCheckBox(String name) {
        List<WebElement> checkBoxes = findElements(By.tagName("li"));
        for (WebElement element: checkBoxes){
            if (element.getText().contains(name)){
                Check_Box checkBox = new Check_Box(element);
                checkBox.select();
                break;
            }
        }
        return this;
    }
}
