package PageObjects;

import Elements.Button;
import Elements.RadioButton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DeliveryPage extends BasePage {

    public DeliveryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "make-order")
    private Button makeOrder;

    @FindBy(css = "[class = \"check-method-subl-i clearfix\"] label")
    private List<RadioButton> Delivery;

    @FindBy(css = ".check-payment-l > li> label")
    private List<RadioButton> Payment;

    public List<RadioButton> getDelivery() {
        return Delivery;
    }

    public List<RadioButton> getPayment() {
        return Payment;
    }

    public Button getMakeOrder() {
        return makeOrder;
    }
}
