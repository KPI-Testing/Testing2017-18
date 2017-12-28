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
            GoodStateVerificationContext.ProductIsDeleted(Driver_init.BasketPageWithoutOrders);
        }
    }
}
