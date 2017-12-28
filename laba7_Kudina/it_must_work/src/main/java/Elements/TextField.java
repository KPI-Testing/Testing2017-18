package Elements;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class TextField extends Element{

        public TextField (WebElement element){

            super(element);
        }

        public void clear(){
            for (int i = 0; i<10; i++){
                sendKeys(Keys.BACK_SPACE);
            }

        }

        public void setValue(String value){
            clear();
            Weiters.Weiters.Wait(1000);
            sendKeys(value);
        }

        public String getValue(){
            if(getText() == null){
                return getAttribute("value");
            }
            else{
                return getText();
            }
        }
    }

