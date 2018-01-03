package Custom_elements;

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

    public void set_value(String s){
        clear();
        sendKeys(s);
    }

    public void set_city(String s){
        set_value(s);
        sendKeys(Keys.ARROW_DOWN);
        sendKeys(Keys.ENTER);

    }
}