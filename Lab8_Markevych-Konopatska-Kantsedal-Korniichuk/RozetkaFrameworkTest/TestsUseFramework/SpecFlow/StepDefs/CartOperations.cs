using System;
using TechTalk.SpecFlow;
using TestFramework.Contexts;

namespace TestsUseFramework.SpecFlow.StepDefs
{
    [Binding]
    public class CartOperations
    {
        [When(@"You enter (.*) in the (.*) field with number of the product")]
        public void WhenYouEnterInTheFieldWithNumberOfTheProduct(string p0, int p1)
        {
            CartContext.EnterInQuantityField(Driver_init.BasketPageWithOrders, p0, p1);
        }
    }
}
