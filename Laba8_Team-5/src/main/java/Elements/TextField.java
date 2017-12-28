package Elements;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class TextField extends Element{

    public TextField(WebElement element) {
        super(element);
    }

    public void clear(){
        sendKeys(Keys.CONTROL + "a");
        sendKeys(Keys.DELETE);
    }

    public void setValue(String value){
        sendKeys(Keys.CONTROL + "a");
        sendKeys(Keys.BACK_SPACE);
        sendKeys(value);
    }

    public String getValue(){
        if (getText() == null || getText().isEmpty()) return getAttribute("value");
        else return getText();
    }
}
