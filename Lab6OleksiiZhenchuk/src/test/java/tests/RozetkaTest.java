package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.RozetkaPage;
import pages.Waiter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

public class RozetkaTest {
	static WebDriver driver;
	
	@Before
    public void setUp (){
        String exePath = "D:\\Oleksij\\Downloads\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        driver = new ChromeDriver();
        driver.get("https://rozetka.com.ua/mobile-phones/c80003/preset=smartfon/");
    }
	
	@Test
	public void setPrice () throws InterruptedException, IOException {
		RozetkaPage shop = new RozetkaPage(driver);
		/*Waiter.waitImplicit(driver, 5, TimeUnit.SECONDS);*/
		int minPriceToSet = 5000;
		System.out.println("Setting minimal price " + Integer.toString(minPriceToSet));
		shop.setMinimumPrice(minPriceToSet);
		shop.priceSubmit();
		int minPriceReal;
		if((minPriceReal=shop.getMinPrice())==minPriceToSet) System.out.println("The price set was changed correctly, min price is " + Integer.toString(minPriceReal));
		else System.out.println("The price set WASN'T changed correctly, the real min price is " + Integer.toString(minPriceReal));
		ArrayList <String> goodPrices = new ArrayList<String>();
		shop.getGoodPricesTo(goodPrices);
		System.out.println("Prices of goods on the page:");
		System.out.println(goodPrices.toString());
		boolean isCorrect = shop.setCheck(minPriceToSet);
		if(isCorrect) System.out.println("The goods are correctly chosen according to set minimal price");
		else System.out.println("The goods are NOT chosen according to set minimal price");
	}
	
	@After
    public void setDown(){
        driver.quit();
    }
}
