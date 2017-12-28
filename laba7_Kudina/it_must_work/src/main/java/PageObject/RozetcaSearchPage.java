package PageObject;

import extensions.ChromeDriverEx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RozetcaSearchPage extends RozetcaResultPage{

    public RozetcaSearchPage(ChromeDriverEx driver){

        super(driver);
    }

    @FindBy(css = ".over-wraper .g-i-tile-i-box-desc >div:first-child > div>a")
    private List<WebElement> results;

    public void chouse_the_result(int index){
        results.get(index).click();
    }

}
