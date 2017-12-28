using OpenQA.Selenium;
using OpenQA.Selenium.Support.PageObjects;
using TestFramework.Elements;

namespace TestFramework.Pages
{
    public class AdPage:BasePage
    {
        public AdPage(IWebDriver driver) : base(driver)
        { }

        [FindsBy(How = How.CssSelector, Using = ".promo-details-banner-image.responsive-img>img")]
        private IWebElement tempImage;
        public Image Image => new Image(tempImage);

        [FindsBy(How = How.CssSelector, Using = ".promo-details-banner-info-text")]
        private IWebElement tempPromoName;
        public Image PromoName => new Image(tempPromoName);

    }
}
