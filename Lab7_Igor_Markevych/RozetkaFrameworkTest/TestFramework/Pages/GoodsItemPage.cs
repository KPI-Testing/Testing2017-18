using OpenQA.Selenium;
using OpenQA.Selenium.Support.PageObjects;
using TestFramework.Elements;

namespace TestFramework.Pages
{
    public class GoodsItemPage
    {
        private IWebDriver _driver;

        public GoodsItemPage(IWebDriver driver)
        {
            _driver = driver;
            PageFactory.InitElements(driver, this);
        }

        [FindsBy(How = How.Id, Using = "price_label")]
        private IWebElement tempPrice;
        public HtmlLabel Price => new HtmlLabel(tempPrice);

        public int? GetPrice()
        {
            var stringValue = Price.GetText();
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