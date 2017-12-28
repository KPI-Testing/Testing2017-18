import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import java.util.List;

import javax.imageio.ImageIO;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public class prog2 {
   
private static FirefoxDriver driver;
WebElement element;
String te = "adidas";

 @BeforeClass
 public static void openBrowser(){
	 System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
     driver = new FirefoxDriver();
	} 
	
 @Test
 public void test1() {
     driver.get("http://www.google.com");
	 WebElement element = driver.findElement(By.name("q"));
	 element.sendKeys(te); 
	 element.submit();
	 System.out.println("Ok");
 }

 @Test
 public void test4() {
	 List<WebElement> findElements = driver.findElements(By.xpath("//*[contains(@class, 'rc')]//span[contains(@class, 'st')] | //*[contains(@class, 'rc')]//h3"));
	 for (WebElement webElement : findElements)
	 {

		 if (webElement.getText().toLowerCase().matches(".*"+te.toLowerCase()+".*") == true) {

	    		System.out.println("Found");
	    		System.out.print(webElement.getText());
	    		BufferedImage image;
				try {
					image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
					ImageIO.write(image, "jpg", new File("C:\\Users\\Asus\\eclipse-workspace\\screens\\prog2.jpg"));
					} catch (Exception e) {
					e.printStackTrace();
				}    
	    		break;
	    	}
	 }
	    
 }

 @AfterClass
 public static void closeBrowser(){
	 driver.quit();
 }
}