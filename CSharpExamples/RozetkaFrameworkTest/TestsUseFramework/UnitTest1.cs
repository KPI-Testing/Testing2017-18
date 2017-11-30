using FluentAssertions;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Support.UI;
using System;
using System.Threading;
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
            var booksResultsPage = new FictionBooksPage(driver);
            var minPriceValueToSet = 20;
            var maxPriceValueToSet = 250;

            //Act
            booksResultsPage
                .SetPrice(minPriceValueToSet, maxPriceValueToSet).SubmitPriceFilter();

            var actualMinimumPrice = booksResultsPage.GetMinPrice();
            var actualMaximumPrice = booksResultsPage.GetMaxPrice();

            //Assert
            actualMinimumPrice.Should().Be(minPriceValueToSet);
            actualMaximumPrice.Should().Be(maxPriceValueToSet);
        }

    //    [TestMethod]
    //    public void SortByPrice()
    //    {
    //        //Arrange
    //        var booksResultsPage = new FictionBooksPage(driver);
    //        var minPriceValueToSet = 20;
    //        var maxPriceValueToSet = 250;

    //        //Act
    //        booksResultsPage
    //            .SetPrice(minPriceValueToSet, maxPriceValueToSet).SubmitPriceFilter();

    //        booksResultsPage.ResultSet.First().Click();
            
    //        Assert.IsTrue((booksResultsPage.GetPrice()>=20) && (booksResultsPage.GetPrice() <= 250));
    //}
    }
}
