package contexts;

import org.testng.Assert;
import pages.CartPage;

public class CartContextAsserts {

    public static void assertQuantity(CartPage page, int index, int quantity){
        assertTrueOrSendMessage("quantity at position "+index+" is incorrect", page.getQuantity(index) == quantity);
    }

    public static void assertName(CartPage page, int index, String name){
        assertTrueOrSendMessage("name at position "+index+" is incorrect. Expected is "+name+". Actual is "+page.getName(index), page.getName(index).equals(name));
    }

    public static void assertCalculations(CartPage page){
        int numberOfPositions = page.getNumberOfPositions();
        int totalSum = 0;
        for (int i = 0; i < numberOfPositions; ++i) {
            assertTrueOrSendMessage("price sum at position "+i+" is incorrect",page.getPriceOf(i) * page.getQuantity(i) == page.getSum(i));
            totalSum += page.getSum(i);
        }
        assertTrueOrSendMessage("price total sum is incorrect", page.getPrice() == totalSum);
    }

    private static void assertTrueOrSendMessage(String message, boolean statement){
        if (!statement){
            System.out.println(message);
            Assert.fail();
        }
    }
}
