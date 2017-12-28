package Rozetka;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class PurchaseContext {
    protected WebDriver _driver;

    public PurchaseContext(WebDriver driver) {
        _driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"catalog_goods_block\"]/div/div[1]/div[1]/div/div/div/div[7]/div/div/div/form/span/button")
    private WebElement addToShoppingBagButtom;

    @FindBy(id="popup-checkout")
    private WebElement createOrderButton;

    @FindBy(xpath=".//*[@id='step_contacts']/div/div[1]/div[2]/div/span/button")
    private WebElement goNext;

    @FindBy(id="make-order")
    private WebElement confirmOrderButton;

    public PurchaseContext fillContactInfo() {
        WebDriverWait wait = new WebDriverWait(_driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(addToShoppingBagButtom)).submit();
        wait.until(ExpectedConditions.elementToBeClickable(createOrderButton)).submit();

        _driver.findElement(By.id("reciever_name")).sendKeys("John Smith");
        _driver.findElement(By.id("reciever_phone")).sendKeys("+380676123456");
        _driver.findElement(By.id("reciever_email")).sendKeys("john007@gmail.com");

        wait.until(ExpectedConditions.visibilityOf(goNext));
        if (goNext.isEnabled()& goNext.isDisplayed()){
            goNext.submit();
        }
        wait.until(ExpectedConditions.visibilityOf(confirmOrderButton));
        return this;
    }

    public boolean purchaseItem() {
        //making screenshot
        _driver.manage().window().maximize();
        File scrFile = ((TakesScreenshot)_driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("confirmOrder.png"));
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        if (confirmOrderButton.isEnabled())
            System.out.print("YYYYESS!");
        return confirmOrderButton.isEnabled();
    }
}
