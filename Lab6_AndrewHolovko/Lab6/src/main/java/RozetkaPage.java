import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class RozetkaPage
{
    private ChromeDriverEx driver;
    private static long waitLimit;//in millis

    public RozetkaPage(ChromeDriverEx driver, String baseUrl){
        this.driver = driver;
        driver.get(baseUrl);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(how = How.ID, using = "price[min]")
    public WebElement minPrice;

    @FindBy(how = How.ID, using = "price[max]")
    public WebElement maxPrice;

    @FindBy(how = How.ID, using = "submitprice")
    public WebElement filterByPrice;

    @FindBy(how = How.XPATH, using = "//*[@id=\"sort_view\"]/a")
    public WebElement sort;

    @FindBy(how = How.XPATH, using = "//*[@id=\"filter_sortcheap\"]/a")
    public WebElement sortCheap;

    @FindBy(how = How.XPATH, using = "//body/div[3]")
    public WebElement progressBar;

    public RozetkaPage setMinPrice(int price){
        minPrice.clear();
        minPrice.sendKeys(Integer.toString(price));
        return this;
    }

    public RozetkaPage submitPriceFilter(){
        filterByPrice.sendKeys(Keys.ENTER);
        return this;
    }

    public int getMinPrice(){
        String stringValue = minPrice.getAttribute("value");
        return Integer.parseInt(stringValue);
    }

    public int getMaxPrice(){
        String stringValue = maxPrice.getAttribute("value");
        return Integer.parseInt(stringValue);
    }

    public List<Integer> getActulSetOfPrices(){
        List<WebElement> prices = driver.findElements(By.className("g-price-uah"));
        List<Integer> intPrices = new LinkedList<Integer>();
        for (WebElement element: prices) {
            String stringPrice = element.getText().replaceAll(" грн", "").replaceAll(" ","");
            intPrices.add(Integer.parseInt(stringPrice));
        }
        return intPrices;
    }

    public RozetkaPage applySort(String howToSort) {
        if (howToSort.equals("cheap")){
            sort.click();
            sortCheap.click();
            return this;
        }
        else
            return null;
    }

    //sets time in seconds to wait until progress bar is hidden
    public RozetkaPage setWaitLimit(long value){
        waitLimit = value*1000;
        return this;
    }

    //waits until progress bar is hidden
    public RozetkaPage waitLoading() throws TimeoutException{
        boolean loading = !progressBar.getAttribute("class").contains("hidden");
        long start = System.currentTimeMillis();
        while(loading){
            loading = !progressBar.getAttribute("class").contains("hidden");
            if (start - System.currentTimeMillis() > waitLimit){
                System.out.println("z-z-z");
                throw new TimeoutException();
            }
        }
        return this;
    }

    public RozetkaPage takeScreen() throws Exception {
        File scrFile = driver.getFullScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("././././Screenshots/Rozetka/" + System.currentTimeMillis() + ".png"));
        } catch (IOException e){
            System.out.println("IOException while saving screenshot!");
        }
        return this;
    }
}