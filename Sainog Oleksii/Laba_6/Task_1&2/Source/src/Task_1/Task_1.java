package Task_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.xml.xpath.XPath;

public class Task_1 {
    public static void main (String args[]){
        String exePath = "c:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe";
        String oscilloscopeGoogle = "https://www.google.com.ua/search?q=%D0%BE%D1%81%D1%86%D0%B8%D0%BB%D0%BB%D0%BE%D0%B3%D1%80%D0%B0%D1%84&ei=_ysYWp26F8nA6QTx-7DICA&start=0&sa=N&biw=1351&bih=974";
        String nextPageXPath = "//*[@id=\"pnnext\"]";

        System.setProperty("webdriver.chrome.driver", exePath);
        WebDriver driver = new ChromeDriver();


        driver.get(oscilloscopeGoogle);
        WebElement ButtomNextPage = driver.findElement(By.xpath(nextPageXPath));
        ButtomNextPage.click();
        System.out.println(driver.findElement(By.xpath("//*[@id=\"rso\"]/div/div/div[1]/div/div/h3/a")).getText());
        driver.close();

    }
}
