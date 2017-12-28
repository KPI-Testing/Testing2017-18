package Page;
import SideBar.SideBar;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
public class CheckoutPage {
	 
	    private WebDriver driver;
	    
	   public CheckoutPage(WebDriver driver) {
	       this.driver = driver;
	   }
	    
	   public void bel() {
		   WebElement element = driver.findElement(By.xpath("//*/button[contains(@title, 'Купить')]"));
			element.click();  
	   }
	   
		 public void bel2() {
		 WebElement element2 = driver.findElement(By.xpath("//*/button[@id='popup-checkout']"));
		 element2.click();
		 }
		
		 public void subname(String name) {
		 WebElement element3 = driver.findElement(By.xpath("//*/input[@id='reciever_name']"));
		 element3.click();
		 for(int i = 0; i < 10; i++){
			   element3.sendKeys(Keys.ARROW_LEFT);
			 }

			 for(int i = 0; i < 10; i++){
				 element3.sendKeys(Keys.DELETE);
			 }
		 element3.sendKeys(name);
		 }
		 
		 public void subphone(String phone) {
		 WebElement element4 = driver.findElement(By.xpath("//*/input[@id='reciever_phone']"));
		 element4.click();
		 for(int i = 0; i < 15; i++){
			   element4.sendKeys(Keys.ARROW_LEFT);
			 }

			 for(int i = 0; i < 15; i++){
				 element4.sendKeys(Keys.DELETE);
			 }
		 element4.sendKeys(phone);
		 }
		 
		 public void submail(String mail) {
		 WebElement element5 = driver.findElement(By.xpath("//*/input[@id='reciever_email']"));
		 element5.click();
		 for(int i = 0; i < 15; i++){
			   element5.sendKeys(Keys.ARROW_LEFT);
			 }

			 for(int i = 0; i < 15; i++){
				 element5.sendKeys(Keys.DELETE);
			 }
		 element5.sendKeys(mail);
		 }
		 
		 public void subbutt() {
		 WebElement element6 = driver.findElement(By.xpath("//*/button[contains(@tabindex, '6')]"));
		 element6.click();
		 }
		 
}