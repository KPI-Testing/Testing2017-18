using TestFramework.Pages;
using TestFramework.Extensions;
using System;
using OpenQA.Selenium;

namespace TestFramework.Contexts
{
    public static class ResultSetContext
    {
        public static void SelectElement(FilterPage page, int elementIndex)
        {
            Action <IWebElement>act0 = (elem) => elem.Click();
            WaitingExtensions.WaitUntilElementAppears(act0, page.ResultSet[elementIndex]);
        }

        public static void BuyElement(FilterPage page, int elementIndex)
        {
            Action<IWebElement> act0 = (elem) => elem.Click();
            WaitingExtensions.WaitUntilElementAppears(act0, page.BuyButtonSet[elementIndex]);
        }
    }
}
