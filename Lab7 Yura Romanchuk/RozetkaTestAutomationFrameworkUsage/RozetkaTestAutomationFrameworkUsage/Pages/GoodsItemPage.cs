using OpenQA.Selenium;
using OpenQA.Selenium.Support.PageObjects;
using RozetkaTestAutomationFrameworkUsage.Elements;

namespace RozetkaTestAutomationFrameworkUsage.Pages
{
    public class GoodsItemPage : BasePage
    {
        public GoodsItemPage(IWebDriver driver) : base(driver)
        { }
        public string locSubOffer = "popup-checkout";
        public string locBuy = "detail-buy-btn-container";

        [FindsBy(How = How.Id, Using = "price_label")]
        public IWebElement Price;

        [FindsBy(How = How.ClassName, Using = "detail-buy-btn-container")]
        private IWebElement _buy;
        public Button Buy => new Button(_buy);

        [FindsBy(How = How.Id, Using = "popup-checkout")]
        private IWebElement _submitoffer;
        public Button SubmitOffer => new Button(_submitoffer);

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
