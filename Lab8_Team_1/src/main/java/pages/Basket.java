package pages;

import elements.TextField;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import utils.Waiters;

import java.util.List;

public class Basket extends BasePage{
    public Basket(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".hub-i-link.hub-i-cart-link.sprite-side.whitelink")
    private WebElement openBasket;//open

    @FindBy(css = ".popup-close")
    private WebElement closeBasket;//close

    public WebElement getButtonPlus() {
        return buttonPlus;
    }

    @FindBy(name = "plus")
    private WebElement buttonPlus;//+1

    public WebElement getButtonMinus() {
        return buttonMinus;
    }

    @FindBy(name = "minus")
    private WebElement buttonMinus;//-1

    public TextField getQuanity() {
        return quanity;
    }


    public List<WebElement> getPriceOfTheGoods() {
        return priceOfTheGoods;
    }

    @FindBys(
    @FindBy(className = "cart-uah")
    )
    private List<WebElement> priceOfTheGoods;


    @FindBys(
            @FindBy(css = ".novisited.cart-i-title-link")
    )
    private List<WebElement> titleNames;

    public List<WebElement> getTitleNames() {
        return titleNames;
    }

    public List<WebElement> getSumPrice() {
        return sumPrice;
    }

    @FindBys(
            @FindBy(css = "span[name=sum]")
    )
    private List<WebElement> sumPrice;


    public WebElement getWholePrice() {
        return wholePrice;
    }

    @FindBy(name = "cost")
    private WebElement wholePrice;

    @FindBy(name = "quantity")
    private TextField quanity;

    @FindBys(
            @FindBy(className = "cart-check")
    )
    private List<WebElement> crossButtons;


    public WebElement getDeleteWithoutSaving() {
        return deleteWithoutSaving;
    }

    @FindBy(name = "delete")
    private WebElement deleteWithoutSaving;

    public WebElement getAllPage() {
        return allPage;
    }

    @FindBy(css = "body > div:nth-child(1)")
    private WebElement allPage;

    public List<WebElement> getCrossButtons() {
        return crossButtons;
    }

    public WebElement getOpenBasket() {
        return openBasket;
    }

    public WebElement getCloseBasket() {
        return closeBasket;
    }

    public void plusOne() {
        Waiters.waitClickableAndDisplayed(getDriver(),getButtonPlus(),2);
        buttonPlus.click();
    }

    public void minusOne() {
        Waiters.waitClickableAndDisplayed(getDriver(),getButtonMinus(),4);
        buttonMinus.click();
    }

    public String getvalue()
    {
        return quanity.getAttribute("value");
    }


}
