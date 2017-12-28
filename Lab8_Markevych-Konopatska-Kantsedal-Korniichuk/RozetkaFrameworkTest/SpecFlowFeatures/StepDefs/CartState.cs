using System;
using TechTalk.SpecFlow;
using TestFramework.Contexts;

namespace TestsUseFramework.SpecFlow.StepDefs
{
    [Binding]
    public class CartState
    {
        [Then(@"The product shoud be deleted from the cart")]
        public void ThenTheProductShoudBeDeletedFromTheCart()
        {
            GoodStateVerificationContext.ProductIsDeleted(Driver_init.CartPageWithoutOrders);
        }

        [Then(@"The window of the cart will be closed")]
        public void ThenTheWindowOfTheCartWillBeClosed()
        {
            GoodStateVerificationContext.CartIsNotOpen(Driver_init.CartPageWithOrders);
        }

        [Then(@"The quantity of product should be (.*)")]
        public void ThenTheQuantityOfProductShouldBe(string p0)
        {
            GoodStateVerificationContext.TheQuantityOfProductEquals(Driver_init.CartPageWithOrders, 0, p0);
        }

        [Then(@"The price of product should be correct in cart")]
        public void ThenThePriceOfProductShouldBeCorrectInCart()
        {
            GoodStateVerificationContext.PriceIsCorrectInCart(Driver_init.CartPageWithOrders);
        }

        [Then(@"You can click cross near product")]
        public void ThenYouCanClickCrossNearProduct()
        {
            GoodStateVerificationContext.DeleteButtonIsClickable(Driver_init.CartPageWithOrders, 0);
        }

    }
}
