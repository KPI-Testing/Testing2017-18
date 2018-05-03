package pages.frameworks;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static junit.framework.TestCase.assertTrue;


public class RozetkaEngine {
    private ChromeDriverEx driver;

    public RozetkaEngine(ChromeDriverEx driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //
    @FindBys({
            @FindBy(xpath = "//div[@class=\"g-price-uah\"]")
    })
    private List<WebElement> ElementsPrice;


    @FindBy(id = "price[min]")
    private WebElement priceMin;


    @FindBy(id = "submitprice")
    private WebElement SubmitPriceButton;

    @FindBy(className = "filter-parametrs-i-tooltip-inner xhr sprite-side")
    private WebElement CountFounded;


    public RozetkaEngine SetMinPrice(Integer request) {
        if (request == null) return this;
        priceMin.sendKeys(String.valueOf(request));
        return this;
    }


    public RozetkaEngine ClickPriceButton() {
        SubmitPriceButton.sendKeys(Keys.ENTER);
        return this;
    }


    public RozetkaEngine FilterCheck(int min) throws Exception {

        SetMinPrice(min).ClickPriceButton();


        for (WebElement aElementsPrice : ElementsPrice) {
            assert (Integer.parseInt(aElementsPrice.getText().replaceAll("[^0-9]", "")) >= min);
        }
        //Thread.sleep(5000);

        return this;
    }


}

