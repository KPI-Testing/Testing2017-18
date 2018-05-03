package elements;

import org.openqa.selenium.WebElement;

public class CheckBox extends Element{

        public CheckBox(WebElement webElement){
            super(webElement);
        }

        public void select(){
            if(!isSelected()) click();
        }
}
