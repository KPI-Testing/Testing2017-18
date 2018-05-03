package contexts;

import pages.Item;
import pages.Sledges;

public class SetResults {
    public static Item selectElement(Sledges page, int elementIndex){
        page.resultSet.get(elementIndex).click();
        return new Item(page.getDriver());
    }
}
