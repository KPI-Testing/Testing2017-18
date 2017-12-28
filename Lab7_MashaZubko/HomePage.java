package Lab7.pages;

import org.openqa.selenium.WebDriver;

public class HomePage {

    private static final String ROZETKA_HOME_PAGE_URL = "https://rozetka.com.ua/ua/";
    private final Navigation Navigation;
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.Navigation = new Navigation(driver);
    }

    public HomePage open() {
        driver.get(ROZETKA_HOME_PAGE_URL);
        return this;
    }

    public Navigation Elements() {
        return Navigation;
    }
}

