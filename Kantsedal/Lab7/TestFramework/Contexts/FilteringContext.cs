using OpenQA.Selenium;
using System;
using TestFramework.Extensions;
using TestFramework.Pages;

namespace TestFramework.Contexts
{
    public static class FilteringContext
    {
        public static void FilterByPriceRange(FilterPage page, int? minPrice, int? maxPrice,int howlongIcnwait)
        {
            string url = page.GetDriver().Url;
            SetPrice(page, minPrice, maxPrice).SubmitPriceFilter();
            WaitingExtensions.WaitUntilUrlIsChanged(page, url, howlongIcnwait);
        }

        public static FilterPage SetPrice(this FilterPage page, int? MinPrice, int? MaxPrice)
        {
            page.SetMinimumPrice(MinPrice);
            page.SetMaximumPrice(MaxPrice);
            return page;
        }

        public static FilterPage SubmitPriceFilter(this FilterPage page)
        {
            page.FilterByPrice.Click();
            return page;
        }

        public static bool VerifyMinPriceValue(FilterPage page, int expectedValue)
        {
            Console.WriteLine($"Actual minimum price {page.GetMinPrice()}, expected {expectedValue}");
            return page.GetMinPrice().Equals(expectedValue);
        }

        public static bool VerifyMaxPriceValue(FilterPage page, int expectedValue)
        {
            Console.WriteLine($"Actual maximum price {page.GetMaxPrice()}, expected {expectedValue}");
            return page.GetMaxPrice().Equals(expectedValue);
        }
        public static int SerchStandurt (FilterPage page, string name)
        {
           
            for (int i = 0; i < page.Publishing.Count; i++)
            {
                if (page.Publishing[i].GetText().IndexOf(name + " (") == 0)
                {
                    if (page.Publishing[i].GetText().Equals(name + " (0)"))
                        throw new Exception("No products with such filtering parameters.");
                    return i;
                }
            }
            return -1;
        }

        public static FilterPage ClickCheckbox(FilterPage page, string name,int howlongIcnwait)
        {
            string url = page.GetDriver().Url;
            Action<IWebElement> act0 = (elem) =>elem.Click();
            WaitingExtensions.WaitUntilElementAppears(act0, page.MoreIzdButton, howlongIcnwait);
            int i = SerchStandurt(page, name);
            if (i == -1) throw new Exception("No products with such filtering parameters.");
            page.Publishing[i].Click();
            WaitingExtensions.WaitUntilUrlIsChanged(page,url, howlongIcnwait);
            return page;
        }
    }
}
