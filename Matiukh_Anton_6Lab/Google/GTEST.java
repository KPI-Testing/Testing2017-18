package automat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TakesScreenshot;

import java.awt.AWTException;
import java.awt.Graphics2D;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

public class GTEST {

static String Keyword="SkyTeam";

//static String Company="China Eastern Airline"; // Test N 1, see readme.txt
//static String Company="Aeroflot"; // Test N 2, see readme.txt
static String Company="Lufthansa"; // Test N 3, see readme.txt
private static int scrollTimeout = 2000;  
public void ScreenShot(int timeout) {  
  scrollTimeout = timeout;  
}  
private static String getFullHeight(WebDriver driver) {  
  JavascriptExecutor js = (JavascriptExecutor) driver;  
  return js.executeScript("return document.body.scrollHeight").toString();  
}  
private static int getFullWidth(WebDriver driver) {  
  JavascriptExecutor js = (JavascriptExecutor) driver;  
  return ((Long) js.executeScript("return window.innerWidth",  
      new Object[0])).intValue();  
}  
private static int getWindowHeight(WebDriver driver) {  
  JavascriptExecutor js = (JavascriptExecutor) driver;  
  return ((Long) js.executeScript("return window.innerHeight",  
      new Object[0])).intValue();  
}  
private static void waitForScrolling() {  
  try {  
    Thread.sleep(scrollTimeout);  
  } catch (InterruptedException ignored) {  
  }  
}  
private static BufferedImage getScreenshotNative(WebDriver wd) {  
  ByteArrayInputStream imageArrayStream = null;  
  TakesScreenshot takesScreenshot = (TakesScreenshot) new Augmenter().augment(wd);  
  try {  
    imageArrayStream = new ByteArrayInputStream(takesScreenshot.getScreenshotAs(OutputType.BYTES));  
    return ImageIO.read(imageArrayStream);  
  } catch (IOException e) {  
    throw new RuntimeException("Can not parse screenshot data", e);  
  } finally {  
    try {  
      if (imageArrayStream != null) {  
        imageArrayStream.close();  
      }  
    } catch (IOException ignored) {  
    }  
  }  
}  
public static BufferedImage getScreenshot(WebDriver wd) {  
  JavascriptExecutor js = (JavascriptExecutor) wd;  
  int allH = Integer.parseInt(getFullHeight(wd));  
  int allW = getFullWidth(wd);  
  int winH = getWindowHeight(wd);  
  int scrollTimes = allH / winH;  
  int tail = allH - winH * scrollTimes;  
  BufferedImage finalImage = new BufferedImage(allW, allH, BufferedImage.TYPE_4BYTE_ABGR);  
  Graphics2D graphics = finalImage.createGraphics();  
  for (int n = 0; n < scrollTimes; n++) {  
    js.executeScript("scrollTo(0, arguments[0])", winH * n);  
    waitForScrolling();  
    BufferedImage part = getScreenshotNative(wd);  
    graphics.drawImage(part, 0, n * winH, null);  
  }  
  if (tail > 0) {  
    js.executeScript("scrollTo(0, document.body.scrollHeight)");  
    waitForScrolling();  
    BufferedImage last = getScreenshotNative(wd);  
    BufferedImage tailImage = last.getSubimage(0, last.getHeight() - tail, last.getWidth(), tail);  
    graphics.drawImage(tailImage, 0, scrollTimes * winH, null);  
  }  
  graphics.dispose();  
  return finalImage;  
}  
public static void EShot(WebDriver wd, String filename) {  
  try {  
    ImageIO.write(getScreenshot(wd), "PNG", new File(filename));  
  } catch (IOException e) {  
    System.out.println(e);  
  }  
}  

	 public static void main(String[] args) throws Exception {
		 
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\selenium-java-3.7.1\\chromedriver_win32\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
			try {
				Robot robot = new Robot();
				Thread.sleep(2000);
				robot.keyPress(KeyEvent.VK_F11);
			} catch (AWTException e) {
				System.err.println("Exception (ignored) " + e.toString());
			}
		    driver.get("http://www.google.com");

		    WebElement element = driver.findElement(By.name("q"));
		    element.sendKeys(Keyword); 
		    element.submit();
			int pagenum =1;
			while (true)
			{	
		    
		    WebElement myDynamicElement = (new WebDriverWait(driver, 10))
		              .until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats")));

		    JavascriptExecutor executor = (JavascriptExecutor)driver;
		    executor.executeScript("document.body.style.zoom = '1.0'");
			String resultfile = String.format("c:\\images\\page%d.png",pagenum );
			GTEST.EShot(driver, resultfile);  
			List<WebElement> findElements = driver.findElements(By.xpath("//*[@id='rso']//h3/a"));			
			 
			for (WebElement webElement : findElements)
			{
				String TextLink = webElement.getText();
				if (TextLink.contains(Company))
				{
					resultfile = String.format("c:\\images\\%s.png",Company );
					GTEST.EShot(driver, resultfile);
					for(int i=1;i<=pagenum;i++) {
						resultfile = String.format("c:\\images\\page%d.png",i );
						FileUtils.forceDelete(FileUtils.getFile(resultfile));
					}	
					System.out.println(pagenum);
					driver.quit();
					System.exit(pagenum);
				}

			}
         pagenum++; 
		 executor = (JavascriptExecutor)driver;
		 executor.executeScript("document.body.style.zoom = '1.0'");
         findElements = driver.findElements(By.xpath(".//*[@id='pnnext']/span[2]"));
         if (findElements.isEmpty())
         {
				driver.quit();
				System.exit(pagenum);
         }
		 for (WebElement ele : findElements) ele.click();
			
         
		}	
			
	 }
}	 