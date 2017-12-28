using OpenQA.Selenium;
using OpenQA.Selenium.Support.PageObjects;
using TestFramework.Elements;

namespace TestFramework.Pages
{
    public class BaseCartPage : BasePage
    {
        public BaseCartPage(IWebDriver driver) : base(driver)
        { }

        [FindsBy(How = How.CssSelector, Using = ".popup-close-icon.sprite")]
        private IWebElement tempCloseBasket;
        public Button CloseBasket => new Button(tempCloseBasket);
    }
}
