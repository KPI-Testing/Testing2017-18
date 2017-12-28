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
            //Arrange
            String orgname = "hotline"; //organization to check name
            String searchname = "rozetka"; //string to search
            bool IsAssosiated = true;  //defines test for checking of association or unassotiation (if true, will take screenshot only for page, where organization link was found, if false - for every page)
            bool OnlyFirstPage = false; //if true, only first page will be checked, else - all

            //Act
            var ResultsPage = new FictionResultsPage(driver);
            var SearchPage = new GoogleSearchPage(driver);
            var pagenumber = 0;
            var boo = false;
            IWebDriver driver0 = new PhantomJSDriver();

            SearchPage.Search(searchname);

            do {
                pagenumber++;
                if (!IsAssosiated) ResultsPage.TakeScreenshot(driver0);
                if (ResultsPage.IsOnPage(orgname)){
                    boo = true;
                    if (IsAssosiated) ResultsPage.TakeScreenshot(driver0);
                    break;
                }
    
            } while ((ResultsPage.NextPage() && !OnlyFirstPage));
            
            //Assert
            driver0.Quit();
            Console.WriteLine("Number of checked pages: "+pagenumber);
            Assert.IsTrue(boo^!IsAssosiated);
        }

        
    }
}
