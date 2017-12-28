using System;
using TechTalk.SpecFlow;
using TestFramework.Contexts;
using TestsUseFramework.SpecFlow.StepDefs;

namespace SpecFlowFeatures.StepDefs
{
    [Binding]
    public class CheckMarkSteps
    {
        [Then(@"There will be a check mark near this product on product page")]
        public void ThenThereWillBeACheckMarkNearThisProductOnProductPage()
        {
            GoodStateVerificationContext.CheckMarkOnSingleProductPage(Driver_init.SingleBookPage);

        }
    }
}
