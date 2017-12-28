using RozetkaTestAutomationFrameworkUsage.Pages;
using RozetkaTestAutomationFrameworkUsage.Utils;
using OpenQA.Selenium;

namespace RozetkaTestAutomationFrameworkUsage.Contexts.Actions
{
    public static class FilteringActions
    {
        public static void FilterByPriceRange(WineListPage page, int? minPrice, int? maxPrice, Waiters wait)
        {
            SetPrice(page, minPrice, maxPrice).SubmitPriceFilter(wait);
        }

        public static WineListPage SetPrice(this WineListPage page, int? MinPrice, int? MaxPrice)
        {
            page.SetMinimumPrice(MinPrice);
            page.SetMaximumPrice(MaxPrice);
            return page;
        }

        public static WineListPage SubmitPriceFilter(this WineListPage page,Waiters wait)
        {
            wait.waitForClickableElement(By.Id(page.locFilter));
            page.FilterByPrice.Click();
            return page;
        }

    }
}
