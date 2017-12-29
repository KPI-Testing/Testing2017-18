import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestFramework {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		 System.setProperty("webdriver.chrome.driver","C:\\selenium-java-3.7.1\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 HomePage home = new HomePage(driver);
		 home.clickOnSchoolBooksPage();
		 SchoolBooksPage schoolbook = new SchoolBooksPage(driver);
		 schoolbook.clikSchoolBagPage();
		 SchoolBagPage schoolbag = new SchoolBagPage(driver);
		 schoolbag.checkUACheckBox();
//		 schoolbag.SetMinPrice("500");
//		 schoolbag.SetMaxPrice("2000");
		 schoolbag.SetPriceRange("100","2000");
		 schoolbag.ApplySubmitPrice();
		 System.out.println(schoolbag.CountFound());
		 schoolbag.BuyFound(2);
		 PopupCheckout popup = new PopupCheckout(driver);
		 popup.clikCheckout();
		 FullCheckout ckout = new FullCheckout(driver);
		 ckout.Proceed("Basyl Pupkin", "bpupkin@yahoo.com", "0505000068");
		 OrderPage pass = new OrderPage(driver);
		 pass.IsPassed();

		 driver.quit();
	}

}
