package pages;

import extensions.ChromeDriverEx;
import elements.Button;
import elements.Label;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class Item extends Page{
    public Item(ChromeDriverEx driver) {
        super(driver);
    }

    @FindBy(id = "price_label")
    @CacheLookup
    public Label price;

    @FindBy(xpath = "//*[@id=\"detail_buy_label\"]/div[3]/div[1]/div/form/span/span/button")
    @CacheLookup
    public Button buy;

    public int getPrice(){
        String stringValue = price.getText();
        return Integer.parseInt(stringValue);
    }
}
