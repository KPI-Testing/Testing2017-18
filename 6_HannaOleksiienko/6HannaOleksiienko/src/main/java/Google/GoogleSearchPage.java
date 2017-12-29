package Google;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class GoogleSearchPage {

    protected WebDriver _driver;

    public GoogleSearchPage(WebDriver driver) {
        _driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name="q")
    private WebElement searchField;

    @FindBy(name="btnG")
    private WebElement searchButton;

    @FindBy(id="pnnext")
    private WebElement nextPage;

    @FindBy(id="pnprev")
    private WebElement prevPage;

    @FindBy(xpath="//*[@id='rso']//h3/a")
    private List<WebElement> listOfPageLinks;


    String searchTerm;
    public GoogleSearchPage searchFor(String keyword) {
        this.searchTerm = keyword;
        searchField.sendKeys(searchTerm);
        searchButton.submit();
        WebElement myDynamicElement = (new WebDriverWait(_driver, 1000)).until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats")));
        return this;
    }
    public GoogleSearchPage goNextPage() {
        nextPage.click();
        return this;
    }
    public GoogleSearchPage goPrevPage() {
        prevPage.click();
        return this;
    }

    public int searchMyCompany (String CompanyWebSite) {

        int numberOfPage = 1;
        while (true) {

            for (WebElement webElement : listOfPageLinks) {
                String websiteName = webElement.getAttribute("href");
                if (websiteName.equals(CompanyWebSite)) {
                    searchField.clear();
                    System.out.print(searchTerm +": your company web site is on the page " + numberOfPage +". See the screenshot\n");
                    makeScreenShot(1,numberOfPage); // 1 - success
                    return numberOfPage;
                }
            }
            boolean buttonNext = _driver.findElements(By.id("pnnext")).size() != 0;
            if (buttonNext) {
                this.goNextPage();
                numberOfPage++;
            }
            else {
                System.out.print(searchTerm +": your company doesn't have reference to the keyword.\n");
                makeScreenShot(0,numberOfPage); // 0 - fail
                searchField.clear();
                return 0;
            }
        }

    }

    public void makeScreenShot(int successFlag,int pageNum){


            if (successFlag == 1) {
                _driver.manage().window().setPosition(new Point(0,0));
                java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
                Dimension dim = new Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight());
                _driver.manage().window().setSize(dim);
                Shutterbug.shootPage(_driver, ScrollStrategy.BOTH_DIRECTIONS,500,true).withName(searchTerm).save();

            }

            else {
                boolean buttonPrev = _driver.findElements(By.id("pnprev")).size() != 0;
                while (buttonPrev == true) {
                    this.goPrevPage();
                    pageNum--;
                    _driver.manage().window().setPosition(new Point(0,0));
                    java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
                    Dimension dim = new Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight());
                    _driver.manage().window().setSize(dim);
                    Shutterbug.shootPage(_driver, ScrollStrategy.BOTH_DIRECTIONS,500,true).withName(searchTerm+pageNum).save();
                    buttonPrev = _driver.findElements(By.id("pnprev")).size() != 0;
                }
            }

    }

}