using FluentAssertions;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Support.UI;
using System;
using System.Threading;
using TestFramework.Contexts;
using TestFramework.Pages;

namespace TestsUseFramework
{
    [TestClass]
    public class UnitTest1
    {
        private IWebDriver driver;
        private string _url = "https://rozetka.com.ua/hudojestvennaya-literatura/c4326593/";

        [TestInitialize]
        public void TestInitialize()
        {
            var options = new ChromeOptions();
            options.AddArgument("start-maximized");

            driver = new ChromeDriver(options);
            driver.Navigate().GoToUrl(_url);
            new WebDriverWait(driver, TimeSpan.FromSeconds(5)).Until(d => d.Url == _url);
            Thread.Sleep(10000);
        }

        [TestCleanup]
        public void TestFinalize()
        {
            driver.Close();
        }

        [TestMethod]
        public void NegativeMinPriceShouldUpdatePriceToMinimalAvailable()
        {
            //Arrange
            var booksResultsPage = new FilterPage(driver);
            var minPriceValueToSet = 20;
            var maxPriceValueToSet = 250;

            //Act
            FilteringContext.FilterByPriceRange(booksResultsPage, minPriceValueToSet, maxPriceValueToSet);

            //Assert
            (FilteringContext.VerifyMinPriceValue(booksResultsPage, minPriceValueToSet) 
                && FilteringContext.VerifyMaxPriceValue(booksResultsPage, maxPriceValueToSet)).Should().BeTrue();
        }

        [TestMethod]
        public void FilterByPrice()
        {
            //Arrange
            var booksResultsPage = new FilterPage(driver);
            var bookPage = new GoodsItemPage(driver);
            var minpriceValueToSet = 20;
            var maxpriceValueToSet = 250;

            //Act
            FilteringContext.FilterByPriceRange(booksResultsPage, minpriceValueToSet, maxpriceValueToSet);
            ResultSetContext.SelectElement(booksResultsPage, 0);

            //Assert
            GoodStateVerificationContext.VerifyItemPrice(bookPage, minpriceValueToSet, maxpriceValueToSet);
        }
    }
}
