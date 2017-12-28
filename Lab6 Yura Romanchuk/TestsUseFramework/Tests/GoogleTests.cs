using System;
using System.Drawing.Imaging;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using PageObjects.Pages;
using Tests;

namespace Google.Tests.Tests
{
    [TestClass]
    public class GoogleTests
    {
        private IWebDriver driver;
        private string _url = "https://google.com";

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
        public void GoogleTest1()
        {
            //Arrange
            var ResultsPage = new GoogleHomePage(driver);
            string word = "Кнопка";
            string word1 = "канцтовари";
            bool isCorrect1;
            bool isCorrect2=true;
            int count = 2;
            var Res = new GoogleSearchPages(driver);

            //Act
            ResultsPage.SetWord(word).SubmitSearchWord();
            do
            {
                isCorrect1 = Res.ListPages(count);
                if(isCorrect1) isCorrect2 = Res.FindWord(word1);
                if (isCorrect2)
                {
                    Console.WriteLine("Number of Page - " + count);
                    string screenshot = @"C:\Users\Юрий\Documents\Visual Studio 2015\Projects\Lab6 Yura Romanchuk\Screenshot_1\screen.png";
                    Res.GetEntereScreenshot().Save(screenshot, ImageFormat.Png);
                }
                    
                count++;
            } while (isCorrect1 && !isCorrect2);

            //Assert
            Assert.IsTrue(isCorrect2);
        }

        [TestMethod]
        public void GoogleTest2()
        {
            //Arrange
            var ResultsPage = new GoogleHomePage(driver);
            string word = "хостинг";
            string word1 = "HostPro";
            var Res = new GoogleSearchPages(driver);

            //Act
            ResultsPage.SetWord(word).SubmitSearchWord();
            var result = Res.FindWord(word1);
            if (result)
            {
                string screenshot = @"C:\Users\Юрий\Documents\Visual Studio 2015\Projects\Lab6 Yura Romanchuk\Screenshot_2/screen.png";
                Res.GetEntereScreenshot().Save(screenshot, ImageFormat.Png);
                Console.WriteLine("Number of Page - 1");
            }

            //Assert
            Assert.IsTrue(result);
        }

        [TestMethod]
        public void GoogleTest3()
        {
            //Arrange
            var ResultsPage = new GoogleHomePage(driver);
            string word = "анальгін";
            string word1 = "bayer";
            bool isCorrect1=true;
            bool isCorrect2;
            int count = 2;
            var Res = new GoogleSearchPages(driver);

            //Act
            ResultsPage.SetWord(word).SubmitSearchWord();
            do
            {
                isCorrect2 = Res.FindWord(word1);
                if (!isCorrect2)
                {
                    string screenshot = @"C:\Users\Юрий\Documents\Visual Studio 2015\Projects\Lab6 Yura Romanchuk\Screenshot_3/screen_" + (count-1) + ".png";
                    Res.GetEntereScreenshot().Save(screenshot, ImageFormat.Png);
                    isCorrect1 = Res.ListPages(count);
                }
                count++;
            } while (isCorrect1 && !isCorrect2);

            //Assert
            Assert.IsTrue(!isCorrect2);
        }
    }
}
