package Driver;

import org.openqa.selenium.WebDriver;

public final class DriverSingleton {
    private static volatile WebDriver instance = null;

    private DriverSingleton() {
    }

    public static WebDriver getInstance(String browserName) {
        if (instance == null) {
            synchronized (DriverSingleton.class) {
                if (instance == null)
                    instance = new DriverFactory().getDriver(browserName);
            }
        }
        return instance;
    }

    public static void driverClose(WebDriver driver){
        driver.close();
        instance = null;
    }

}
