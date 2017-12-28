using System;
using TestFramework.Pages;

namespace TestFramework.Contexts
{
    public static class FilteringContext
    {
        public static void FilterByPriceRange(FilterPage page, int? minPrice, int? maxPrice)
        {
            SetPrice(page, minPrice, maxPrice).SubmitPriceFilter();
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
    }
}