package extensions;

import elements.Element;
import org.openqa.selenium.WebElement;

public class WrapperFactory {
    static Element createInstance(Class<Element> clazz, WebElement element) {
        try {
            return clazz.getConstructor(WebElement.class).newInstance(element);
        } catch (Exception e) {
            throw new AssertionError("WebElement can't be represented as " + clazz);
        }
    }
}
