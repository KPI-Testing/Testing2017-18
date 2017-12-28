package Page;
import SideBar.SideBar;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
public class Page {
	 private static final String PAGE= "https://rozetka.com.ua/";
	    private WebDriver driver;
	    public Page(WebDriver driver) {
	       this.driver = driver;
	    }
	    public Page open() {
	       driver.get(PAGE);
	       return this;
	    }
}