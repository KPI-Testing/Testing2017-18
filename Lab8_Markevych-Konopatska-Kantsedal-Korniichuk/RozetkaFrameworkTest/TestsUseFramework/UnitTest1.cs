using FluentAssertions;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Support.UI;
using System;
/*using TestFramework.Contexts;
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
            //options.AddArgument("--headless");
            driver = new ChromeDriver(options);
            driver.Navigate().GoToUrl(_url);
            new WebDriverWait(driver, TimeSpan.FromSeconds(60)).Until(driver1 => ((IJavaScriptExecutor)driver).ExecuteScript("return document.readyState").Equals("complete"));
 
        }

        [TestCleanup]
        public void TestFinalize()
        {
            driver.Close();
            driver.Dispose();
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

        [TestMethod]
        public void BuyAProduct()
        {
            //Arrange
            var minpriceValueToSet = 100;
            var maxpriceValueToSet = 2000;
            var name = "‘ÓÎ≥Ó";

            var booksResultsPage = new FilterPage(driver);
            var SingleBookPage = new GoodsItemPage(driver);
            var Basket = new BasketPageWithOrders(driver);
            var Checkout = new CheckoutPage(driver);

            //Act        
            FilteringContext.FilterByPriceRange(booksResultsPage, minpriceValueToSet, maxpriceValueToSet);
            FilteringContext.ClickCheckbox(booksResultsPage, name);
            ResultSetContext.BuyElement(booksResultsPage, 0);
            BasketContext.ProceedToCheckout(Basket);
            CheckoutContext.InputReceiverData(Checkout, "Testik", "0980000001", "123df@dfs.com");
            //Assert
            GoodStateVerificationContext.VerifyMakeOrderIsClickable(Checkout);
        }

    }
}
*/