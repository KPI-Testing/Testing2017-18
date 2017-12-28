package bdd3.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class RozSteps {
    private WebDriver driver;
	private SchoolBooksPage schoolbook;
	private SchoolBagPage schoolbag;
	private BasketPage basket;
	private FullCheckout ckout; 
    private OrderPage pass;
    
    public RozSteps() {
 		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\selenium-java-3.7.1\\chromedriver_win32\\chromedriver.exe");
		 driver = new ChromeDriver();
         driver.manage().window().maximize();
    }
 	@Given("open schoolbookspage")
    public void openschoolbookspage() {
		schoolbook = new SchoolBooksPage(driver);
    	if (schoolbook.equals(null)) System.out.print("FAIL ");
		else
		System.out.print("PASS ");	
    }
	@When("open schoolbagspage")
    public void openschoolbagspage() {
 		schoolbook.clikSchoolBagPage();
		schoolbag = new SchoolBagPage(driver);
    	if (schoolbag.equals(null)) System.out.print("FAIL ");
		else
		System.out.print("PASS ");	
    }

	@Then("should see goods")
    public void shouldbegoods() {
		if (schoolbag.CountFound()>0)  System.out.print("PASS ");
		else
		System.out.print("FAIL ");	
     }

	@Then("order number $number")
    public void ordergoods(int n) {
		schoolbag.BuyFound(n);
		basket = new BasketPage(driver);
    	if (basket.equals(null)) System.out.print("FAIL ");
		else
		System.out.print("PASS ");	
     }

	@Then("continue shopping")
    public void contshopping() {
		basket.clikShopping();
     }

	 @When("open basketpage")
    public void openbasketpage() {
 		schoolbook.clickOnBasketPage();
		basket = new BasketPage(driver);
    	if (basket.equals(null)) System.out.print("FAIL ");
		else
		System.out.print("PASS ");	
    }
	@Then("should be empty")
    public void shouldbaskempty() {
		if (basket.emptyFound()>0)  System.out.print("PASS ");
		else
		System.out.print("FAIL ");	
     }
	@Then("should be not empty")
    public void shouldbasknonempty() {
		if (basket.emptyFound() == 0)  System.out.print("PASS ");
		else
		System.out.print("FAIL ");	
     }
 
	@Then("close basketpage")
    public void closebasketpage() {
		basket.closeBasketPage();
    }

	@Then("delete from basket")
    public void delfrombasket() {
		basket.delFromBasket();
		basket.confirmdelFromBasket();
     }
	@Then("proceed checkout")
    public void proceedcheckout() {
 		basket.clikCheckout();
		ckout = new FullCheckout(driver);
    	if (ckout.equals(null)) System.out.print("FAIL ");
		else
		System.out.print("PASS ");	
    }
	@Then("fill form $name $email $phone")
    public void fillform(String name,String email,String phone) {
		ckout.Proceed(name, email, phone);
		pass = new OrderPage(driver);
    	if (pass.equals(null)) System.out.print("FAIL ");
		else
		System.out.print("PASS ");	
     }

	@Then("should see confirm")
    public void shouldseeconfirm() {
		if (pass.IsPassed() == true)  System.out.print("PASS ");
		else
		System.out.print("FAIL ");	
     }
	 
}