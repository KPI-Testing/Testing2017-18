using FluentAssertions;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Support.UI;
using System;
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
        public void Buy()
        {
            //Arrange
            var minpriceValueToSet = 100;
            var maxpriceValueToSet = 2000;
            var name = "¿-¡¿-¡¿-√¿-À¿-Ã¿-√¿";
            int HowCanlongIwait = 15000;

            var booksResultsPage = new FilterPage(driver);
            var SingleBookPage = new GoodsItemPage(driver);
            var Basket = new BasketPage(driver);
            var Checkout = new CheckoutPage(driver);

            //Act        
            FilteringContext.FilterByPriceRange(booksResultsPage, minpriceValueToSet, maxpriceValueToSet, HowCanlongIwait);
            FilteringContext.ClickCheckbox(booksResultsPage, name, HowCanlongIwait);
            ResultSetContext.BuyElement(booksResultsPage, 0, HowCanlongIwait);
            BasketContext.ProceedToCheckout(Basket, HowCanlongIwait);
            CheckoutContext.InputReceiverData(Checkout, HowCanlongIwait);//modification with volid date
            //Assert
            VerificationContext.VerifyMakeOrderIsClickable(Checkout);
        }

    }
}
