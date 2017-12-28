package contexts.actions;
import extentions.NotExistProducerExeption;
import extentions.NotHaveProductsExeption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.*;
import utils.Waiters;

import java.util.List;
import java.util.Random;

public class Filtering {

    private static SearchPage yet(BasePage page) throws InterruptedException {
        By by = new By.ByCssSelector("#filter_parameters_form > div:nth-child(2) > div.pos-fix > a:nth-child(2)");
        Waiters.waitClickableAndDisplayed(page.getDriver(),by,3000);
        WebElement clickYet = page.getDriver().findElement(by);
        Waiters.waitClickableAndDisplayed(page.getDriver(), clickYet, 3000);
        Thread.sleep(2000);
        clickYet.click();
        return (SearchPage) page;
    }
    public static SearchPage setPrice(SearchPage page, Integer minPrice, Integer maxPrice){
        page.setMinimumPrice(minPrice).setMaximumPrice(maxPrice)
                .priceSumit();
        return page;
    }

    public static SearchPage chooseProducer(SearchPage page, String producer) throws NotExistProducerExeption, NotHaveProductsExeption, InterruptedException {
        yet(page);
        int current = -1;
        for (int i = 0; i < page.getMyFirstLables().size(); i++) {
            if (page.getMyFirstLables().get(i).getLableName().equalsIgnoreCase(producer.trim())) {
                current = i;
                break;
            }
        }

        if (current == -1) {
            throw new NotExistProducerExeption();
        } else {
            page.setMyFirstLable(page.getMyFirstLables().get(current));
            if (page.getMyFirstLable().getCounterLable() == 0) {
                throw new NotHaveProductsExeption();
            } else {
                Waiters.waitClickableAndDisplayed(page.getDriver(),page.getMyFirstLable(),1000);
                page.getMyFirstLable().click();
            }
        }
        return page;
    }

    public static ProductPage setProduct(SearchPage page, String producer){
        By linksXpath = new By.ByXPath("//*[@id='catalog_goods_block']/div/div/div/div/div/div/*[@class='g-i-tile-i-title clearfix']/a");
        //Waiters.thredsleep(2000);
        Waiters.waitClickableAndDisplayed(page.getDriver(),linksXpath,1000);
        List<WebElement> links = page.getDriver().findElements(linksXpath);
        Random rnd = new Random(System.currentTimeMillis());
        int pageNum = rnd.nextInt(links.size());
       // Waiters.thredsleep(1000);
        Waiters.waitClickableAndDisplayed(page.getDriver(),links.get(pageNum),1000);
        links.get(pageNum).click();
        return new ProductPage(page.getDriver());
    }

}
