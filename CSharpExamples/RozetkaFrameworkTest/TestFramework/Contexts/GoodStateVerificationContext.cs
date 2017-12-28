using TestFramework.Pages;
using FluentAssertions;

namespace TestFramework.Contexts
{
    public static class GoodStateVerificationContext
    {
        public static void VerifyItemPrice(GoodsItemPage page, int minExpectedValue, int maxExpectedValue)
        {
            var actualPrice = page.GetPrice();
            actualPrice.Should().BeGreaterOrEqualTo(minExpectedValue);
            actualPrice.Should().BeLessOrEqualTo(maxExpectedValue);
        }
    }
}
