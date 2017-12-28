using OpenQA.Selenium;
using OpenQA.Selenium.Support.PageObjects;
using TestFramework.Elements;

namespace TestFramework.Pages
{
    public class BasketPage : BasePage
    {
        public BasketPage(IWebDriver driver) : base(driver)
        {}

        [FindsBy(How = How.Id, Using = "popup-checkout")]
        private IWebElement tempProceedAnOrder;
        public Button ProceedAnOrder => new Button(tempProceedAnOrder);


    }
}
