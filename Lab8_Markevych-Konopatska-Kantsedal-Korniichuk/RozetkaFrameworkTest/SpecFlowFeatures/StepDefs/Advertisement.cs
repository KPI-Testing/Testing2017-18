using TechTalk.SpecFlow;
using TestFramework.Contexts;

namespace TestsUseFramework.SpecFlow.StepDefs
{
    [Binding]
    public class Advertisement
    {
        public static string adtitle;
        public static string adsrc;

        [When(@"You click on any of the ads")]
        public void WhenYouClickOnAnyOfTheAds()
        {
            adtitle = Driver_init.CartPageWithoutOrders.AdvertisementSet[0].GetTitle();
            adsrc = Driver_init.CartPageWithoutOrders.AdvertisementSet[0].GetSourceLink();
            CartContext.ClickOnAd(Driver_init.CartPageWithoutOrders);
        }

        [Then(@"You are on the relevant ad page")]
        public void ThenYouAreOnTheRelevantAdPage()
        {
            GoodStateVerificationContext.VerifyAdPage(Driver_init.AdPage, adtitle, adsrc);
        }


    }
}
