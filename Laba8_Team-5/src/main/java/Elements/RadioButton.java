package Elements;

import org.openqa.selenium.WebElement;

public class RadioButton extends Element{
        public RadioButton (WebElement element){
            super(element);
        }

        public void Checked(){
            if(!isSelected()) click();
        }
}

