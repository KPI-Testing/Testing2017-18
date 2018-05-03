import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class SchoolBooksPage {
	private WebDriver driver;

	   @FindBy(xpath = ".//*[@id='14127']/div/div[2]/div/ul[2]/li[1]/ul/li[1]/a")

	   private WebElement SchoolBagPage;

	   //Constructor
	   public SchoolBooksPage (WebDriver driver){
	       this.driver=driver;

	       //Initialise Elements
	       PageFactory.initElements(new AjaxElementLocatorFactory(driver, 25), this);
	   }


	   public void clikSchoolBagPage(){
		   SchoolBagPage.click();
	   }
}
