using TestFramework.Pages;
using TestFramework.Extensions;
using System;
using OpenQA.Selenium;

namespace TestFramework.Contexts
{
    public static class ProductPageContext
    {
        public static void BuyElement(GoodsItemPage page, int elementIndex)
        {
            Action<IWebElement> act0 = (elem) => elem.Click();
            WaitingExtensions.WaitUntilElementAppears(act0, page.BuyButton);
        }
    }
}
