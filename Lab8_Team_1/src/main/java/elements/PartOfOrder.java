package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PartOfOrder extends Element {
    public PartOfOrder(WebElement element) {
        super(element);
    }

    public void deletePartOfOrder(WebDriver driver){
        By.ByCssSelector by = new By.ByCssSelector(" div.cart-check-wrap > a");
        WebElement deleteFromOrder = driver.findElement(by);
        deleteFromOrder.click();
    }
}