package se_roz_2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage {
   private WebDriver driver;

   //Page URL
   private static String PAGE_URL="https://rozetka.com.ua";

   @FindBy(xpath = ".//*[@id='14127']/a")
   private WebElement SchoolBooksPage;

   //Constructor
   public HomePage(WebDriver driver){
       this.driver=driver;
       driver.get(PAGE_URL);
       //Initialise Elements
       PageFactory.initElements(new AjaxElementLocatorFactory(driver, 25), this);
   }

   public void clickOnSchoolBooksPage(){

       SchoolBooksPage.click();

   }
}