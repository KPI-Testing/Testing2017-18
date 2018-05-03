package Elements;

import org.openqa.selenium.*;

import java.util.List;

public class Element implements WebElement {

    private WebElement current_element;

    public Element(WebElement native_el){
        this.current_element = native_el;
    }

    public void click() {
        current_element.click();
    }

    public void submit() {
        current_element.submit();
    }

    public void sendKeys(CharSequence... keysToSend) {
        current_element.sendKeys(keysToSend);
    }

    public void clear() {
        current_element.clear();
    }

    public String getTagName() {
        return current_element.getTagName();
    }

    public String getAttribute(String name) {
        return current_element.getAttribute(name);
    }

    public boolean isSelected() {
        return current_element.isSelected();
    }

    public boolean isEnabled() { return current_element.isEnabled(); }

    public String getText() {
        return current_element.getText();
    }

    public List<WebElement> findElements(By by) {
        return current_element.findElements(by);
    }

    public WebElement findElement(By by) {
        return current_element.findElement(by);
    }

    public boolean isDisplayed() {
        return current_element.isDisplayed();
    }

    public Point getLocation() {
        return current_element.getLocation();
    }

    public Dimension getSize() {
        return current_element.getSize();
    }

    public Rectangle getRect() {
        return current_element.getRect();
    }

    public String getCssValue(String prop_name) {
        return current_element.getCssValue(prop_name);
    }

    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException { return current_element.getScreenshotAs(target); }
}
