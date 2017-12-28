using OpenQA.Selenium;
using OpenQA.Selenium.Support.PageObjects;
using TestFramework.Elements;

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

        public IWebDriver GetDriver()
        {
            return _driver;
        }

        [FindsBy(How = How.CssSelector, Using = ".hub-i-link.hub-i-cart-link")]
        private IWebElement tempCart;
        public Button Cart => new Button(tempCart);

    }
}
