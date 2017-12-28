package Testapp;

import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
import SideBar.SideBar;
import Page.Page;
import Page.CheckoutPage;
import Page.HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class Testapp {
	private static FirefoxDriver driver;
	
	
	public void Timeout(int i) {
		 try {
				TimeUnit.SECONDS.sleep(i);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
	}
	
	
	@BeforeClass
	 public static void openBrowser(){
		 System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
	     driver = new FirefoxDriver();
	     driver.get("https://rozetka.com.ua/");
		} 
	
	@Test
	public void home_page_test() {
		 //Homepage
		 HomePage hpg = new HomePage(driver);
		 hpg.findcat("Алкогольные напитки и продукты");
		 Timeout(10);
		 hpg.findtype("Вино");
		 Timeout(10);
		 hpg.allvines();
		 Timeout(20);
		 //Filter sidebar
		 SideBar sbn = new SideBar(driver);
		 Timeout(10);
		 sbn.findmin("100");
		 sbn.findmax("2000");
		 sbn.subbutt();
		 Timeout(10);
		 sbn.findua();
		 //Chechout
		 CheckoutPage cop = new CheckoutPage(driver);
		 cop.bel();
		 Timeout(10);
		 cop.bel2();
		 Timeout(10);
		 cop.subname("Karina_test");
		 Timeout(10);
		 cop.subphone("+380951122333");
		 Timeout(10);
		 cop.submail("karinatest2@gmail.com");
		 Timeout(10);
		 cop.subbutt();
		 Timeout(10);
		 WebElement subb = driver.findElement(By.xpath("//*/button[contains(@tabindex, '29')]"));
		 if (subb.isDisplayed() && subb.isEnabled()) {
			 System.out.println("OK, FOUND BUTT");
		 }
	}
	
	 
	 @AfterClass
	 public static void closeBrowser(){
		 driver.quit();
	 }
}