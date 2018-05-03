package Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Check_List extends Element {

    public Check_List(WebElement check_list) { super(check_list); }

    public Check_List select_from_check_list(String name) {
        open_check_list();
        select_check_box(name);
        return this;
    }

    private Check_List open_check_list() {
        if(getAttribute("class").contains("hidden")) findElement(By.tagName("span")).click();
        return this;
    }

    private Check_List select_check_box(String name) {
        List<WebElement> check_boxes = findElements(By.tagName("li"));
        for (WebElement element: check_boxes){
            if (element.getText().contains(name)){
                Check_Box check_box = new Check_Box(element);
                check_box.select();
                break;
            }
        }
        return this;
    }
}
