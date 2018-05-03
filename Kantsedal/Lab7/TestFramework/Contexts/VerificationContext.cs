using TestFramework.Pages;
using FluentAssertions;
using OpenQA.Selenium;
using System;
using TestFramework.Extensions;

namespace TestFramework.Contexts
{
    public static class VerificationContext
    {
        public static void VerifyItemPrice(GoodsItemPage page, int minExpectedValue, int maxExpectedValue)
        {
            var actualPrice = page.GetPrice();
            actualPrice.Should().BeGreaterOrEqualTo(minExpectedValue);
            actualPrice.Should().BeLessOrEqualTo(maxExpectedValue);
        }

        public static void VerifyMakeOrderIsClickable(CheckoutPage page)
        {
            Action<IWebElement> act = (elem) => { };
            WaitingExtensions.DoUntilElementIsDisplayed(act,page.DeliveryBlock, true);
            page.MakeOrderButton.Displayed.Should().BeTrue();
        }
    }
}
