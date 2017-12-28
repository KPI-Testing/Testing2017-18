package elements;

import org.openqa.selenium.WebElement;

public class Check_Box extends Element{
    public Check_Box(WebElement checkbox){
        super(checkbox);
    }

    public Check_Box select(){
        if(!isSelected()) click();
        return this;
    }
}
