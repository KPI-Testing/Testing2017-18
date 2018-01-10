package elements;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class TextField extends Element {

    public TextField(WebElement webElement) {
        super(webElement);
    }

    public void setValue(String value){
        sendKeys(Keys.CONTROL + "a");
        sendKeys(Keys.DELETE);
        sendKeys(value);
    }

    public String getValue(){
        return getAttribute("value");
    }
}
