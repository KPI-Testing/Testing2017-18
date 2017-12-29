package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckList extends Element{
    public CheckList(WebElement checkList) {
        /* must be found by //div[@name="filter_parameters_block"] */
        super(checkList);
    }

    public CheckList selectFromCheckList(String name) {
        openCheckList();
        selectCheckBox(name);
        return this;
    }

    private CheckList openCheckList() {
        if(getAttribute("class").contains("hidden"))
            findElement(By.tagName("span")).click();
        return this;
    }

    private CheckList selectCheckBox(String name) {
        List<WebElement> checkBoxes = findElements(By.tagName("li"));
        for (WebElement element: checkBoxes){
            if (element.getText().contains(name)){
                CheckBox checkBox = new CheckBox(element);
                checkBox.select();
                break;
            }
        }
        return this;
    }
}
