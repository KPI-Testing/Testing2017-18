package pages;

import extensions.ChromeDriverEx;
import elements.Button;
import elements.Label;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends Page{
    public ItemPage(ChromeDriverEx driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"splash-button\"]")
    @CacheLookup
    public Button buttonBucketItem;

    @FindBy(xpath = "//*[@id=\"content-inner-block\"]/div[2]/div/header/div[1]/ul/li[5]/a/span")
    @CacheLookup
    public Button backToCatalog;

    @FindBy(id = "price_label")
    @CacheLookup
    public Label price;

    @FindBy(xpath = "//*[@class=\"btn-link-i\"][@name=\"topurchases\"]")
    @CacheLookup
    public Button buy;

    @FindBy(xpath = "//*[@id=\"content-inner-block\"]//h1")
    @CacheLookup
    public Label name;

    public int getPrice(){
        String stringValue = price.getText();
        return Integer.parseInt(stringValue);
    }

    public String getName(){
        String stringValue = name.getText();
        stringValue = stringValue.substring(0, stringValue.length()-1);
        return stringValue;
    }
}
