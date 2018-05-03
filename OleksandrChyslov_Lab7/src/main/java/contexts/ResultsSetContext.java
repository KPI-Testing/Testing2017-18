package contexts;

import pages.ItemPage;
import pages.FridgesPage;

public class ResultsSetContext {
    public static ItemPage selectElement(FridgesPage page, int elementIndex){
        page.resultSet.get(elementIndex).click();
        return new ItemPage(page.getDriver());
    }
}
