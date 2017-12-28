using System;
using TechTalk.SpecFlow;
using TestFramework.Contexts;
using TestsUseFramework.SpecFlow.StepDefs;

namespace SpecFlowFeatures.StepDefs
{
    [Binding]
    public class Common
    {
        [When(@"Go to previous page")]
        public void WhenGoToPreviousPage()
        {
            CommonContext.PreviousPage(Driver_init.booksResultsPage);
        }
    }
}
