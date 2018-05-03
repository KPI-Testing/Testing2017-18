package Elements;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class TextField extends Element {

    public TextField(WebElement element) {
        super(element);
    }

    public void clear(){
        sendKeys(Keys.CONTROL + "a");
        sendKeys(Keys.DELETE);
    }

    public void setValue(String s){
        clear();
        sendKeys(s);
    }

    public void setCity(String s){
        setValue(s);
        sendKeys(Keys.ARROW_DOWN);
        sendKeys(Keys.ENTER);

    }


}