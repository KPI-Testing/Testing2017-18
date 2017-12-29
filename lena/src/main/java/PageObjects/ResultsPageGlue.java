package PageObjects;

import CustomElements.Button;
import CustomElements.Checklist;
import CustomElements.Element;
import CustomElements.TextField;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class ResultsPageGlue extends PageObject{
    public ResultsPageGlue(WebDriver driver){
        super (driver);
    }

    public static final String URL_PRODUCTS_GLUE = "https://rozetka.com.ua/ua/kley/c2560862/";

    public ResultsPageGlue get (){
        driver.get(URL_PRODUCTS_GLUE);
        return this;
    }


    @FindBy( xpath  = "//*[@id=\"filter_parameters_form\"]/div[6]/div[2]")
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

    @FindBy(className = "g-buy")
    public List< Element >ItemsBuy;


    public void setMinPrice(int price){
        minPrice.sendKeys(Integer.toString(price));
        submitPrice.click();
    }

    public void setMaxPrice(int price){
        maxPrice.sendKeys(Integer.toString(price));
        submitPrice.click();
    }

    public int getMinPrice(){
       return Integer.parseInt(minPrice.getAttribute("value"));
    }
    public int getMaxPrice(){
        return Integer.parseInt(maxPrice.getAttribute("value"));
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
