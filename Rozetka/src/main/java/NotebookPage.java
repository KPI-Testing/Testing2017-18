import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.lang.ref.SoftReference;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NotebookPage {

    private WebDriver driver ;

    @FindBy(id = "price[min]")
    private WebElement filterMinFileld;

    @FindBy(id = "submitprice")
    private WebElement filterSubmit;

    @FindBy(className = "g-i-tile g-i-tile-catalog")
    private List< WebElement > productItems;

    @FindBy ( className =  "g-price-uah")
    private List<WebElement> itemsPrices ;

    public NotebookPage(WebDriver driver ) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public NotebookPage  filterMin (int sum ){
        filterMinFileld.sendKeys(Integer.toString(sum) );
        filterSubmit.click();
        return  new NotebookPage(driver);
    }

    public int getFilteredMin ( ) {
        return Integer.parseInt( filterMinFileld.getAttribute("value") );
    }

    private static int getPrice ( String priceString ){
        Pattern p = Pattern.compile("(.*).грн");
        Matcher m = p.matcher(priceString);
        m.matches();
        String str = m.group ( 1);
        str = str.replaceAll("\\s","");
        return Integer.parseInt(str );

    }

    public boolean isFilteredMin ( int minAvailable ) {
        boolean filtered = true ;
        for ( WebElement productPrice : itemsPrices ){
            String strPrice = productPrice.getText();
            int itemPrice = this.getPrice(strPrice);
            if (itemPrice  < minAvailable ){
                filtered = false;
            }
        }
        return filtered;
    }
   /* public boolean checkFilter (WebElement productItem ){
        productItem.getPrice();
    }*/


}
