using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Support.UI;
using System;
using TechTalk.SpecFlow;

namespace TestsUseFramework
{
    [Binding]
    public sealed class Hooks1
    {
        [BeforeScenario]
        public void BeforeScenario()
        {
            var options = new ChromeOptions();
            options.AddArgument("start-maximized");

            var driver = new ChromeDriver(options);
            FeatureContext.Current.Set<IWebDriver>(driver, "driver");
        }

        [AfterScenario]
        public void AfterScenario()
        {
            var driver = FeatureContext.Current.Get<IWebDriver>( "driver");
            driver.Close();
        }
    }
}
