package elements;

import org.openqa.selenium.*;

import java.util.List;

public class Element implements WebElement {
    private WebElement my_Element;

    public Element(WebElement nativeElement){
        this.my_Element = nativeElement;
    }

    public void click() {
        my_Element.click();
    }

    public void submit() {
        my_Element.submit();
    }

    public void sendKeys(CharSequence... keysToSend) {
        my_Element.sendKeys(keysToSend);
    }

    public void clear() {
        my_Element.clear();
    }

    public String getTagName() {
        return my_Element.getTagName();
    }

    public String getAttribute(String name) {
        return my_Element.getAttribute(name);
    }

    public boolean isSelected() {
        return my_Element.isSelected();
    }

    public boolean isEnabled() {
        return my_Element.isEnabled();
    }

    public String getText() {
        return my_Element.getText();
    }

    public List<WebElement> findElements(By by) {
        return my_Element.findElements(by);
    }

    public WebElement findElement(By by) {
        return my_Element.findElement(by);
    }

    public boolean isDisplayed() {
        return my_Element.isDisplayed();
    }

    public Point getLocation() {
        return my_Element.getLocation();
    }

    public Dimension getSize() {
        return my_Element.getSize();
    }

    public Rectangle getRect() {
        return my_Element.getRect();
    }

    public String getCssValue(String propertyName) {
        return my_Element.getCssValue(propertyName);
    }

    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return my_Element.getScreenshotAs(target);
    }
}
