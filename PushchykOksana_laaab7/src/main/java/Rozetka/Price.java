package Rozetka;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;

public class Price {
    private WebDriver driver;
    public Price (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 25), this);
    }
    public void Waiter() {
        WebElement wwayt = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("footer-mobile-link")));
    }
    @FindBy(xpath = "//*[@id=\"filter_copy_strana-proizvoditelj-tovara-103660_580d747cee3c5_661116\"]")
    private WebElement ua;
    public void UAclick(){
        ua.click();
    }
    @FindBy(xpath = "//*[@id=\"price[min]\"]")
    private WebElement min;
    @FindBy(xpath = "//*[@id=\"price[max]\"]")
    private WebElement max;
    public Price SetMin(String Min) {
        Waiter();
        min.sendKeys(Keys.CONTROL + "a");
        min.sendKeys(Keys.DELETE);
        min.sendKeys(Min);
        return this;
    }
    public Price SetMax(String Max) {
        Waiter();
        max.sendKeys(Keys.CONTROL + "a");
        max.sendKeys(Keys.DELETE);
        max.sendKeys(Max);
        return this;
    }
    @FindBy(xpath = "//*[@id=\"submitprice\"]")
    private WebElement price;
    public Price PriceClick() {
        Waiter();
        price.sendKeys(Keys.ENTER);
        return this;
    }
    @FindBy(xpath = ".//*[@id='catalog_goods_block']/div/div/div[1]/div/div[1]/div/div/div/div/div/form/span/button")
    private List<WebElement> elem;
    public void Buy(int n) {
        elem.get(n).click();
    }
    @FindBy(xpath = ".//*[@id='popup-checkout']")
    private WebElement a;
    public void clik(){
        a.click();
    }
}
