package se_roz_2;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SchoolBagPage {
	private WebDriver driver;
	@FindBy(xpath = ".//*[@id='filter_copy_strana-proizvoditelj-tovara-103660_580d747cee3c5_661116']/label/a/span/i[1]")
    private WebElement UACheckBox;

	@FindBy(xpath = ".//*[@id='price[min]']")
    private WebElement MinPrice;

	@FindBy(xpath = ".//*[@id='price[max]']")
    private WebElement MaxPrice;

	@FindBy(xpath = ".//*[@id='submitprice']")
    private WebElement SubmitPrice;

	@FindBy(xpath = ".//*[@id='catalog_goods_block']/div/div/div[1]/div/div[1]/div/div/div/div/div/form/span/button")
	private List<WebElement> foundElements;
	   //Constructor
	   public SchoolBagPage (WebDriver driver){
	       this.driver=driver;

	       //Initialise Elements
	       PageFactory.initElements(new AjaxElementLocatorFactory(driver, 25), this);
	   }

	   public void verifyPageLoaded() {
			WebElement myDynamicElement = (new WebDriverWait(driver, 10))
		              .until(ExpectedConditions.presenceOfElementLocated(By.id("footer-mobile-link")));
	   }	   
	   
	   public void checkUACheckBox(){
		   UACheckBox.click();
    }
	   public void SetMinPrice(String Price) {
		   verifyPageLoaded(); 	
		   MinPrice.sendKeys(Price);
    }
	   public void SetMaxPrice(String Price) {
		   verifyPageLoaded();
		   MaxPrice.sendKeys(Price);
    }

	   public void SetPriceRange(String Min,String Max) {
		   verifyPageLoaded();
		   MinPrice.sendKeys(Keys.CONTROL + "a");
		   MinPrice.sendKeys(Keys.DELETE);
		   MinPrice.sendKeys(Min);
		   MaxPrice.sendKeys(Keys.CONTROL + "a");
		   MaxPrice.sendKeys(Keys.DELETE);
		   MaxPrice.sendKeys(Max);
    }
	
	   public void ApplySubmitPrice() {
		   verifyPageLoaded();
		   SubmitPrice.click();
    }
	   public int CountFound() {
		   verifyPageLoaded();
		   return foundElements.size();

	}
	   public void BuyFound( int n) {
//		   verifyPageLoaded();
		   foundElements.get(n).click();

	}

}
