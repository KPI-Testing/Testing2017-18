import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public class prog4 {
   
private static FirefoxDriver driver;
WebElement element;

 @BeforeClass
 public static void openBrowser(){
	 System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
     driver = new FirefoxDriver();
	} 
	
 @Test
 public void test1() {
     driver.get("https://rozetka.com.ua/notebooks/c80004/filter/producer=asus/");
	 WebElement element = driver.findElement(By.name("price[min]"));
	 element.sendKeys("20000"); 

	 WebElement element2 = driver.findElement(By.name("price[max]"));
	 element2.click();
	 driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	 
	 for(int i = 0; i < 7; i++){
	   element2.sendKeys(Keys.ARROW_LEFT);
	 }

	 for(int i = 0; i < 7; i++){
		 element2.sendKeys(Keys.DELETE);
	 }
	 
	 element2.sendKeys("30000");
	 WebElement element3 = driver.findElement(By.xpath("//*[@id='submitprice']"));
	 element3.click();
	 
	 try {
		TimeUnit.SECONDS.sleep(10);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
 }
 
 @Test
 public void test2() {
	 int i = 0;
	 String s;
	 BufferedImage image;
		try {
			image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			ImageIO.write(image, "jpg", new File("C:\\Users\\Asus\\eclipse-workspace\\screens\\prog4.jpg"));
			} catch (Exception e) {
			e.printStackTrace();
		}
	 List<WebElement> findElements = driver.findElements(By.xpath("//*/div[contains(@class, 'g-price-uah')]"));
	 for (WebElement webElement : findElements){

		 //System.out.println(webElement.getText());
		 s = webElement.getText();
		 s = s.replaceAll("[^\\d.]", "");
		 //System.out.println("New price: "+s);
		 i = Integer.parseInt(s);
		 if (i < 30000 && i > 20000) {
			 System.out.println("Done: " + i);
		 }
	 }
 }
 
 @AfterClass
 public static void closeBrowser(){
	 driver.quit();
 }
}