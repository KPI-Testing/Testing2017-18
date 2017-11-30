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
            new WebDriverWait(driver, TimeSpan.FromSeconds(5)).Until(d => d.Url == _url);
            System.Threading.Thread.Sleep(10000);
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
        public void Sortbyprice()
        {
            //Arrange
            var booksResultsPage = new FictionBooksPage(driver);
            //var priceValueToSet = 20;

            //Act
            booksResultsPage
                .SetPrice(20, 250).SubmitPriceFilter();

            booksResultsPage.Element[0].Click();
            

            Assert.IsTrue((booksResultsPage.GetPrice()>=20) && (booksResultsPage.GetPrice() <= 250));
    }
    }
}
