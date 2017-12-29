package CustomElements;

import org.openqa.selenium.WebElement;

public class Checkbox extends Element {
    public Checkbox(WebElement element){
        super (element);
    }
    public Checkbox select (){
        if (!isSelected()) click();
        return this;
    }
}
