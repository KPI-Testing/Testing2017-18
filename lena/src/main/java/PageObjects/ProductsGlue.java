package PageObjects;

import CustomElements.Checklist;
import CustomElements.TextField;
import Wrappers.CustomFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsGlue extends PageObject {

    /** It's alternative method  which doesn.t work  Later I'll come back to finish  this  .
     * P.S. Go to ResultsPageGlue*/
    public ProductsGlue(WebDriver driver){
        super(driver);
    }

    public static final String URL_PRODUCTS_GLUE = "https://rozetka.com.ua/ua/kley/c2560862/";

    public ProductsGlue get (){
        driver.get(URL_PRODUCTS_GLUE);
        return this;
    }



    @FindBy(xpath = "//*[@id=\"filter_parameters_form\"]")
    public Filter filter;


    public Filter switchToFilter ( ){
        Filter filter = new Filter(driver);
        return filter;
    }

}
