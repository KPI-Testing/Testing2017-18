using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Support.UI;
using System;
using TechTalk.SpecFlow;
using TestFramework.Pages;

namespace TestsUseFramework.SpecFlow.StepDefs
{
    [Binding]
    public sealed class Driver_init
    {
        // For additional details on SpecFlow hooks see http://go.specflow.org/doc-hooks

        private static IWebDriver driver;

        [BeforeTestRun]
        public static void BeforeTestRun()
        {
            string _url = "https://rozetka.com.ua/hudojestvennaya-literatura/c4326593/";
            var options = new ChromeOptions();
            options.AddArgument("start-maximized");
            //options.AddArgument("--headless");
            driver = new ChromeDriver(options);
            driver.Navigate().GoToUrl(_url);
            new WebDriverWait(driver, TimeSpan.FromSeconds(60)).Until(driver1 => ((IJavaScriptExecutor)driver).ExecuteScript("return document.readyState").Equals("complete"));
        }

        public static FilterPage booksResultsPage = new FilterPage(driver);
        public static GoodsItemPage SingleBookPage = new GoodsItemPage(driver);
        public static CartPageWithOrders BasketPageWithOrders = new CartPageWithOrders(driver);
        public static CartPageWithoutOrders BasketPageWithoutOrders = new CartPageWithoutOrders(driver);
        public static CheckoutPage CheckoutPage = new CheckoutPage(driver);


        [BeforeScenario]
        public void BeforeScenario()
        {
            string _url = "https://rozetka.com.ua/hudojestvennaya-literatura/c4326593/";
            driver.Navigate().GoToUrl(_url);
        }


        [AfterTestRun]
        public void AfterTestRun()
        {
            //TODO: implement logic that has to run after executing each scenario
            Driver_init.driver.Close();
        }
    }
}
