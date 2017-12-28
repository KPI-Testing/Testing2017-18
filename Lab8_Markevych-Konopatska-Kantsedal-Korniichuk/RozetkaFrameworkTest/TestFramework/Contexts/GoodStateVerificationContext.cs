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

        public static void VerifySellerImageInCart(GoodsItemPage page, string src)
        {
            page.GetSellerImageSrc().Should().Equals(src);
        }

        public static void ProductIsDeleted(CartPageWithoutOrders page)
        {
            page.CartIsEmpty.Displayed.Should().BeTrue();
        }

        public static void CartIsNotOpen(CartPageWithOrders page)
        {
            page.GetDriver().Url.Contains("cart").Should().BeFalse();
        }

        public static void TheQuantityOfProductEquals(CartPageWithOrders page, int n, string q)
        {
            page.AmountTextFieldSet[n].Text.Should().Equals(q);
        }

        public static void CheckoutPageIsOpen (CheckoutPage page)
        {
            page.GetDriver().Url.Should().Equals("https://my.rozetka.com.ua/ua/checkout/");
        }

        public static void VerifyAdPage(AdPage page, string title, string src)
        {
            (page.Image.GetSourceLink().Equals(src) && page.Image.GetTitle().Equals(title)).Should().BeTrue();
        }

        public static void CheckMarkOnSingleProductPage (GoodsItemPage page)
        {
            try
            {
                page.CheckMark.Displayed.Should().BeTrue();
            }
            catch (NoSuchElementException) { false.Should().BeTrue(); }
        }

        public static void PriceIsCorrectInCart(CartPageWithOrders page)
        {
            double sum = 0;
            for (int i=0; i<page.ProductsLinksSet.Count; i++)
            {
                sum += page.GetPriceForType(i) * page.GetQuantityForType(i);
            }
            sum.Should().Equals(page.TotalSum);
        }

        public static void DeleteButtonIsClickable (CartPageWithOrders page, int n)
        {
            (page.DeleteProductButtonsSet[n].Displayed && page.DeleteProductButtonsSet[n].Enabled).Should().BeTrue();
        }
    }
}
