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

public class prog1 {
   
private static FirefoxDriver driver;
WebElement element;
String te = "Adidas";


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
	 WebElement element2 = driver.findElement(By.xpath("//*[@id='navcnt']//a"));
	 element2.click();
 }

 int i = 0;
 WebElement element2;
 List<WebElement> findElements = driver.findElements(By.xpath("//*[contains(@class, 'rc')]//span[contains(@class, 'st')] | //*[contains(@class, 'rc')]//h3"));
 boolean f = false;
 @Test
 public void test3() {
 int j = 2;
	    while(f == false)
	    {	
	    	i++;
	    	if(i == findElements.size()) {
	    		i=0;
	    		element2 = driver.findElement(By.xpath("//*[@id='pnnext']"));
	    		element2.click();
	    		boolean exists = driver.findElements(By.xpath("//*[@id='pnnext']")).size() != 0;
	    		if (exists == false) {
	    			break;
	    		}
	    		j++;
	    		findElements.clear();
	    		findElements = driver.findElements(By.xpath("//*[contains(@class, 'rc')]//span[contains(@class, 'st')] | //*[contains(@class, 'rc')]//h3"));
	    		
	    	}
	    	WebElement webElement = findElements.get(i);

	    	if (webElement.getText().toLowerCase().matches(".*"+te.toLowerCase()+".*") == true) {
	    		f = true;
	    		System.out.println("Found");
	    		System.out.print(webElement.getText());
	    		BufferedImage image;
				try {
					image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
					ImageIO.write(image, "jpg", new File("C:\\Users\\Asus\\eclipse-workspace\\screens\\"+j+".jpg"));
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