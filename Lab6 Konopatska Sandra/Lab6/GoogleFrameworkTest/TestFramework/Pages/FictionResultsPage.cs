using OpenQA.Selenium;
using OpenQA.Selenium.Support.PageObjects;
using System.Collections.Generic;
using System;

namespace TestFramework.Pages
{
    public class FictionResultsPage
    {
        private IWebDriver _driver;

        public FictionResultsPage(IWebDriver driver)
        {
            _driver = driver;
            PageFactory.InitElements(driver, this);
        }

        [FindsBy(How = How.Id, Using = "pnnext")]
        public IWebElement NextPageButton;

        [FindsBy(How = How.CssSelector, Using = "._Rm")]  
        public IList <IWebElement> Links;

       
        public FictionResultsPage TakeScreenshot(IWebDriver driver0) //taking screenshot with specified driver
        {
            driver0.Navigate().GoToUrl(_driver.Url);
            ((ITakesScreenshot)driver0).GetScreenshot().SaveAsFile("C:\\googletests\\"+DateTime.Now.ToString().Replace(":","-")+DateTime.Today.Millisecond+".png", ScreenshotImageFormat.Png);
            return this;
        }

        public bool NextPage()
        {
            try
                {
                    NextPageButton.Click();
                    return true;
                }
            catch (NoSuchElementException)
                {
                    return false;
                }
         }

        public bool ContainsOrgName(int i, string orgname)
        {
            return (0==Links[i].Text.IndexOf(orgname+".") || Links[i].Text.Contains("."+orgname+".") || Links[i].Text.Contains("/" + orgname + "."))&&!Links[i].Text.Contains("..."+orgname+"...");    
        }

        public bool IsOnPage (string name)
        {
            bool boolka = false;
            for (int i = 0; i < Links.Count; i++)
            {
                
                if (ContainsOrgName(i, name))
                {
                    boolka = true;
                    break;
                }
            }
            return boolka;
        }

    }
}
