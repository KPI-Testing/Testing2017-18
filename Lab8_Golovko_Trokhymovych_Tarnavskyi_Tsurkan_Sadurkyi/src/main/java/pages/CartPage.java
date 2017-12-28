package pages;

import elements.TextField;
import extensions.ChromeDriverEx;
import elements.Button;
import elements.Label;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class CartPage extends Page{
    public CartPage(ChromeDriverEx driver) {
        super(driver);
    }

    @FindBy(id = "popup-checkout")
    public Button validate;

    @FindBy(name = "cost")
    public Label price;//total sum

//    extendable part starts here

    @FindBy(xpath = "//*[@id=\"cart-popup\"]/div[2]/div[1]/div[3]/span/span/a")
    public Button continuePurchaseButton;

    @FindBy(xpath = "//*[@id=\"cart-popup\"]//div[@class=\"cart-i-title\"]/a[@name=\"goods-link\"]")
    public List<Label> names;

    @FindBy(xpath = "//div[@class=\"cart-i-price\"]/span[@class=\"cart-uah\"]")
    public List<Label> prices;

    @FindBy(name = "quantity")
    public List<TextField> quantity;

    @FindBy(className = "cart-amount-plus")
    public List<Button> plusButton;

    @FindBy(className = "cart-amount-minus")
    public List<Button> minusButton;

    @FindBy(xpath = "//*[@class=\"cart-uah cart-sum-uah\"]/span[@name=\"sum\"]")
    public List<Label> sums;//sums for each item

    @FindBys(
            @FindBy(className = "cart-check")
    )
    private List<WebElement> crossButtons;

    @FindBys(
            @FindBy(css = ".novisited.cart-i-title-link")
    )
    private List<WebElement> titleNames;

    @FindBys(
            @FindBy(name = "delete")
    )
    private List<WebElement> deleteWithoutSaving;

    public List<WebElement> getCrossButtons() {
        return crossButtons;
    }

    public List<WebElement> getTitleNames() {
        return titleNames;
    }
    public List<WebElement> getDeleteWithoutSaving() {
        return deleteWithoutSaving;
    }

    public String getName(int index){
        return names.get(index).getText();
    }

    public int getPriceOf(int index){
        String stringValue = prices.get(index).getText();
        stringValue = stringValue.substring(0,stringValue.length()-4);
        stringValue = stringValue.replaceAll(" ","");
        return Integer.parseInt(stringValue);
    }

    public int getQuantity(int index){
        String stringValue = quantity.get(index).getValue();
        return Integer.parseInt(stringValue);
    }

    public int getSum(int index){
        String stringValue = sums.get(index).getText();
        stringValue = stringValue.replaceAll(" ","");
        return Integer.parseInt(stringValue);
    }

    public int getNumberOfPositions(){
        System.out.println("Prices:");
        for (Label label: prices) {
            System.out.println(label+"\n"+label.getText());
        }
        return prices.size();
    }

//    extendable part ends here

    public int getPrice(){
        String stringValue = price.getText();
        stringValue = stringValue.replaceAll(" ","");
        return Integer.parseInt(stringValue);
    }
}
