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
            new WebDriverWait(driver, TimeSpan.FromSeconds(30)).Until(d => d.Url == _url);
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
        public void DiapasonFinder()
        {
            //Arrange
            var booksResultsPage = new FictionBooksPage(driver);
            var pricemin= 20;
            var pricemax = 100;

            //Act
            booksResultsPage

                .ClearMinPrice().SetMinimumPrice(pricemin)
                .ClearMaxPrice().SetMaximumPrice(pricemax)
                .SubmitPriceFilter().SomeBookClick(2);
            var bookpage = new Bookshell(driver);

            //Assert
            var actua = bookpage.GetPrice();
            //Console.WriteLine(actualMinimumPrice);
            Assert.IsTrue((actua <= pricemax)&&(actua>=pricemin));
        }

    }

}
