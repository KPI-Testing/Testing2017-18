package Elements;

import org.openqa.selenium.WebElement;

public class Check_Box extends Element{

    public Check_Box(WebElement check_box){
        super(check_box);
    }

    public Check_Box select(){
        if(!isSelected()) click();
        return this;
    }
}
