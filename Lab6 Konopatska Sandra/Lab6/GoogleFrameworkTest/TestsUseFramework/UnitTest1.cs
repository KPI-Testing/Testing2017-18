using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.PhantomJS;
using OpenQA.Selenium.Support.UI;
using System;
using TestFramework.Pages;


namespace TestsUseFramework
{
    [TestClass]
    public class UnitTest1
    {
        private IWebDriver driver;
        private string _url = "https://www.google.com.ua";

        [TestInitialize]
        public void TestInitialize()
        {
            ChromeOptions options = new ChromeOptions();
            options.AddArgument("--headless");
            driver = new ChromeDriver(options);
            driver.Navigate().GoToUrl(_url);
            new WebDriverWait(driver, TimeSpan.FromSeconds(60)).Until(driver1 => ((IJavaScriptExecutor)driver).ExecuteScript("return document.readyState").Equals("complete"));
         }

        [TestCleanup]
        public void TestFinalize()
        {
            driver.Quit();
        }

        [TestMethod]
        public void GoogleAssociation()  
        {
            String check = "karabas.com";
            String search = "sentrum";
            bool IsAssosiated = true;  //defines test for checking of association or unassotiation (if true, will take screenshot only for page, where organization link was found, if false - for every page)
            bool OnlyFirstPage = false; //if true, only first page will be checked, else - all

            var ResultsPage = new FictionResultsPage(driver);
            var SearchPage = new GoogleSearchPage(driver);
            var page = 0;
            var b = false;
            IWebDriver driver0 = new PhantomJSDriver();

            SearchPage.Search(search);

            do {
                page++;
                if (!IsAssosiated) ResultsPage.TakeScreenshot(driver0);
                if (ResultsPage.IsOnPage(check)){
                    b = true;
                    if (IsAssosiated) ResultsPage.TakeScreenshot(driver0);
                    break;
                }
    
            } while ((ResultsPage.NextPage() && !OnlyFirstPage));
            
            driver0.Quit();
            Assert.IsTrue(b^!IsAssosiated);
        }

        
    }
}
