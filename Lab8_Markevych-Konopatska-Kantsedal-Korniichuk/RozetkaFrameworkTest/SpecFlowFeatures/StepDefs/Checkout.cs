using System;
using TechTalk.SpecFlow;
using TestFramework.Contexts;

namespace TestsUseFramework.SpecFlow.StepDefs
{
    [Binding]
    public class Checkout
    {
        [Then(@"The order processing window opens")]
        public void ThenTheOrderProcessingWindowOpens()
        {
            GoodStateVerificationContext.CheckoutPageIsOpen(Driver_init.CheckoutPage);
        }
    }
}
