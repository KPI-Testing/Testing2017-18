using OpenQA.Selenium;
using OpenQA.Selenium.Support.PageObjects;

namespace PageObjects.Pages
{
    public  class RozetkaSelectedBookPage : RozetkaBooksPage
    {
        public RozetkaSelectedBookPage(IWebDriver driver) : base(driver)
        { }

        [FindsBy(How = How.Id, Using = "price_label")]
        public IWebElement Price;

        public int? GetPrice()
        {
            var stringValue = Price.Text;
            if (stringValue == null | stringValue == "")
                return null;
            else
            {
                int result;
                int.TryParse(stringValue, out result);
                return result;
            }
        }
    }
}
