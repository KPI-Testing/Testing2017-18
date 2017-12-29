package Rozetka;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RozetkaPage {
    protected WebDriver _driver;

    public RozetkaPage(WebDriver driver) {
        _driver = driver;
        PageFactory.initElements(driver, this);
        WebElement myDynamicElement = (new WebDriverWait(_driver, 1000000)).until(ExpectedConditions.presenceOfElementLocated(By.id("content-inner-block")));

    }

    @FindBy(name = "text")
    private WebElement textField;

    @FindBy(xpath = "//*[@id=\"rz-search\"]/form/span/span/button")
    private WebElement searchButton;

    public RozetkaPage searchItem (String itemName) {

        textField.sendKeys(itemName);
        searchButton.submit();
        return this;
    }


    @FindBy(id="price[min]")
    private WebElement minPrice;

    @FindBy(id="price[max]")
    private WebElement maxPrice;

    @FindBy(id="submitprice")
    private WebElement filterByPrice;

    @FindBy(xpath=".//*[@id='filter_copy_strana-proizvoditelj-tovara-103660_580d747cee3c5_661116']/label/a/span/i[1]")
    private WebElement UkraineManufacturer;


    public RozetkaPage SetMinimumPrice(int price) {
        minPrice.sendKeys(Integer.toString(price));
        return this;
    }
    public RozetkaPage SetMaximumPrice(int price) {
        maxPrice.sendKeys(Integer.toString(price));
        return this;
    }

    public RozetkaPage submitPriceFilter() {
        filterByPrice.sendKeys(Keys.ENTER);
        return this;
    }

    public RozetkaPage SetManufacturer() {
        UkraineManufacturer.click();
        return this;
    }

}
