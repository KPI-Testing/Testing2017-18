package PageObjects;

import CustomElements.Button;
import CustomElements.Checklist;
import CustomElements.TextField;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


/**  It's alternative method  which doesn.t work  Later I'll come back to finish  this  .
 * it schould be smth like container but there were some troubles
 *
 * P.S. Go to ResultsPageGlue
 * */


public class Filter extends ProductsGlue {
    /**  It's alternative method  which doesn.t work  Later I'll come back to finish  this  .
     * it schould be smth like container but there were some troubles */
   @FindBy( css  = "#sort_copy_strana-proizvoditelj-tovara-103660_580d747cee3c5")
    public Checklist country;

    @FindBy(xpath = "//*[@id=\"filter_parameters_form\"]/div[4]/div[2]")
    public Checklist osnova;

    @FindBy(xpath = "//*[@id=\"filter_parameters_form\"]/div[3]/div[2]")
    public Checklist volume;

    @FindBy(xpath =  "//*[@id=\"sort_producer\"]")
    public Checklist producer;

    @FindBy(xpath = "//*[@id=\"filter_parameters_form\"]/div[1]/div[2]")
    public Checklist type;

    @FindBy(id = "price[min]")
    public TextField minPrice;

    @FindBy(id = "price[max]")
    public TextField maxPrice;

    @FindBy(id = "submitprice")
    public Button submitPrice;

    public Filter(WebDriver driver) {
        super(driver);
    }


    public void setMinPrice(int price){
        minPrice.sendKeys(Integer.toString(price));
        submitPrice.click();
    }

    public void setMaxPrice(int price){
        maxPrice.sendKeys(Integer.toString(price));
        submitPrice.click();
    }


    public void setCountry ( String countryToSelect){
        country.select(countryToSelect);
    }

    public void setProducer ( String producerToSelect){
        producer.select(producerToSelect);
    }

    public void setOsnova ( String osnovaToSelect){
        country.select(osnovaToSelect);
    }

    public void setType( String typeToSelect){
        country.select(typeToSelect);
    }



}
