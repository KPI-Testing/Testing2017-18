using OpenQA.Selenium;
using OpenQA.Selenium.Support.PageObjects;

namespace TestFramework.Pages
{
    public class OneQuadrPage
    {
        private IWebDriver _driver;

        public OneQuadrPage(IWebDriver driver)
        {
            _driver = driver;
            PageFactory.InitElements(driver, this);
        }

        [FindsBy(How = How.Id, Using = "price_label")]
        public IWebElement Price;

        public int? GetPrice()
        {
            var stringValue = Price.Text;
            if (stringValue == null | stringValue == "")
                return null;
            else
            {
                int.TryParse(stringValue, out int result);
                return result;
            }
        }

    }
}