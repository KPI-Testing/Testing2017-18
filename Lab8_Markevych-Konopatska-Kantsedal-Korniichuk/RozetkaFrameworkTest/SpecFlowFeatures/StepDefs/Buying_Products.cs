using TechTalk.SpecFlow;
using TestFramework.Contexts;

namespace TestsUseFramework.SpecFlow.StepDefs
{
    [Binding]
    public class Buying_Products
    {
        [Given(@"Product is in the cart with quantity (.*)")]
        public void GivenProductIsInTheBasketWithQuantity(int q)
        {
            ResultSetContext.BuyElement(Driver_init.booksResultsPage, 0);
            CartContext.EnterInQuantityField(Driver_init.CartPageWithOrders, q.ToString(), 0);
        }

        [When(@"Open the cart")]
        public void WhenOpenTheCart()
        {
            CartContext.OpenCart(Driver_init.booksResultsPage);
        }

        [Given(@"The cart is open")]
        public void GivenTheCartIsOpen()
        {
            CartContext.OpenCart(Driver_init.booksResultsPage);
        }


    }
}
