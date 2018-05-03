package elements;

import org.openqa.selenium.*;

import java.util.List;

public class Element implements WebElement {
    private WebElement nativeElement;

    public Element(WebElement nativeElement){
        this.nativeElement = nativeElement;
    }

    public void click() {
        nativeElement.click();
    }

    public void submit() {
        nativeElement.submit();
    }

    public void sendKeys(CharSequence... keysToSend) {
        nativeElement.sendKeys(keysToSend);
    }

    public void clear() {
        nativeElement.clear();
    }

    public String getTagName() {
        return nativeElement.getTagName();
    }

    public String getAttribute(String name) {
        return nativeElement.getAttribute(name);
    }

    public boolean isSelected() {
        return nativeElement.isSelected();
    }

    public boolean isEnabled() {
        return nativeElement.isEnabled();
    }

    public String getText() {
        return nativeElement.getText();
    }

    public List<WebElement> findElements(By by) {
        return nativeElement.findElements(by);
    }

    public WebElement findElement(By by) {
        return nativeElement.findElement(by);
    }

    public boolean isDisplayed() {
        return nativeElement.isDisplayed();
    }

    public Point getLocation() {
        return nativeElement.getLocation();
    }

    public Dimension getSize() {
        return nativeElement.getSize();
    }

    public Rectangle getRect() {
        return nativeElement.getRect();
    }

    public String getCssValue(String propertyName) {
        return nativeElement.getCssValue(propertyName);
    }

    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return nativeElement.getScreenshotAs(target);
    }
}
