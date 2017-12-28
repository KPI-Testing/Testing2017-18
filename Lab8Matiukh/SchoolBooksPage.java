package bdd3.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class SchoolBooksPage {
	private WebDriver driver;

	private static String PAGE_URL="https://rozetka.com.ua/office-school-books/c4625734/";
	
	   @FindBy(xpath = "//a[contains(@href, 'http://rozetka.com.ua/school_bags/c163943/')]") 
	   private WebElement SchoolBagPage;

	   @FindBy(xpath = "//a[contains(@href, 'https://my.rozetka.com.ua/cart/')]")
	   private WebElement BasketPage;


	   //Constructor
	   public SchoolBooksPage (WebDriver driver){
       this.driver=driver;
       driver.manage().deleteAllCookies();
       driver.get(PAGE_URL);

	       //Initialise Elements
	       PageFactory.initElements(new AjaxElementLocatorFactory(driver, 25), this);
	   }


	   public void clikSchoolBagPage(){
		   SchoolBagPage.click();
	   }
	  public void clickOnBasketPage(){
			BasketPage.click();
   }
	   
}
