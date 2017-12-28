using OpenQA.Selenium;
using System;
using TestFramework.Extensions;
using TestFramework.Pages;

namespace TestFramework.Contexts

{
    public class CommonContext
    {
        public static void PreviousPage(BasePage page)
        {
            page.GetDriver().Navigate().Back();
        }
    }
}
