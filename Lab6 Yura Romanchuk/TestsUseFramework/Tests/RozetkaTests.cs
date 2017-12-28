using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using PageObjects.Pages;

namespace TestsUseFramework.Tests
{
    [TestClass]
    public class RozetkaTests
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
        }

        [TestCleanup]
        public void TestFinalize()
        {
            driver.Close();
        }

        [TestMethod]
        public void RozetkaTest()
        {
            //Arrange
            var booksPage = new RozetkaBooksPage(driver);
            var bookResultPage = new RozetkaSelectedBookPage(driver);
            var minPriceValueToSet = 20;

            //Act
            booksPage
                .SetMinimumPrice(minPriceValueToSet).SubmitPriceFilter();
            var maxprice = bookResultPage.GetMaxPrice();
            booksPage.ClickOnFirstElement();
            var price = bookResultPage.GetPrice();

            //Assert
            Assert.IsTrue(price>=minPriceValueToSet && price<=maxprice);

        }
    }
}
