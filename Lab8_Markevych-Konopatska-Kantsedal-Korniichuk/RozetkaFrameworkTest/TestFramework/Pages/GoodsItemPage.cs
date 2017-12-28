using OpenQA.Selenium;
using OpenQA.Selenium.Support.PageObjects;
using TestFramework.Elements;

namespace TestFramework.Pages
{
    public class GoodsItemPage :BasePage
    {
        private IWebDriver _driver;

        public GoodsItemPage(IWebDriver driver) : base (driver)
        {}

        [FindsBy(How = How.Id, Using = "price_label")]
        private IWebElement tempPrice;
        public HtmlLabel Price => new HtmlLabel(tempPrice);

        [FindsBy(How = How.CssSelector, Using = "[name=\"topurchases\"]")]
        private IWebElement tempBuyButton;
        public Button BuyButton => new Button(tempBuyButton);

        [FindsBy(How = How.ClassName, Using = "detail-title")]
        private IWebElement tempName;
        public HtmlLabel Name => new HtmlLabel(tempName);

        [FindsBy(How = How.Id, Using = "base_image")]
        private IWebElement tempImage;
        public Image Image => new Image(tempImage);

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

        public string GetName()
        {
            return Name.GetText();
        }

        public string GetImageSrc()
        {
            return Image.GetSourceLink();
        }

    }
}