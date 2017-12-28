using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Support.UI;
using System;
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
            new WebDriverWait(driver, TimeSpan.FromSeconds(15)).Until(d => d.Url == _url);
            //System.Threading.Thread.Sleep(10000);
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
            var booksResultsPage = new FictionBooksPage(driver);
            var priceValueToSet = -1;

            //Act
            booksResultsPage
                .SetMinimumPrice(priceValueToSet)
                .SubmitPriceFilter();

            //Assert
            var actualMinimumPrice = booksResultsPage.GetMinPrice();
            Assert.IsTrue(actualMinimumPrice - priceValueToSet > 0);
        }

        [TestMethod]
        public void FilterByPrice()
        {
            //Arrange
            var booksResultsPage = new FictionBooksPage(driver);
            var bookPage = new FictionSingleBookPage(driver);
            var minpriceValueToSet = 20;
            var maxpriceValueToSet = 250;

            //Act
            booksResultsPage
                .SetPrice(minpriceValueToSet, maxpriceValueToSet).SubmitPriceFilter();

            booksResultsPage.Element[0].Click();
            

            Assert.IsTrue((bookPage.GetPrice()>=minpriceValueToSet) && (bookPage.GetPrice() <= maxpriceValueToSet));
    }
    }
}
