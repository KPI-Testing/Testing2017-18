using OpenQA.Selenium;
using OpenQA.Selenium.Support.PageObjects;
using System.Collections.Generic;
using System;

namespace TestFramework.Pages
{
    public class ResultsPage
    {
        private IWebDriver _driver;

        public ResultsPage(IWebDriver driver)
        {
            _driver = driver;
            PageFactory.InitElements(driver, this);
        }

        [FindsBy(How = How.Id, Using = "pnnext")]
        public IWebElement NextPageButton;

        [FindsBy(How = How.XPath, Using = "//cite")]  
        public IList <IWebElement> Links;

       
        public ResultsPage TakeScreenshot(IWebDriver driver0) //taking screenshot with specified driver
        {
            driver0.Navigate().GoToUrl(_driver.Url);
            ((ITakesScreenshot)driver0).GetScreenshot().SaveAsFile("F:\\Новая папка (2)\\" + DateTime.Now.ToString().Replace(":"," -")+DateTime.Today.Millisecond+".png", ScreenshotImageFormat.Png);
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
            string[] orgparts = orgname.Split(new char[] { ' ', '.', '/', ':', '/', ',' }, System.StringSplitOptions.RemoveEmptyEntries);
            int j = 0;
            int c = 0;
            while (j < orgparts.Length)
            {
                string s = Links[i].Text.ToString();
                if (s.Contains(orgparts[j])) c++;
                j++;
            }
            if (c == orgparts.Length) return true;
            else return false;
        }
        public bool ItISOnPage(string orgname)
        {
            bool rez = false;
            for (int i = 0; i < Links.Count; i++)
            {
                if (ContainsOrgName(i, orgname))
                {
                    rez = true;
                    break;
                }
            }
            return rez;
        }

    }
}
