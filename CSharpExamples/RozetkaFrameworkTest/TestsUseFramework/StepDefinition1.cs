using OpenQA.Selenium;
using OpenQA.Selenium.Support.UI;
using System;
using System.Collections.Generic;
using System.Threading;
using TechTalk.SpecFlow;
using TestFramework.Contexts;
using TestFramework.Pages;

namespace TestsUseFramework
{
    [Binding]
    public sealed class StepDefinition1
    {
        IWebDriver driver;
        WebDriverWait wait;
        // For additional details on SpecFlow step definitions see http://go.specflow.org/doc-stepdef

        [Given ("I am on the books page")]
        public void GivenIAmOnBooksPage()
        {
            var _url = "https://rozetka.com.ua/hudojestvennaya-literatura/c4326593/";
            driver = FeatureContext.Current.Get<IWebDriver>("driver");
            driver.Navigate().GoToUrl(_url);
            wait = new WebDriverWait(driver, TimeSpan.FromSeconds(5));
            wait.Until(d => d.Url == _url);
        }

        [Given("I filter items by price from (.*) to (.*)")]
        [When("I filter items by price from (.*) to (.*)")]
        public void WhenIFilter(int minPrice, int maxPrice)
        {
            var pageSource = driver.PageSource;
            var booksResultsPage = new FilterPage(driver);
            FilteringContext.FilterByPriceRange(booksResultsPage, minPrice, maxPrice);
            wait.Until(d => d.PageSource != pageSource);
            ScenarioContext.Current.Set(new KeyValuePair<int, int>(minPrice, maxPrice),"filterLimits");
        }

        [Then("first item price is inside limits")]
        public void ThenFilterIsCorrect()
        {
            var limits = ScenarioContext.Current.Get<KeyValuePair<int, int>>("filterLimits");
            var booksResultsPage = new FilterPage(driver);
            ResultSetContext.SelectElement(booksResultsPage, 0);
            var itemPage = new GoodsItemPage(driver);
            GoodStateVerificationContext.VerifyItemPrice(itemPage, limits.Key, limits.Value);
        }
    }
}
