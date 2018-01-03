package Pageobj;

        import Custom_elements.customdecorator.CustomFieldDecorator;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.support.PageFactory;

public class FirstPage {
    private WebDriver driver;

    public FirstPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }

    public WebDriver getDriver() {
        return driver;
    }
}