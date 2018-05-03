using OpenQA.Selenium;
using System;
using TestFramework.Extensions;
using TestFramework.Pages;

namespace TestFramework.Contexts
{
    public static class BasketContext
    {
        public static void ProceedToCheckout(BasketPage page,int howlongIcnwait)
        {
            Action<IWebElement> act0 = (elem) => elem.Click();
            WaitingExtensions.WaitUntilElementAppears(act0, page.ProceedAnOrder,howlongIcnwait);
        }
    }
}