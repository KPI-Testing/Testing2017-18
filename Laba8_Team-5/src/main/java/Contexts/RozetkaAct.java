package Contexts;

import Elements.Html_label;
import PageObjects.Rozetka;
import org.openqa.selenium.By;

import static Waiter.Waiter.Wait;
import static Waiter.Waiter.waitForClick;

public class RozetkaAct {
    public static void buySomething(Rozetka page, String name){
        int i = 0;
        while (true){
            Html_label iter = page.getAllLabels().get(i);
            if (iter.findElement(By.xpath(".//*[@class=\"g-title g-title-elipsis\"]/a")).getText().contains(name)){
                iter.findElement(By.xpath(".//*[@class=\"g-buy\"]")).click();
                Wait(10000);
                break;}
            i++;
        }
    }
    public static void goToBasket(Rozetka page){
        waitForClick(page.get_driver(), page.getBucket(), 5);
        page.getBucket().click();
    }
}
