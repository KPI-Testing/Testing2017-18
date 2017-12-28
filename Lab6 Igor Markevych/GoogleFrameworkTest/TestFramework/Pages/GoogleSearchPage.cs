using OpenQA.Selenium;
using OpenQA.Selenium.Support.PageObjects;

namespace TestFramework.Pages
{
    public class GoogleSearchPage
    {
        private IWebDriver _driver;


        public GoogleSearchPage(IWebDriver driver)
        {
            _driver = driver;
            PageFactory.InitElements(driver, this);
        }


        [FindsBy(How = How.Id, Using = "lst-ib")]
        public IWebElement SearchField;

        public GoogleSearchPage Search (string searchname)
        {
            SearchField.SendKeys(searchname + Keys.Enter);
            return this;
        }

 

    }
}
