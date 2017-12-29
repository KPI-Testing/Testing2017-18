package bdd3.story;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class BasketPage {
	private WebDriver driver;

	@FindBy(xpath = ".//*[@id='popup-checkout']")

	private WebElement Checkout;

	@FindBy(xpath = "//span[@class='cart-return-link']/span/a")

	private WebElement Shopping;

	@FindBy(xpath = ".//*[@id='drop-block']/h2")
	private List<WebElement> isEmpty;

	@FindBy(xpath = "//a[@class='popup-close']/img")
	private WebElement close;

	@FindBy(xpath = "//div[@class='cart-check-wrap']/a[@name='before_delete']/img")
	private WebElement del;

	@FindBy(xpath = "//div[@class='cart-i-delete']/a[@name='delete']")
	private WebElement confirmdel;

	//Constructor
	   public BasketPage (WebDriver driver){
	       this.driver=driver;

	       //Initialise Elements
	       PageFactory.initElements(new AjaxElementLocatorFactory(driver, 25), this);
	   }
	   public void clikCheckout(){
		   Checkout.click();
	   }

	   public void clikShopping(){
		   Shopping.click();
	   }

	   public int emptyFound() {
		   return isEmpty.size();
	   }
	   
	   public void closeBasketPage() {
		   close.click();
	   }
	   public void delFromBasket() {
		   del.click();
	   }
	   public void confirmdelFromBasket() {
		   confirmdel.click();
	   }

}
