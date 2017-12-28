package SideBar;
import Testapp.Testapp;
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
public class SideBar {
	
	private WebDriver driver;
	
	public SideBar(WebDriver driver) {
		this.driver = driver;
	}
	
	public void findmin(String names) {
		WebElement element;
		element = driver.findElement(By.xpath("//*/input[@id='price[min]']"));
		System.out.println("FOUND MIN");
		element.sendKeys(names);
	}
	
	public void findmax (String val) {
		WebElement element2 = driver.findElement(By.name("price[max]"));
		 element2.click();
		 
		 for(int i = 0; i < 7; i++){
		   element2.sendKeys(Keys.ARROW_LEFT);
		 }

		 for(int i = 0; i < 7; i++){
			 element2.sendKeys(Keys.DELETE);
		 }
		 
		 element2.sendKeys(val);
	}
	
	
	public void subbutt(){
		WebElement element3 = driver.findElement(By.xpath("//*[@id='submitprice']"));
		 element3.click();
	}
	
	
	public void findua() {
		 List<WebElement> findElements = driver.findElements(By.xpath("//*/ul[@id='sort_strana-vino']//li"));

		 int m = 0;
		 WebElement element4;
		 for (m = 1; m < findElements.size(); m++){
			 element4 = driver.findElement(By.xpath("//*/ul[@id='sort_strana-vino']//li["+m+"]//span"));
			 String el4 = element4.getText();
			 el4 = el4.replaceAll("[^А-Яа-я]", "");
			 if (el4.matches("Украина") == true) {
				 System.out.println("FOUND");
				 element4.click();
			 } 
		 }
	}

}