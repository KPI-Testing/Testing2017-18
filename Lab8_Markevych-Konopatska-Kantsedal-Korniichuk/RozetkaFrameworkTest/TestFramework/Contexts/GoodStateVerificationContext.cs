using TestFramework.Pages;
using FluentAssertions;
using OpenQA.Selenium;
using System;
using TestFramework.Extensions;

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

        public static void VerifyMakeOrderIsClickable(CheckoutPage page)
        {
            Action<IWebElement> act = (elem) => { };
            WaitingExtensions.DoUntilElementIsDisplayed(act,page.DeliveryBlock, true);
            page.MakeOrderButton.Displayed.Should().BeTrue();
        }

        public static void VerifyItemNameInCart(GoodsItemPage page, string name)
        {
            page.GetName().Should().Equals(name);
        }

        public static void VerifyItemPriceInCart(GoodsItemPage page, int price)
        {
            page.GetPrice().Should().Equals(price);
        }

        public static void VerifyProductImageInCart(GoodsItemPage page, string  src)
        {
            page.GetImageSrc().Should().Equals(src);
        }

        public static void ProductIsDeleted(CartPageWithoutOrders page)
        {
            page.CartIsEmpty.Displayed.Should().BeTrue();
        }

    }
}
