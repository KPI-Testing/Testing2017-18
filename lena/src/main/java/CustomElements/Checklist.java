package CustomElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Checklist extends Element{

    public Checklist(WebElement element){
        super(element);
    }

    public Checklist select ( String itemToSelect){
        List<WebElement> elems  = findElements(By.tagName("li"));
        for (WebElement elem : elems){
            Checkbox checkbox = new Checkbox(elem);
            if (checkbox.getText() == itemToSelect) {
                checkbox.select();
                break;
            }
        }
        return this;
    }

    public boolean isSelected (String itemToBeSelected){
        List<WebElement> elems  = findElements(By.tagName("li"));
        for (WebElement elem : elems){
            Checkbox checkbox = new Checkbox(elem);
            if (checkbox.getText() == itemToBeSelected) {
                return checkbox.isSelected();

            }
        }
        return false;
    }

}
