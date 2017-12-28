package elements;

import org.openqa.selenium.WebElement;

public class CheckBox extends Element{
    public CheckBox(WebElement checkbox){
        super(checkbox);
    }

    public CheckBox select(){
        if(!isSelected()) click();
        return this;
    }
}
