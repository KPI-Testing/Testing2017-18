using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using RozetkaTestAutomationFrameworkUsage.Pages;
using RozetkaTestAutomationFrameworkUsage.Contexts.Actions;
using RozetkaTestAutomationFrameworkUsage.Helpers;
using RozetkaTestAutomationFrameworkUsage.Utils;
using OpenQA.Selenium.Support.UI;
using System;
using RozetkaTestAutomationFrameworkUsage.Contexts.States;

namespace Rozetka.Tests
{
    [TestClass]
    public class UnitTest1
    {
        private IWebDriver driver;
        private string _url = "https://rozetka.com.ua/vino/c4594285/filter/";

        [TestInitialize]
        public void TestInitialize()
        {
            var options = new ChromeOptions();
            options.AddArgument("start-maximized");

            driver = new ChromeDriver(options);
            driver.Navigate().GoToUrl(_url);
            new WebDriverWait(driver, TimeSpan.FromSeconds(60)).Until(driver1 => ((IJavaScriptExecutor)driver).ExecuteScript("return document.readyState").Equals("complete"));
        }

        [TestCleanup]
        public void TestFinalize()
        {
            driver.Close();
        }

        [TestMethod]
        public void ButtonIsDisplayed()
        {
            //Arrange
            var wineResultsPage = new WineListPage(driver);
            var goodPage = new GoodsItemPage(driver);
            var checkOutPage = new CheckOutPage(driver);
            var wait = new Waiters(driver);
            var country = "Украина";
            var user = new User();
            var minPriceValueToSet = 100;
            var maxPriceValueToSet = 2000;

            //Act
            FilteringActions.FilterByPriceRange(wineResultsPage, minPriceValueToSet, maxPriceValueToSet,wait);
            MainApllicationActions.ClickOnMore(wineResultsPage,wait).ChooseCountry(country,wait);
            ResultSetActions.SelectElement(wineResultsPage, 0,wait);
            MainApllicationActions.ClickOnButtonBuy(goodPage,wait).SubmitOfferButton(wait);
            AddUserDateActions.add(checkOutPage,user);
            MainApllicationActions.ClickOnButtonContinue(checkOutPage).ClickOnNotCall(wait);

            //Assert
            GoodVerificationStates.VerifyMakeOrderIsDispalyed(checkOutPage);
        }
    }
}
