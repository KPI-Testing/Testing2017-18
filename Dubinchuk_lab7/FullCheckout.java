import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FullCheckout {
	private WebDriver driver;

	   @FindBy(xpath = ".//*[@id='reciever_name']")
	   private WebElement Name;
	   @FindBy(xpath = ".//*[@id='reciever_phone']")
	   private WebElement Phone;
	   @FindBy(xpath = ".//*[@id='reciever_email']")
	   private WebElement Email;
	   @FindBy(xpath = ".//*[@id='suggest_locality']")
	   private WebElement Location;
	   @FindBy(xpath = ".//*[@id='step_contacts']/div/div[1]/div[2]/div/span/button")
	   private WebElement Next;

	   
	   //Constructor
	   public FullCheckout (WebDriver driver){
	       this.driver=driver;

	       //Initialise Elements
	       PageFactory.initElements(new AjaxElementLocatorFactory(driver, 25), this);
	   }


	   public void Proceed(String name,String email,String phone){
		   
		   
		   Name.sendKeys(name);
		   Location.click();
		   Location.sendKeys(Keys.ARROW_DOWN);
		   Location.sendKeys(Keys.ENTER);
		   Phone.sendKeys(phone);
		   Email.sendKeys(email);
		   try {
			Thread.sleep(3000);
		   	} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   	}
		   if (Next.isDisplayed() && Next.isEnabled()) {
			    Next.click();
		   }
	   }
}