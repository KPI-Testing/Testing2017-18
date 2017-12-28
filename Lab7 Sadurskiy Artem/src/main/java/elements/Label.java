package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class Label extends Element {
    public Label(WebElement element) {
        super(element);
    }

    public String getLableName(){
        By nestedText = new By.ByClassName("filter-parametrs-i-l-i-default-title");
        return findElement(nestedText).getText() ;
    }

}
