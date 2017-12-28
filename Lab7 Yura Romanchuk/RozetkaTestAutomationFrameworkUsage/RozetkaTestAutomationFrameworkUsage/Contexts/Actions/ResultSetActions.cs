using OpenQA.Selenium;
using RozetkaTestAutomationFrameworkUsage.Pages;
using RozetkaTestAutomationFrameworkUsage.Utils;
using System.Threading;

namespace RozetkaTestAutomationFrameworkUsage.Contexts.Actions
{
    public static class ResultSetActions
    {
        public static void SelectElement(WineListPage page, int elemetIndex, Waiters wait)
        {
            wait.waitForVisibilityElement(By.CssSelector(page.locResSet));
            page.ResultSet[elemetIndex].Click();
        }
    }
}
