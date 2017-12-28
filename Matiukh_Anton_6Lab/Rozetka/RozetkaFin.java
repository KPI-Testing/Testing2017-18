package automat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RozetkaFin {
static int Price_f=100;
static int Price_a;
	 public static void main(String[] args) throws Exception {
		 
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\selenium-java-3.7.1\\chromedriver_win32\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		    driver.get("https://rozetka.com.ua/hudojestvennaya-literatura/c4326593/");
			WebElement myDynamicElement = (new WebDriverWait(driver, 10))
		              .until(ExpectedConditions.presenceOfElementLocated(By.id("footer-mobile-link")));

		    WebElement element =  driver.findElement(By.xpath(".//*[@id='price[min]']"));	
		    element.sendKeys(String.valueOf(Price_f)); 
			element =  driver.findElement(By.xpath(".//*[@id='submitprice']"));	
		    element.submit();
		    
			List<WebElement> findElements = driver.findElements(By.xpath(".//*[@id[starts-with(., 'goods_price_block_')]]/div/div"));	
			for (WebElement webElement : findElements)
			{
			 String TextLink = webElement.getText();
			 System.out.print(TextLink);
			 Pattern p = Pattern.compile("\\d+");
			 Matcher m = p.matcher(TextLink);
			 while(m.find()) Price_a=Integer.parseInt(m.group());
			 if (Price_a == Price_f) System.out.print(" = ");
			 else 
			 if (Price_a > Price_f) System.out.print(" > ");	 
			 else 
			 if (Price_a < Price_f) System.out.print(" < ");	 
			 System.out.println(Price_f);	 
			}
		    driver.quit();	    
	 }
	 
}
