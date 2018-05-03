package Elements;

import org.openqa.selenium.WebElement;

public class Button extends Element {

    public Button(WebElement native_el) {
        super(native_el);
    }

    @Override
    public String getText() {
        String result = super.getText();
        if (result==null || result.isEmpty())
            result = getAttribute("value");
        return (result==null)?null:result.trim();
    }
}
