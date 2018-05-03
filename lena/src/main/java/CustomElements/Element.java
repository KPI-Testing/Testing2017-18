package CustomElements;

import org.openqa.selenium.*;

import java.util.List;

public class Element implements WebElement {
    WebElement element ;
    public Element(WebElement element ){
        this.element = element;
    }

    public void click(){
        this.element.click();
    }

    public void submit(){
        this.element.submit();
    }

    public void sendKeys(java.lang.CharSequence... keysToSend){
        this.element.sendKeys(keysToSend);
    }

    public void clear(){
        this.element.clear();
    }

    public String getTagName() {
        return element.getTagName();
    }

    public String getAttribute(java.lang.String name) {
        return element.getAttribute(name);
    }

    public boolean isSelected() {
        return element.isSelected();
    }

    public boolean isEnabled() {
        return element.isEnabled();
    }

    public String getText() {
        return element.getText();
    }

    public List<WebElement> findElements(By by) {
        return element.findElements(by);
    }

    public WebElement findElement(By by) {
        return element.findElement(by);
    }

    public boolean isDisplayed() {
        return element.isDisplayed();
    }

    public Point getLocation() {
        return element.getLocation();
    }

    public Dimension getSize() {
        return element.getSize();
    }

    public Rectangle getRect() {
        return element.getRect();
    }

    public String getCssValue(java.lang.String  propertyName) {
        return element.getCssValue(propertyName);
    }

    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return element.getScreenshotAs(outputType);
    }

}
