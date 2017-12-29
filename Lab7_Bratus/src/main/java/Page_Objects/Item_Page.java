package Page_Objects;

import Elements.*;
import Extensions.ChromeDriverEx;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class Item_Page extends Screen_Page {

    public Item_Page(ChromeDriverEx driver) {
        super(driver);
    }

    @FindBy(id = "price_label")
    @CacheLookup
    public HTML_Label label;

    @FindBy(xpath = "//*[@id='detail_buy_label']/div[3]/div[1]/div/form/span/span/button")
    @CacheLookup
    public Button buy;

    public int Get_Price(){
        String price_string = label.getText();
        price_string = price_string.replaceAll(" ","");
        return Integer.parseInt(price_string);
    }
}
