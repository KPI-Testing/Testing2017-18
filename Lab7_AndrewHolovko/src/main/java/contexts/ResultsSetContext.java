package contexts;

import pages.ItemPage;
import pages.SledgesPage;

public class ResultsSetContext {
    public static ItemPage selectElement(SledgesPage page, int elementIndex){
        page.resultSet.get(elementIndex).click();
        return new ItemPage(page.getDriver());
    }
}
