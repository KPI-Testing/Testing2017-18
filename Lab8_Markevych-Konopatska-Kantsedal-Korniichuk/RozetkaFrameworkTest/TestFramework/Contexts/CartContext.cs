using OpenQA.Selenium;
using System;
using TestFramework.Extensions;
using TestFramework.Pages;

namespace TestFramework.Contexts
{
    public static class CartContext
    {
        public static void ProceedToCheckout(CartPageWithOrders page)
        {
            Action<IWebElement> act0 = (elem) => elem.Click();
            WaitingExtensions.WaitUntilElementAppears(act0, page.ProceedAnOrder);
        }

        public static void ClickPlusButton(CartPageWithOrders page, int n)
        {
            if (n !=0) { 
               Action<IWebElement> act0 = (elem) => elem.Click();
               WaitingExtensions.WaitUntilElementAppears(act0, page.AmountPlusButtonsSet[0]);
               for (int i = 0; i < n - 1; i++)
                act0(page.AmountPlusButtonsSet[0]);
             }
        }

        public static void ClickLinkOfProduct (CartPageWithOrders page, int n)
        {
            Action<IWebElement> act0 = (elem) => elem.Click();
            WaitingExtensions.WaitUntilElementAppears(act0, page.ProductsLinksSet[n]);
        }

        public static void EnterInQuantityField (CartPageWithOrders page, string s, int n)
        { 
            page.AmountTextFieldSet[n].SetValue(s);
            page.AmountTextFieldSet[n].SendKeys(Keys.Enter);
        }

        public static void ClickContinuePurchases(CartPageWithOrders page)
        {
            var url = page.GetDriver().Url;
            Action<IWebElement> act0 = (elem) => elem.Click();
            WaitingExtensions.WaitUntilElementAppears(act0, page.ProceedBuying);
            WaitingExtensions.WaitUntilUrlIsChanged(page, url);
        }

        public static void OpenCart(BasePage page)
        {
            page.Cart.Click();
        }

        public static void ClickOnAd(CartPageWithoutOrders page)
        {
            page.AdvertisementSet[0].Click();
        }

        public static void ClickDeleteProduct(CartPageWithOrders page, int n)
        {
            page.DeleteProductButtonsSet[n].Click();
        }

        public static void ClickDeleteWithoutSaving(CartPageWithOrders page, int n)
        {
            page.DeleteProductButtonsSet[n].Click();
        }

        public static void ClickWishList(CartPageWithOrders page, int n)
        {
            page.WishListButtonsSet[n].Click();
        }

        public static void ClickCancel(CartPageWithOrders page, int n)
        {
            page.CancelButtonsSet[n].Click();
        }

        public static void ClickCloseTheCart (BaseCartPage page)
        {
            page.CloseBasket.Click();
        }

    }
}