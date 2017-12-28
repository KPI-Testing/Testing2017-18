package Pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RozetkaPage extends Page{

    @FindBy(id = "price[min]")
    private WebElement minPriceField;

    @FindBy(id = "submitprice")
    private WebElement priceButton;

    @FindBy(className = "g-price-uah")
    private List<WebElement> priceList;

    public RozetkaPage(WebDriver driver){
        super(driver);
    }

    public void setMinPrice(Integer min){
        minPriceField.sendKeys(min.toString());
        priceButton.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        List<WebElement> temp = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("g-price-uah")));
    }

    public Integer getMinPrice(){
        return Integer.parseInt(minPriceField.getAttribute("value"));
    }

    public boolean checkMinPrice(Integer min)throws Exception{
        takeScreenShoot("Rozetka_minPrice=" + min);
        for(WebElement priceIterator : priceList){
            if(Integer.parseInt(priceIterator.getText().replaceAll("\\D", "")) < min)
                return false;
        }
        if(getMinPrice() < min)//if there are not items with (min <= item < actualMinPrice) price
            return false;
        return true;
    }
}
