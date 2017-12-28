import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

public class Page_Rozetka
{
    private ChromeDriverEx driver;
    private static long waitLimit;

    public Page_Rozetka(ChromeDriverEx driver, String baseUrl){
        this.driver = driver;
        driver.get(baseUrl);
        PageFactory.initElements(this.driver, this);
    }


    @FindBy(how = How.ID, using = "price[min]") public WebElement minPrice;
    @FindBy(how = How.ID, using = "price[max]") public WebElement maxPrice;
    @FindBy(how = How.ID, using = "submitprice") public WebElement filterByPrice;
    @FindBy(how = How.XPATH, using = "//*[@id=\"sort_view\"]/a") public WebElement sort;
    @FindBy(how = How.XPATH, using = "//*[@id=\"filter_sortcheap\"]/a") public WebElement sortCheap;
    @FindBy(how = How.XPATH, using = "//body/div[3]") public WebElement progressBar;

    public Page_Rozetka setMinPrice(int price){
        minPrice.clear();
        minPrice.sendKeys(Integer.toString(price));
        return this; }

    public Page_Rozetka submitPriceFilter(){ filterByPrice.sendKeys(Keys.ENTER);return this; }
    public int getMinPrice(){ String stringValue = minPrice.getAttribute("value");return Integer.parseInt(stringValue); }
    public int getMaxPrice(){ String stringValue = maxPrice.getAttribute("value");return Integer.parseInt(stringValue); }

    public List<Integer> getActulSetOfPrices(){
        List<WebElement> prices = driver.findElements(By.className("g-price-uah"));
        List<Integer> intPrices = new LinkedList<Integer>();
        for (WebElement element: prices) {
            String stringPrice = element.getText().replaceAll(" грн", "").replaceAll(" ","");
            intPrices.add(Integer.parseInt(stringPrice));
        }
        return intPrices;
    }

    public Page_Rozetka waitLoading() throws TimeoutException{
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

    public Page_Rozetka applySort(String howToSort) {
        if (howToSort.equals("cheap")){
            sort.click();
            sortCheap.click();
            return this;
        }
        else
            return null;
    }

    public Page_Rozetka setWaitLimit(long value){
        waitLimit = value*1000;
        return this;
    }

    public Page_Rozetka takeScreen() throws Exception {
        File scrFile = driver.getFullScreenshotAs(OutputType.FILE);
        try {Calendar calendar = new GregorianCalendar();
            String s = new SimpleDateFormat("dd_MM_YY").format(calendar.getTime());
            FileUtils.copyFile(scrFile, new File("././././Rozetka_Screenshots/Rozetka__" + s + ".png"));
        }catch (Exception e){
            System.out.println("Oops, something wrong with saving screenshot!");
        }
        return this;
    }
}