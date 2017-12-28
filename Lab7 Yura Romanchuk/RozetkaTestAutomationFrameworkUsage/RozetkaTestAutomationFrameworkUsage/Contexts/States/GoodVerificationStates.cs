using RozetkaTestAutomationFrameworkUsage.Pages;
using FluentAssertions;

namespace RozetkaTestAutomationFrameworkUsage.Contexts.States
{
    public static class GoodVerificationStates
    {
        public static void VerifyItemPrice(GoodsItemPage page, int minExpectedValue, int maxExpectedValue)
        {
            var actualPrice = page.GetPrice();
            actualPrice.Should().BeGreaterOrEqualTo(minExpectedValue);
            actualPrice.Should().BeLessOrEqualTo(maxExpectedValue);
        }

        public static void VerifyMakeOrderIsDispalyed(CheckOutPage page)
        {
            page.MakeOrder.Displayed.Should().BeTrue();
        }
    }
}
