package Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class DriverFactory {
    private static String getOS(){
        String os = System.getProperty("os.name").toLowerCase();
        if(os.contains("win")) return "win";
        if(os.contains("mac")) return "mac";
        if(os.contains("nix") || os.contains("nux")) return "lin";
        return "";
    }

    private static void setSystemProperty(String name){
        String key = String.format("webdriver.%s.driver",
                name.toLowerCase());
        String slash = (getOS().equals("win"))?"\\":"/";
        String value = String.format(".%sdriver%s%s%s%sdriver%s",
                slash,
                slash,
                getOS(),
                slash,
                name,
                (getOS().equals("win"))?".exe":""
        );
        System.setProperty(key, value);
    }

    WebDriver getDriver(String driverName){
        if(driverName.equalsIgnoreCase("CHROME")) {
            setSystemProperty("chrome");
            return  new ChromeDriver();
        }
        else if(driverName.equalsIgnoreCase("FIREFOX")) {
            setSystemProperty("gecko");
            return new FirefoxDriver();
        }
        return null;
    }
}
