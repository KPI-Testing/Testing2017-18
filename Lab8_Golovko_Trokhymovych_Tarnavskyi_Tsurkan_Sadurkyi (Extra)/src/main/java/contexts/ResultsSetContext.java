package contexts;

import pages.CartPage;
import pages.ItemPage;
import pages.SledgesPage;

public class ResultsSetContext {
    public static ItemPage selectElement(SledgesPage page, int elementIndex){
        page.resultSet.get(elementIndex).click();
        return new ItemPage(page.getDriver());
    }

    public static CartPage buyElement(SledgesPage page, int elementIndex){
        page.resultSetBuy.get(elementIndex).click();
        return new CartPage(page.getDriver());
    }
}
