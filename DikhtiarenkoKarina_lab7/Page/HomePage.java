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
public class HomePage {
	 
	    private WebDriver driver;
	    
	   public HomePage(WebDriver driver) {
	       this.driver = driver;
	   }
	    
	    public void findcat(String cat) {
	    	List<WebElement> findElements = driver.findElements(By.xpath("//*/ul[@id='m-main-ul']//li"));
	    	System.out.println(findElements.size());
			 int m = 0;
			 WebElement element4;
			 for (m = 1; m < findElements.size(); m++){
				 element4 = driver.findElement(By.xpath("//*/ul[@id='m-main-ul']//li[contains(@class, 'f-menu-l-i')]["+m+"]//a"));
				 String el4 = element4.getText();
				 if (el4.matches(cat) == true) {
					 System.out.println("FOUND");
					 element4.click();
				 }
				 
			 }
	    }
	    
	    public void findtype(String type) {
	    	
	    	List<WebElement> findElements = driver.findElements(By.xpath("//*/ul[contains(@class,'pab-items')]//li[contains(@class, 'pab-items-i')]//a"));
	    	for (WebElement webel : findElements) {
	    		String ttt = webel.getText();
	    		
	    		if (ttt.matches(type) == true) {
	    			System.out.println("FOUND ELEMENT");
	    			webel.click();
	    			break;
	    		}
	    	}
	    
	    }
	    
	    public void allvines() {
	    	WebElement element5 = driver.findElement(By.xpath("//*/ul[contains(@class,'m-cat-subl')]//li[contains(@class, 'm-cat-subl-i-more')]//a"));
	    	element5.click();
	    }
}