using OpenQA.Selenium;
using OpenQA.Selenium.Support.PageObjects;

namespace TestFramework.Pages
{
    public class BasePage
    {
        protected IWebDriver _driver;

        public BasePage(IWebDriver driver)
        {
            _driver = driver;
            PageFactory.InitElements(driver, this);
        }
    }
}
