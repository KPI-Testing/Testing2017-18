using OpenQA.Selenium;
using System;
using TestFramework.Extensions;
using TestFramework.Pages;

namespace TestFramework.Contexts
{
    public static class FilteringContext
    {
        public static void FilterByPriceRange(FilterPage page, int? minPrice, int? maxPrice)
        {
            string url = page.GetDriver().Url;
            SetPrice(page, minPrice, maxPrice).SubmitPriceFilter();
            WaitingExtensions.WaitUntilUrlIsChanged(page, url);
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

        public static FilterPage ClickCheckbox(FilterPage page, string name)
        {
            string url = page.GetDriver().Url;
            Action<IWebElement> act0 = (elem) =>elem.Click();
            WaitingExtensions.WaitUntilElementAppears(act0, page.MoreIzdButton);
            if (!ConstantCollectionsExtensions.RussianLetters.Contains(name[0]))
                for (int i = 0; i < page.CheckboxIzdSet.Count; i++)
                {
                    if (page.CheckboxIzdSet[i].GetText().IndexOf(name+" (")==0)
                    {
                         if (page.CheckboxIzdSet[i].GetText().Equals(name + " (0)"))
                            throw new Exception("No products with such filtering parameters.");
                        page.CheckboxIzdSet[i].Click();
                        break;
                    }
                }
            else {
                int j=page.CheckboxIzdSet.Count;
                int i = 0;
                while (page.CheckboxIzdSet[i].GetText()[0]!=name[0])
                {
                    if (name[0]<page.CheckboxIzdSet[j / 2].GetText()[0])
                        j = (j-i) / 2;
                    else
                        i = i + (j-i) / 2 ;
                }
                int k = i-1;
                while (page.CheckboxIzdSet[k].GetText()[0] == name[0] && page.CheckboxIzdSet[k].GetText().IndexOf(name + " (") != 0)
                    k--;
                if (page.CheckboxIzdSet[k].GetText().IndexOf(name + " (") != 0)
                {
                    k = i + 1;
                    while (page.CheckboxIzdSet[k].GetText()[0] == name[0] && page.CheckboxIzdSet[k].GetText().IndexOf(name + " (") != 0)
                        k++;
                }

                if (page.CheckboxIzdSet[k].GetText().Equals(name + " (0)"))
                    throw new Exception("No products with such filtering parameters.");
                page.CheckboxIzdSet[k].Click();
            }
            WaitingExtensions.WaitUntilUrlIsChanged(page,url);
            return page;
        }
    }
}
