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
        private string _url = "https://rozetka.com.ua/quadrocopters/c1124685/";

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
        public void FilterByPrice()
        {
            //Arrange
            var ResultsPage = new QuadrPage(driver);
            var Page = new OneQuadrPage(driver);
            var minpriceValueToSet = 2000;
            var maxpriceValueToSet = 3000;

            //Act
            ResultsPage
                .SetPrice(minpriceValueToSet, maxpriceValueToSet).SubmitPriceFilter();

            ResultsPage.Element[0].Click();
            

            Assert.IsTrue((Page.GetPrice() >= minpriceValueToSet) && (Page.GetPrice() <= maxpriceValueToSet));
    }
    }
}
